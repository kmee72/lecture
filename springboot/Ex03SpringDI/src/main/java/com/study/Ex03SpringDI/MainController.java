package com.study.Ex03SpringDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller : HTTP 요청을 가장 먼저 처리하는 컨트롤 클래스이다.
//                         GET/POST/PUT/PATCH/DELETE 메소드를 처리한다.
//                         Read/Insert/UpdateAll/Update/Delete DB액션.
//@Component : mainController 빈으로 만든다.
@Controller
public class MainController {
  //HTTP URL : localhost:8080/
  @GetMapping("/") //Root경로로 GET요청을 처리하는 메소드를 선언한다.
  @ResponseBody  //응답을 html파일로 하지 않고, Body데이터(문자열)로 한다는 뜻.
  public String main() {
    return "스프링부트 웹서버가 준비되었습니다.";
  }

  @GetMapping("/test")
  @ResponseBody
  public String test() {
    //URL : localhost:8080/test
    return "테스트 경로입니다.";
  }

  //1. 필드 주입
  //@Autowired : 스프링 빈을 생성(주입)해주는 어노테이션
  //                      : Member member1 = new Member();를 대신 해준다.
  @Autowired
  private Member member1;
  @Autowired
  private Member member2; //주입안됨

  @GetMapping("/field")
  @ResponseBody
  public String field() {
    //URL : localhost:8080/field
    System.out.println(member2.getName());
    return "field() 호출됨.";
  }
  //* Whitelabel Error Page
  //     : 스프링이 응답해 줄 페이지가 없을때(경로 이상, 오류 발생시)
  //    : 스프링 기본 에러 페이지

  //2. 수정자 주입 : setter함수를 통해 주입받는 것.
  private Member member3;
  @Autowired                   //매개변수로 주입된다.
  public void setMember( Member member ) {
    System.out.println("수정자 주입됨.");
    this.member3 = member;
  }
  @GetMapping("/setter")
  @ResponseBody
  public String setter() {
    //URL : localhost:8080/setter
    System.out.println(member3.getName());
    return "setter() 호출됨.";
  }

  //3. 생성자 주입 - 권장
  //   1) final 키워드 사용 가능 (객체 재할당 방지)
  //   2) 생성자함수로서 미리 주입을 받을 수 있다. (우선순위 높다.)
  //       예) 닭이 먼저냐? 달걀이 먼저냐?
  //             객체A는 객체B가 있어야 생성되고
  //             객체B는 객체A가 있어야 생성된다. 상호 참조.
  //        객체생성 우선순위 제공 - @Primary
  //   3) Null Safety 제공
  private final Member member4;
  @Autowired
  public MainController(Member member) {
    System.out.println("생성자 주입됨.");
    this.member4 = member;
  }
  @GetMapping("/constructor")
  @ResponseBody
  public String constructor(){
    //URL : localhost:8080/constructor
    System.out.println(member4.getName());
    return "constructor()호출됨.";
  }


}//class
