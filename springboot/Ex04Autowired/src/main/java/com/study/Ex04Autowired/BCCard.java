package com.study.Ex04Autowired;

import org.springframework.stereotype.Component;

@Component("bCCard")  //빈의 이름을 직접 지정
public class BCCard implements ICard {
  @Override
  public void buy(String itemName) {
    System.out.println("BCCard.buy");
    System.out.println("itemName = " + itemName);
  }
}
