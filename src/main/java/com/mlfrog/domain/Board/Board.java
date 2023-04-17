package com.mlfrog.domain.Board;

import com.mlfrog.domain.Account.Account;
import com.mlfrog.domain.Board.Comment.impl.NoticeBoard;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Board {
    @Id
    private BoardId boardId;
    private String subject;
    private String content;
    private String password;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private Long accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    /**
     * 검토를 요총합니다 하핳
     * 맛은 살린거 같긴한데 모르겠쒀요 하핳
     * line: 36 - 58
     */
//    private NormalBoard normalBoard;
//    private NoticeBoard noticeBoard;
//    private SurveyBoard surveyBoard;
//
//
//    //게시글에 댓글 기능 쓸거임..? 쓸거면 공지글에도 쓸거임? 아님 일반글에만 쓸거임? 선택할 수도 있게 할거임?
//    @NonNull
//    private BoardFunction boardFunction;
//
//    public Board(BoardId boardId, NormalBoard normalBoard) {
//        this.boardId = boardId;
//        this.normalBoard = normalBoard;
//    }
//
//    public Board(BoardId boardId, SurveyBoard surveyBoard) {
//        this.boardId = boardId;
//        this.surveyBoard = surveyBoard;
//    }
//
//    public Board(BoardId boardId, NoticeBoard noticeBoard) {
//        this.boardId = boardId;
//        this.noticeBoard = noticeBoard;
//    }


    //현호쓰 검토좀.
//    private Long commentId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "commentId", nullable = false)
//    private Comment comment;

    //아님 좋아요 싫어요 라던가?
//    private Long likeCnt;
//    private Long disLikeCnt;

}
