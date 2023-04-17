package com.mlfrog.domain.Board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoardFunctionEnum {
    COMMENT("comment"),     // 댓글기능 유무
    FEEDBACK("feedback");   // 좋아요/싫어요 기능 유무
    private String boardFunction;
}
