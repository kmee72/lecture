package com.study.Ex16EntityMapping.domain.reply;

import com.study.Ex16EntityMapping.domain.board.Board;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// ============================================================
// [연관관계 매핑] Reply (N) : Board (1) - 다대일(ManyToOne) 관계
//
// Reply가 "연관관계 주인(owning side)"
//   → FK 컬럼(board_idx)을 Reply 테이블이 가짐
//   → @JoinColumn 으로 실제 FK 컬럼명을 지정
// ============================================================
@Entity
@Table(name = "reply")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_idx")
    private Long replyIdx;

    @Column(name = "reply_name", nullable = false)
    private String replyName;

    @Column(name = "reply_content", nullable = false)
    private String replyContent;

    @Column(name = "reply_date", nullable = false)
    private LocalDateTime replyDate = LocalDateTime.now();

    // ----------------------------------------------------------
    // [N:1 연관관계] Reply 여러 개가 Board 1개에 속함
    //   @ManyToOne       → 이 쪽이 FK 주인 (DB에 board_idx 컬럼 생성)
    //   @JoinColumn      → FK 컬럼명을 "board_idx" 로 지정
    //   fetch = LAZY     → 필요할 때만 Board 를 SELECT (기본값 권장)
    // ----------------------------------------------------------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_idx", nullable = false)
    private Board board;

    @Builder
    public Reply(String replyName, String replyContent) {
        this.replyName = replyName;
        this.replyContent = replyContent;
    }

    // Board.addReply() 의 편의 메서드에서 호출됨
    public void setBoard(Board board) {
        this.board = board;
    }
}
