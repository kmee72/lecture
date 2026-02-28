package com.study.Ex15Board.dto;

import com.study.Ex15Board.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// db 인덱스와 날짜는 기존 데이터를 사용한다.
@Getter @Setter
@NoArgsConstructor
public class BoardSaveRequestDto {
  private String boardName;
  private String boardTitle;
  private String boardContent;
  private Integer boardHit;

  @Builder
  public BoardSaveRequestDto(String boardName, String boardTitle,
                             String boardContent, Integer boardHit){
    this.boardName = boardName;
    this.boardTitle = boardTitle;
    this.boardContent = boardContent;
    this.boardHit = boardHit;
  }

  // DTO to Entity
  public Board toEntity() {
    return Board.builder()
        .boardName(boardName)
        .boardTitle(boardTitle)
        .boardContent(boardContent)
        .boardHit(boardHit)
        .build();
  }

}
