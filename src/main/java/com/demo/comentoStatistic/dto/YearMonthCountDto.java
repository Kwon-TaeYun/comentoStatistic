package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YearMonthCountDto {
    private String yearMonth;
    private Integer totCnt;

    public String getYear() {
        return yearMonth;
    }

    public Integer getTotCnt() {
        return totCnt;
    }
}
