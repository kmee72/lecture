package com.study.Ex12LoginJoinDB.entity;

import com.study.Ex12LoginJoinDB.dto.MemberSaveDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "member")
@Getter
//@Setter : 넣지 않는다.
@AllArgsConstructor
@NoArgsConstructor //기본생성자 필수
@Builder
public class MemberEntity {
  //@Id : 기본키 id열로 사용한다는 의미
  //@GeneratedValue : id값을 어떻게 생성할지 전략을 선택
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userId;
  private String userPw;
  private String userName;
  private String userRole;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate joinDate;

  //Entity -> DTO
  public MemberSaveDto toSaveDto(){
    return MemberSaveDto.builder()
        .id(id)
        .userId(userId)
        .userPw(userPw)
        .userName(userName)
        .userRole(userRole)
        .joinDate(joinDate)
        .build();
  }
} //class


