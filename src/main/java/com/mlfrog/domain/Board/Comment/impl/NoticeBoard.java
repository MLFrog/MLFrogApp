package com.mlfrog.domain.Board.Comment.impl;

import com.mlfrog.domain.Board.Comment.addBoardSetting;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoticeBoard implements addBoardSetting {
    @Override
    public void addFunction() {
        // 공산당의 공지사항을 맛봐라 댓글기능도 없고 좋싫어요도 없다 이눔들아
        log.info("function comment added !! ");
    }
}
