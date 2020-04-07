// 서블릿 초기화 파라미터 - 애노테이션으로 설정하기
package com.eomcs.web.ex06;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

// 서블릿이 사용할 값을 DD 설정으로 지정할 수 있다.
//
@WebServlet(value = "/ex06/s3", loadOnStartup = 1,
    initParams = {@WebInitParam(name = "jdbc.driver", value = "org.mariadb.jdbc.Driver"),
        @WebInitParam(name = "jdbc.url", value = "jdbc:mariadb://localhost/studydb"),
        @WebInitParam(name = "jdbc.username", value = "study"),
        @WebInitParam(name = "jdbc.password", value = "1111")})
@SuppressWarnings("serial")
public class Servlet03 extends HttpServlet {

  // @Override
  // public void init(ServletConfig config) throws ServletException {
  // //서블릿 객체가 생성될 때 뭔가 준비하는 작업을 해야한다면, 보통 이 메서드 오버라이딩
  // // 이 메서드가 호출될 때 넘어오는 값을 보관했다가 getServletConfig()가 호출될 때 리턴해줘야 하는 코드 추가-> 번거로움
  // // => GenericServlet은 미리 이 메서드에 해당 코드 작성해두었음
  // // 추가적으로 파라미터 값을 받지 않는 init()를 정의
  // super.init(config);
  // }

  @Override
  public void init() throws ServletException {
    // 이 객체 생성될 떄 DB에 연결한다고 가정
    // DB 연결하려면 JDBC Driver 이름과 URL, 사용자 아이디, 암호 알아야 함
    // But, 자바 소스 코드에 그 값을 직접 작성하면, 나중에 DB연결 정보가 바뀌었을 때 이 소스를 변경하고 다시 컴파일 해야 한다.
    // => 변할 수 있는 값을 소스에 작성하는 것(=>하드 코딩)은 바람직하지 않음

    // String jdbcDriver = "org.mariadb.driver.Driver";
    // String jdbcUrl = "jdbc:mariadb://localhost:3306/studydb";
    // String username = "study";
    // String password = "1111";

    // => 변경되는 값들은 외부에 두는 것이 관리에 편함
    // 값이 변하더라도 소스를 변경할 필요 X => 보통 DD 파일(web.xml)에 둠
    // 다만 이 예제에서는 어노테이션으로도 설정할 수 있다는 것을 보여줌

    // @WebInitParam(name = "jdbc.driver", value = "org.mariadb.jdbc.Driver"),
    // @WebInitParam(name = "jdbc.url", value = "jdbc:mariadb://localhost/studydb"),
    // @WebInitParam(name = "jdbc.username", value = "study"),
    // @WebInitParam(name = "jdbc.password", value = "1111")})

    ServletConfig config = this.getServletConfig();
    String jdbcDriver = config.getInitParameter("jdbc.driver");
    String jdbcUrl = config.getInitParameter("jdbc.url");
    String username = config.getInitParameter("jdbc.username");
    String password = config.getInitParameter("jdbc.password");


    System.out.println(jdbcDriver);
    System.out.println(jdbcUrl);
    System.out.println(username);
    System.out.println(password);

  }
}

