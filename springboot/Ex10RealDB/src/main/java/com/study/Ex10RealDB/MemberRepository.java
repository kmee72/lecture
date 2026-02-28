package com.study.Ex10RealDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository : @Component가 들어간 JPA에서 DB제어 클래스
@Repository
public interface MemberRepository
      extends JpaRepository<MemberEntity, Long> {
  //JpaRepository의 기본함수
  //1. findAll() : select * from Table - SQL문을 실행
  //2. findBy열이름(값) : select * from T where 컬럼명=값 - SQL을 실행
  //       예) findById((Long)2) : select * from T where id=2
  //             findByUserName("홍길동") : select * from T where username="홍길동"
  //3. save(E) : insert와 update SQL을 실행, id값을 보고 있으면 update, 없으면 insert.
  //4. delete(E) : delete SQL을 실행
}
