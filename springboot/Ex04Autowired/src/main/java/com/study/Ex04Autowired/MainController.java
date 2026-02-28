package com.study.Ex04Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  @GetMapping("/")
  @ResponseBody
  public String main() {
  // URL : localhost:8080/
    return "스프링부트 웹서버에 오신 것을 환영합니다.";
  }
  
  //필드 주입으로 Member 객체 사용하기
  @Autowired
  private Member member;
  
  @GetMapping("/member")
  @ResponseBody
  public String member(){
    member.setName("이순신");
    return member.getName();
  }

  @Autowired
  @Qualifier("bCCard")
  ICard iCard;  //오토와이어링할 수 없습니다
                        //ICard 구현 객체가 2개 이므로 선택을 해야 됨.
                        //선택하는 방법 : @Qualifier @Primary
  @GetMapping("/card")
  @ResponseBody
  public String card(){
    member.setName("홍길동");
    member.setiCard( iCard );
    member.getiCard().buy("핸드폰");
    return "card()호출됨.";
  }


}//class
