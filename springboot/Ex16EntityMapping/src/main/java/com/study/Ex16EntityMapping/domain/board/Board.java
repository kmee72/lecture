package com.study.Ex16EntityMapping.domain.board;

import com.study.Ex16EntityMapping.domain.reply.Reply;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// ============================================================
// [연관관계 매핑] Board (1) : Reply (N) - 일대다(OneToMany) 관계
//
// Board가 "주인이 아닌 쪽(inverse side)"
//   → mappedBy = "board"  : Reply 엔티티의 필드명 "board" 를 가리킴
//   → DB에 FK 컬럼을 만들지 않음. 읽기 전용.
// ============================================================
@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx")
    private Long boardIdx;

    @Column(name = "board_name", nullable = false)
    private String boardName;

    @Column(name = "board_title", nullable = false)
    private String boardTitle;

    @Column(name = "board_content", nullable = false)
    private String boardContent;

    @Column(name = "board_date", nullable = false)
    private LocalDateTime boardDate = LocalDateTime.now();

    // ----------------------------------------------------------
    // [1:N 연관관계] Board 1개에 Reply 여러 개
    //   mappedBy = "board"  → Reply.java 의 board 필드가 FK 주인
    //   cascade = ALL       → Board 저장/삭제 시 Reply 도 함께 처리
    //   orphanRemoval       → Board에서 Reply 제거 시 DB 에서도 삭제
    // ----------------------------------------------------------
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replies = new ArrayList<>();

    @Builder
    public Board(String boardName, String boardTitle, String boardContent) {
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }

    // 연관관계 편의 메서드 : Board ↔ Reply 양쪽을 동시에 연결
    public void addReply(Reply reply) {
        replies.add(reply);
        reply.setBoard(this); // Reply 쪽 FK 도 함께 세팅
    }
}
