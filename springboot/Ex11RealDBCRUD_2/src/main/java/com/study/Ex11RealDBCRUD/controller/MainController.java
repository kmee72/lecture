package com.study.Ex11RealDBCRUD.controller;

import com.study.Ex11RealDBCRUD.dto.MemberSaveDto;
import com.study.Ex11RealDBCRUD.entity.MemberEntity;
import com.study.Ex11RealDBCRUD.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
  @Autowired
  private final MemberRepository memberRepository;

  @RequestMapping("/")
  public String main(Model model) {
    List<MemberEntity> list = memberRepository.findAll();
    model.addAttribute("list", list);
    return "index";
  }

  @GetMapping("/joinForm")
  public String joinForm(){
    return "joinForm";
  }

  //회원가입 액션
  @PostMapping("/joinAction")
  //@ModelAttribute : 클라가 보낸 HTTP 요청 파라미터를 자바 클래스에 매핑하는 어노테이션
  public String joinAction(@ModelAttribute MemberSaveDto dto){
    System.out.println("id = " + dto.getUserId());
    System.out.println("pw = " + dto.getUserPw());
    System.out.println("name = " + dto.getUserName());

    //id는 null로 놔둔다.
    dto.setJoinDate(LocalDate.now()); //현재 날짜로 설정.

    try {
      MemberEntity entity = dto.toSaveEntity();
      memberRepository.save(entity);
    } catch (Exception e) {
      e.printStackTrace();
      return "redirect:/";
    }
    return "redirect:/";
  }

  @GetMapping("/viewMember")
  // viewMember?id=3
  public String viewMember(@RequestParam("id") Long id, Model model){
    System.out.println("id = " + id);

    Optional<MemberEntity> optional = memberRepository.findById( id );
    if( !optional.isPresent() ) {
      return "redirect:/";
    }
    // null이 아니면 람다식 실행
    optional.ifPresent(  (entity) -> {
      model.addAttribute("member", entity.toSaveDto());
    }  );

    return "modifyForm";
  }

  @PostMapping("/modifyAction")
  public String modifyAction(@ModelAttribute MemberSaveDto dto){
    try{
      MemberEntity entity = dto.toSaveEntity();
      memberRepository.save( entity ); //id값이 있으면 업데이트 됨.
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "redirect:/";
  }

  @GetMapping("/deleteMember")
  public String deleteMember(@RequestParam("id") Long id) {

    try {
      memberRepository.deleteById( id );
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "redirect:/";
  }

}//class
