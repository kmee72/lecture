package com.study.Ex05Lombok;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {
  @Autowired
  private Member member; //기본생성자로 생성된 객체가 주입된다.

  @GetMapping("/")
  @ResponseBody
  public String main(){
    //member.setName("Hong");
    System.out.println(member.getName());
    System.out.println(member.getAge());

    return "롬복 예제 서버입니다." + member.getName() + "," + member.getAge();
  }
  @GetMapping("/allArgs") // http://localhost:8080/allArgs
  @ResponseBody
  public String allArgs(){
    Member member = new Member("변사또", 30, "123", "");
    return member.getName();
  }

  //생성자 주입
  private final Member member1;
//  @Autowired
//  public MainController(Member member){ //기본생성자로 생성된 객체가 주입된다.
//    this.member1 = member;
//  }

  @GetMapping("/reqArgs")
  @ResponseBody
  public String reqArgs(){
    member1.setPhone("3456");
    return "reqArgs() " + member1.getPhone();
  }


}//class
