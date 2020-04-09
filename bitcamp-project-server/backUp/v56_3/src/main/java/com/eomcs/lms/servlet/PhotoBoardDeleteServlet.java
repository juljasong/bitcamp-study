package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.service.PhotoBoardService;

@WebServlet("/photoBoard/delete")
public class PhotoBoardDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      ServletContext servletContext = request.getServletContext();
      ApplicationContext iocContainer =
          (ApplicationContext) servletContext.getAttribute("iocContainer");

      PhotoBoardService photoBoardService = iocContainer.getBean(PhotoBoardService.class);

      int no = Integer.parseInt(request.getParameter("no"));
      photoBoardService.delete(no);
      response.sendRedirect("list?no=" + Integer.parseInt(request.getParameter("lessonNo")));
    } catch (Exception e) {
      request.getSession().setAttribute("errorMessage", e.getMessage());
      request.getSession().setAttribute("url",
          "photoBoard/list?no=" + Integer.parseInt(request.getParameter("lessonNo")));
      response.sendRedirect("../error");
    }

  }
}
