package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시글 입력</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 입력</h1>");
    out.println("<form action='add' method='post'>");
    out.println("내용:<br>");
    out.println("<textarea name='title' rows='5' cols='60'></textarea><br>");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      request.setCharacterEncoding("UTF-8");

      ServletContext servletContext = request.getServletContext();
      ApplicationContext iocContainer =
          (ApplicationContext) servletContext.getAttribute("iocContainer");

      BoardService boardService = iocContainer.getBean(BoardService.class);

      Board board = new Board();
      board.setTitle(request.getParameter("title"));
      if (boardService.add(board) > 0) {
        // 리다이렉트: 작업 완료 후 다른 페이지로 이동. URL은 웹브라우저가 사용-> /로 시작하면 서버루트.
        // /로 시작하지 않으면 상대경로(리다이렉트 메시지 받기 전 URL 기준으로 계산한 경로). 맨 마지막 /의 앞 주소에 이은 경로
        response.sendRedirect("list");
      } else {
        request.getSession().setAttribute("errorMessage", "게시물 등록 실패.");
        request.getSession().setAttribute("url", "board/list");
        response.sendRedirect("../error");
      }

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
