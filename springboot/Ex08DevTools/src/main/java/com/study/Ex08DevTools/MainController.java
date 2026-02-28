package com.study.Ex08DevTools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping("/")
  public String main(){
    System.out.println("main함수 호출됨.333");
    return "index";
  }
}
