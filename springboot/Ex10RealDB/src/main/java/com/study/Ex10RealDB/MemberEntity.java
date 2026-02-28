package com.study.Ex10RealDB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//@Entity : 엔티티 클래스임을 알려줌. DB 테이블과 1:1 매핑되는 클래스.
@Entity
@Table(name = "member")
@Getter
//@Setter : 넣지 않는다. 개발자의 실수나 자동으로 호출되는 경우를 제거.
@AllArgsConstructor
@NoArgsConstructor //기본생성자 필수, @ModelAttribute @RequestBody에 필요!
public class MemberEntity {
  //@Id : 기본키 id열로 사용한다는 의미
  //@GeneratedValue : id값을 어떻게 생성할지 전략을 선택
  //   1. IDENTITY : MySQL, MariaDB, ProstreSQL, H2DB
  //  2. SEQUENCE : Oracle, PrestreSQL
  // 3. AUTO : 자동으로 선택
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userId;  // DB는 Snake Case 선호, Java는 Camel Case 선호
  private String userPw;
  private String userName;
  private String userRole;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate joinDate;
}
// MySQL         Java엔티티
// BIGINT         Long
// INT               Integer
// Varchar(n)  String
// Text            String
// DATE           LocalDate
// DATETIME  LocalDateTime
// BLOB           byte[]
// TinyInt(1)   Boolean


