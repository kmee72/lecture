package com.study.Ex15Board.dto;

import com.study.Ex15Board.domain.reply.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplySaveRequestDto {
  private String replyName;
  private String replyContent;
  private Long replyBoardIdx;

  @Builder
  public ReplySaveRequestDto(String replyName, String replyContent,
                             Long replyBoardIdx) {
    this.replyName = replyName;
    this.replyContent = replyContent;
    this.replyBoardIdx = replyBoardIdx;
  }

  //DTO to Entity
  public Reply toEntity() {
    return Reply.builder()
        .replyName(replyName)
        .replyContent(replyContent)
        .replyBoardIdx(replyBoardIdx)
        .build();
  }
}
