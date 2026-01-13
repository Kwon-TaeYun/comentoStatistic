package com.demo.comentoStatistic.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class YearCountDto {
    private String year;
    private Integer totCnt;

    public String getYear() {
        return year;
    }

    public Integer getTotCnt() {
        return totCnt;
    }
}
