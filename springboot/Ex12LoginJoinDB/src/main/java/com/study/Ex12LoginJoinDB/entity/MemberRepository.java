package com.study.Ex12LoginJoinDB.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository : @Component가 들어간 JPA에서 DB제어 클래스
@Repository
public interface MemberRepository
      extends JpaRepository<MemberEntity, Long> {
  //사용자 정의 함수
  // 쿼리 자동 생성  : select * from T where userId="userId변수값"
  Optional<MemberEntity> findByUserId(String userId);

  //JPA 커스텀 쿼리 메소드 생성하는 규칙 : 단점 - 모든 검색을 함수호출로 불가능!
  //https://velog.io/@633jinn/JPARepository-%EB%A9%94%EC%86%8C%EB%93%9C-%EC%BB%A4%EC%8A%A4%ED%85%80%ED%95%98%EA%B8%B0

  //JPA에서 네이티브 SQL, JPQL을 사용하는 방법


  //JpaRepository의 기본함수
  //1. findAll() : select * from Table - SQL문을 실행
  //2. findBy열이름(값) : select * from T where 컬럼명=값 - SQL을 실행
  //       예) findById((Long)2) : select * from T where id=2
  //             findByUserName("홍길동") : select * from T where username="홍길동"
  //3. save(E) : insert와 update SQL을 실행, id값을 보고 있으면 update, 없으면 insert.
  //4. delete(E) : delete SQL을 실행
}
