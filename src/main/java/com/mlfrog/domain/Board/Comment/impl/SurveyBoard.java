package com.mlfrog.domain.Board.Comment.impl;

import com.mlfrog.domain.Board.Comment.addBoardSetting;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SurveyBoard implements addBoardSetting {
    @Override
    public void addFunction() {
        // only 좋아요 싫어요?
        log.info("function comment added !! ");
    }
}
