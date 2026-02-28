package com.study.Ex04Autowired;

import org.springframework.stereotype.Component;

@Component("member")
public class Member {
  private String name;
  private ICard iCard;  //확장성을 고려한 다형성 설계

  //생성자  : Java컴파일러는 기본생성자 자동생성. 필드생성자가 있다면,
  //              기본생성자를 자동생성하지 않음.
  //            : Spring은 기본생성자 자동생성안함.
  // 팁 : 빈으로 만들 클래스의 기본생성자를 기본으로 만들면 된다.
  public Member(){ }  //기본으로 만들어 놓자.

  public Member(String name, ICard iCard) {
    this.name = name;
    this.iCard = iCard;
  }
  //getter/setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ICard getiCard() {
    return iCard;
  }

  public void setiCard(ICard iCard) {
    this.iCard = iCard;
  }
}
