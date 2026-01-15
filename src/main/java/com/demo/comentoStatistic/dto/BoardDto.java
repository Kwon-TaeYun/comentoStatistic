package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardDto {
    private Long id;     // id
    private String title;  // 게시판 이름

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPostCount(String title){
        this.title = title;
    }
}
