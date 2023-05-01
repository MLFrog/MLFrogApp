package com.mlfrog.domain.Board;

import com.mlfrog.domain.Board.Comment.AddFunctions;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Board {
    private BoardId id;
    private String subject;
    private String content;
    private String password;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private AddFunctions addFunctions;

    public Board(BoardId id, AddFunctions addFunctions) {
        this.id = id;
        this.addFunctions = addFunctions;
    }

    public void normalBoard() {
        addFunctions.add();
    }
}
