package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDayCountDto {
    private String yearMonthDay;
    private Integer totCnt;

    public String getYearMonthDay() {
        return yearMonthDay;
    }

    public Integer getTotCnt() {
        return totCnt;
    }
}
