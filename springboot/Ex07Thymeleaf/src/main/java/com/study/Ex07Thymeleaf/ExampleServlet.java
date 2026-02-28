package com.study.Ex07Thymeleaf;

// javax -> jakarta 오픈 소스로 바뀌면서 이름이 바뀜.

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//톰캣WAS서버 : 서블릿을 생성/관리/유지한다.
//Servlet : 자바를 사용하여 웹페이지를 동적으로 생성하는 서버 측 프로그램.
//          : 생명주기(interface Servlet)
//          : 객체 생성 init(), 요청처리 service(), 소멸 destory() 함수가 호출됨.
//HttpServlet : 자바 서블릿 API에서 제공하는 추상화 클래스로서 특화된 기능들을 제공한다.

//내장 톰캣에 서블릿으로 등록해보자
@WebServlet(name = "exampleServlet", urlPatterns = "/example")
public class ExampleServlet extends HttpServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("service()함수 호출됨.");
    super.service(req, res); // 여기서 자동으로 doGet 또는 doPost로 배달해줍니다.

//    System.out.println("GET,POST,PUT,DELETE 요청 처리");
//    HttpServletRequest request = (HttpServletRequest) req; //다운캐스팅
//    String method = request.getMethod();
//    if( "GET".equalsIgnoreCase(method)) {    }
//    else if( "POST".equalsIgnoreCase(method)){    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("doGet()함수 호출됨.");

    resp.setContentType("text/html; charset=UTF-8");
    resp.getWriter().println("<h2>GET요청을 처리했습니다.</h2>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("doPost()함수 호출됨.");

    resp.setContentType("text/html; charset=UTF-8");
    resp.getWriter().println("<h2>POST요청을 처리했습니다.</h2>");
  }

  @Override
  public void init() throws ServletException {
    System.out.println("서블릿 생성");
  }

  @Override
  public void destroy() {
    System.out.println("서블릿 소멸");
  }
}
