package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestCountDto {
    private Integer totCnt;

    public Integer getTotCount(){
        return totCnt;
    }
}
