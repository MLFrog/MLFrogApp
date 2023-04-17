package com.mlfrog.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, BoardId> {

    public List<Board> getBoardList();
}
