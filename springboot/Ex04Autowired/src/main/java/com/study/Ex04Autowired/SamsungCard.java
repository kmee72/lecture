package com.study.Ex04Autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("samsungCard")
@Primary
public class SamsungCard implements ICard{
  @Override
  public void buy(String itemName) {
    System.out.println("SamsungCard.buy");
    System.out.println("itemName = " + itemName);
  }
}
