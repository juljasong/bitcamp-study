package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;
import com.eomcs.util.RequestMapping;

@Component
public class PhotoBoardListServlet {

  PhotoBoardService photoBoardService;
  LessonService lessonService;

  public PhotoBoardListServlet(PhotoBoardService photoBoardService, LessonService lessonService) {
    this.photoBoardService = photoBoardService;
    this.lessonService = lessonService;
  }

  @RequestMapping("/photoboard/list")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    int lessonNo = Integer.parseInt(params.get("no"));

    Lesson lesson = lessonService.get(lessonNo);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("   <meta charset='UTF-8'>");
    out.println("   <title>사진 게시글 목록</title>");
    out.println("</head>");
    out.println("<body>");
    if (lesson == null) {
      out.println("<p>수업 번호가 유효하지 않습니다.</p>");
      out.println("<meta http-equiv='refresh' content='2;url=/photoboard/listform'>");
      return;
    } else {
      out.println("   <h1>사진 게시글</h1>");
      out.println("   <a href='/photoboard/addForm'>새 사진 게시글</a><br>");
      out.println("   <table border='1'>");
      out.println("       <tr>");
      out.println("           <th>번호</th>");
      out.println("            <th>제목</th>");
      out.println("           <th>등록일</th>");
      out.println("           <th>조회수</th>");
      out.println("       </tr>");


      out.printf("수업명: %s\n", lesson.getTitle());

      List<PhotoBoard> photoBoards = photoBoardService.listOfLesson(lessonNo);

      for (PhotoBoard b : photoBoards) {
        out.printf(
            "<tr><td>%d</td> <td><a href='/photoboard/detail?no=%d'>%s</a></td> <td>%s</td> <td>%d</td></tr>\n",
            b.getNo(), b.getNo(), b.getTitle(), b.getCreatedDate(), b.getViewCount());
      }
    }
    out.println("</body>");
    out.println("</html>");
  }
}
