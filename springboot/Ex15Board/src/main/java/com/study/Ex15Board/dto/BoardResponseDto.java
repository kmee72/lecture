package com.study.Ex15Board.dto;

//RequestDto -> 폼(JSON) 데이터 요청
//ResponseDto -> JSON 데이터 응답

// HTTP Request <->  DTO <-> Entity <-> Repository
//                <-> Controller / Service <-> View(Response)

import com.study.Ex15Board.domain.board.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto {
  private Long boardIdx;
  private String boardName;
  private String boardTitle;
  private String boardContent;
  private Integer boardHit;
  private LocalDateTime boardDate;

  //entitiy -> DTO  생성자함수
  public BoardResponseDto(Board entity) {
    this.boardIdx = entity.getBoardIdx();
    this.boardName = entity.getBoardName();
    this.boardTitle = entity.getBoardTitle();
    this.boardContent = entity.getBoardContent();
    this.boardHit = entity.getBoardHit();
    this.boardDate = entity.getBoardDate();
  }
}
