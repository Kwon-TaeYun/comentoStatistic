package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDayCountDto {
    private String yearMonthDay; // YYYYMMDD
    private Integer totCnt;

    public String getYearMonthDay() {
        return yearMonthDay;
    }

    public void setYearMonthDay(String yearMonthDay) {
        this.yearMonthDay = yearMonthDay;
    }

    public Integer getTotCnt() {
        return totCnt;
    }

    public void setTotCnt(Integer totCnt) {
        this.totCnt = totCnt;
    }
}
