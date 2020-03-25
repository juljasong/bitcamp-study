package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;
import com.eomcs.util.RequestMapping;

@Component
public class PhotoBoardListFormServlet {

  PhotoBoardService photoBoardService;
  LessonService lessonService;

  public PhotoBoardListFormServlet(PhotoBoardService photoBoardService,
      LessonService lessonService) {
    this.photoBoardService = photoBoardService;
    this.lessonService = lessonService;
  }

  @RequestMapping("/photoboard/listform")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    List<Lesson> lessons = lessonService.list();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("   <meta charset='UTF-8'>");
    out.println("   <title>사진 게시글 목록</title>");
    out.println("<body>");
    out.println("   <h1>수업</h1>");
    out.println("   <table border='1'>");
    out.println("       <tr>");
    out.println("           <th>번호</th>");
    out.println("           <th>수업명</th>");
    out.println("           <th>수업일</th>");
    out.println("           <th>총수업시간</th>");
    out.println("       </tr>");

    for (Lesson l : lessons) {
      out.printf(
          "<tr><td>%d</td> <td><a href='/lesson/detail?no=%d'>%s</a></td> <td>%s ~ %s</td> <td>%d</td></tr>\n",
          l.getNo(), l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
    out.println("<form action='/photoboard/list'>");
    out.println("수업번호: <input name='no' type='text'>\n");
    out.println("<button>확인</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");

  }
}
