package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.sql.DataSource;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.sql.TransactionCallback;
import com.eomcs.sql.TransactionTemplate;
import com.eomcs.util.Prompt;

public class PhotoBoardAddServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  LessonDao lessonDao;
  PhotoFileDao photoFileDao;
  DataSource conFactory;
  TransactionTemplate transactionTemplate;

  public PhotoBoardAddServlet(PhotoBoardDao photoBoardDao, LessonDao lessonDao,
      PhotoFileDao photoFileDao, DataSource conFactory, PlatformTransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.lessonDao = lessonDao;
    this.photoFileDao = photoFileDao;
    this.conFactory = conFactory;
    this.transactionTemplate = new TransactionTemplate(txManager);
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(Prompt.getString(in, out, "제목? "));
    int no = Prompt.getInt(in, out, "수업 번호? ");

    Lesson lesson = lessonDao.findByNo(no);

    if (lesson == null) {
      out.println("수업 번호가 유효하지 않습니다.");
      return;
    }

    photoBoard.setLesson(lesson);
    List<PhotoFile> photoFiles = inputPhotoFiles(in, out);

    transactionTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction() throws Exception {
        if (photoBoardDao.insert(photoBoard) == 0) {
          throw new Exception("사진 게시글 등록에 실패했습니다.");
        }
        for (PhotoFile photoFile : photoFiles) {
          photoFile.setBoardNo(photoBoard.getNo());
          photoFileDao.insert(photoFile);
        }
        out.println("새 사진 게시글을 등록했습니다.");
        return null;
      }
    });
  }

  private List<PhotoFile> inputPhotoFiles(Scanner in, PrintStream out) {
    out.println("최소 한 개의 사진 파일을 등록해야 합니다.");
    out.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

    List<PhotoFile> photoFiles = new ArrayList<>();

    while (true) {
      String filepath = Prompt.getString(in, out, "사진 파일? ");

      if (filepath.length() == 0) {
        if (photoFiles.size() > 0) {
          break;
        } else {
          out.println("최소 한 개의 사진 파일을 등록해야 합니다.");
          continue;
        }
      }

      photoFiles.add(new PhotoFile().setFilepath(filepath));
    }
    return photoFiles;
  }
}

