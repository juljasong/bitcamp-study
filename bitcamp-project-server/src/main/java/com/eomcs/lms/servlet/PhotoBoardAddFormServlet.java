package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;
import com.eomcs.util.RequestMapping;

@Component
public class PhotoBoardAddFormServlet {

  LessonService lessonService;
  PhotoBoardService photoBoardService;

  public PhotoBoardAddFormServlet(LessonService lessonService,
      PhotoBoardService photoBoardService) {
    this.lessonService = lessonService;
    this.photoBoardService = photoBoardService;
  }

  @RequestMapping("/photoboard/addForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>사진 게시글 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>사진 게시글 등록</h1>");

    out.println("<form action='/photoboard/add'>");
    out.println("제목: <input name='title' type='text'><br>\n");
    out.println("수업 번호: <input name='no' type='text'><br>\n");
    out.println("<button>제출</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
