package com.study.Ex15Board.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
  //기본함수 : findAll, findById, save, delete, count
  //사용자 정의 함수는 별도로 선언해야 됨.
}
