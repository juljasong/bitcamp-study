package bitcamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// 프론트 컨트롤러(DispatcherServlet)가 실행할 페이지 컨트롤러 -> @Controller
@Controller
public class HelloController {

  // 클라이언트 요청 들어왔을 때 호출할 메서드(request handler) -> @RequestMapping
  // @RequestMapping("/hello")
  // (value="/hello")
  // (path="/hello")
  @RequestMapping({"/hello", "/hello2", "/okok"})

  // 리턴하는 String 값이 뷰 컴포넌트(예:JSP)의 URL이 아닌 경우 -> @ResponseBody
  // 리턴하는 문자열이 클라이언트에게 보낼 콘텐츠임을 표시
  @ResponseBody
  public String hello() throws Exception {
    return "<html><body><h1>Hello!</h1></body></html>";
  }
}
