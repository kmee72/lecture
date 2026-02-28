package com.study.Ex07Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
  @GetMapping("/")
  public String main(){
    return "index";  //동적 웹에서는 파일이름만 적으면 된다.
                                //뷰리졸버가 .html 확장자를 붙여서 파일을 찾아준다.
  }
  @GetMapping("/index1")
  // Model 클래스 : 스프링 MVC 모델에서 데이터를 전달하는 용도의 클래스.
  //     내부적으로 Map(Key-Value) 데이터구조이다.
  //매개변수로 선언하면, 스프링에서 주입(new)이 된다.
  //   Model 객체에 KV를 넣으면, 타임리프에서 가져다 사용한다.
//  URL : localhost:8080/index1
  public String index1(Model model){
    model.addAttribute("name_text", "<ins>홍길동</ins>");
    model.addAttribute("name_html", "<ins>홍길동</ins>");
    model.addAttribute("server_value", "HONG");
    return "index";
  }

  @GetMapping("/index2")
  public String index2(Model model){
    model.addAttribute("address", "서울");
    model.addAttribute("address_null", null);
    model.addAttribute("address_empty", ""); //빈 문자열
    return "index2";
  }

  @GetMapping("/index3")
  public String index3(Model model){
    model.addAttribute("standardDate", new Date());
    model.addAttribute("localDate", LocalDate.now());
    model.addAttribute("localDateTime", LocalDateTime.now());

    model.addAttribute("number1", 12345678);
    model.addAttribute("number2", 123456.789);

    return "index3";
  }
  @GetMapping("/index4")
  public String index4(Model model) {
    //role : 역할  admin, member, quest : 스프링 시큐리티(보안)
    model.addAttribute("role", "member");
    return "index4";
  }
  @GetMapping("/index5")
  public String index5(Model model) {
    Member member = new Member("hong", "1234");
    model.addAttribute("member", member);

    List<Member> list = new ArrayList<>();
    list.add( new Member("lee", "2222"));
    list.add( new Member("hana", "3333"));
    list.add( new Member("tom", "4444"));
    model.addAttribute("list", list);

    return "index5";
  }
  @GetMapping("/index6")
  public String index6(Model model) {
    return "index6";
  }
  @GetMapping("/index7")
  public String index7(Model model) {
    return "index7";
  }


}//class

