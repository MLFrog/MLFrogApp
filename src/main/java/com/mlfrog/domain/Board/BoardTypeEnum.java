package com.mlfrog.domain.Board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoardTypeEnum {
    //    https://gall.dcinside.com/mgallery/board/lists?id=mechanicalkeyboard
    // 상기 링크의 사이트 내용 중 게시판 글의 성격을 보면 (23.04.18 00:29기준)
    // 설문, 공지, 일반 3개 형태로 이루어져 있긴 함.
    // 게시판은 보통 공지사항, 일반 게시글이 일반적이므로 작성해둠.
    // *작성은 해두었으니 확인을 요함.
    NOTICE("notice"), // 공지사항
    SURVEY("survey"), // 설문조사
    NORMAL("normal"); // 게시판
    private String boardType;
}
