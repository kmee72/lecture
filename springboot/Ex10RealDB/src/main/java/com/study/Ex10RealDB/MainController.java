package com.study.Ex10RealDB;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor  //생성자 주입으로 Repository 객체 가져오기
public class MainController {
  //생성자 주입
  private final MemberRepository memberRepository;
  
  @GetMapping("/")
  public String main(Model model){
    List<MemberEntity> list = memberRepository.findAll(); //Select * SQL실행
    System.out.println("list.size() = " + list.size());

    model.addAttribute("list", list);

    return "index";
  }
}
