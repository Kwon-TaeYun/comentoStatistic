package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserBoardSummaryDto {

    private String userId;
    private int boardCount;
    private List<BoardDto> boards;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBoardCount() {
        return boardCount;
    }

    public void setBoardCount(int boardCount) {
        this.boardCount = boardCount;
    }

    public List<BoardDto> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardDto> boards) {
        this.boards = boards;
    }
}
