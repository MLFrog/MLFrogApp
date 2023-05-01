package com.mlfrog.domain.Board;

import com.mlfrog.domain.Account.AccountId;
import com.mlfrog.domain.Board.Comment.impl.NormalBoard;
import com.mlfrog.domain.Board.Comment.impl.NoticeBoard;
import com.mlfrog.domain.Board.Comment.impl.SurveyBoard;
import com.mlfrog.domain.Board.Enum.BoardTypeEnum;

public class BoardFactory {

    public BoardFactory() {

    }

//    // 확인요망
    public Board getInstance(BoardId id, String boardType, String boardFunction) {

        if (boardType.equals(BoardTypeEnum.NOTICE.name())) {
            return new Board(id, new NoticeBoard());
        } else if (boardType.equals(BoardTypeEnum.SURVEY.name())) {
            return new Board(id, new SurveyBoard());
        } else if (boardType.equals(BoardTypeEnum.NORMAL.name())) {
            return new Board(id, new NormalBoard());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
