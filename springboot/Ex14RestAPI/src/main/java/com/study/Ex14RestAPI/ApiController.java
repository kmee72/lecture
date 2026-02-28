package com.study.Ex14RestAPI;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@RestController : @Controller + @ResponseBody 합쳐논 것
// 클래스 이름 위에 @ResponseBody을 넣으면,
// 클래스 안의 모든 메소드는 @ResponseBody를 적용받는다.
@RestController
// 클래스 안의 모든 메소드는 "/api/v1" 경로로 시작한다.
@RequestMapping("/api/v1")
public class ApiController {
  //URI : http://localhost:8080/api/v1/hello
  @RequestMapping("/hello")
  public String hello(){
    return "Hello, 저는 API 서버입니다.";
  }

  @PostMapping("/login")
  @ResponseBody  // 응답을 http body에 실어 보낸다.
  // @RequestBody : 요청 http body의 데이터를 매핑한다.
  public Map<String, String> login(@RequestBody String body) {
    System.out.println( body );
    Map<String, String> resMap = new HashMap<>();
    resMap.put("status", "ok");
    resMap.put("message",  "로그인되었습니다.");
    return resMap;
  }

  @PostMapping("/loginDto")
  @ResponseBody
  public ResDto loginDto(@RequestBody ReqDto dto){
    System.out.println(dto.getUsername());

    ResDto resDto = new ResDto();
    resDto.setStatus("success");
    resDto.setMessage("로그인 성공!");

    return resDto;
  }


}//class
