package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCountDto {
    private Integer totCnt;
    public Integer getTotCnt() {
        return totCnt;
    }
}
