package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserBoardSummaryDto {

    private List<BoardDto> boards;
    private int postCount;

    public List<BoardDto> getBoards() {
        return boards;
    }

    public int getPostCount(){
        return postCount;
    }

    public void setBoards(List<BoardDto> boards) {
        this.boards = boards;
    }

    public void setPostCount(int postCount){
        this.postCount = postCount;
    }
}
