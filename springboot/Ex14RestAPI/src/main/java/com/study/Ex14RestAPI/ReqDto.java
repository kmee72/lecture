package com.study.Ex14RestAPI;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get, set, reqArgCon
@NoArgsConstructor
public class ReqDto {
  private String username;  //input 태그의 name속성과 매칭
  private String password;
}
