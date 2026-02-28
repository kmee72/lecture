package com.study.Ex13FileUpload;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDto {
  // uuid란? Universally Unique Identifier약자.
  //    중복될 확률이 거의 없는 128비트 고유 식별자. 랜덤생성함.
  // 중복되지 않는 파일 이름 생성 방법
  // 1. 타임스탬프 이용 : filename-20260225124210121.png
  // 2.UUID 이용 : filename-8-4-4-4-12의 16진수 문자.png
  private String uuid;
  private String fileName;
  private String contentType;
}
