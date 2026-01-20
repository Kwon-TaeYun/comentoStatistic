package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AverageDailyLoginCountDto {
    private double averageDailyLoginCount; // 평균 일 로그인 수

    public double getAverageDailyLoginCount() {
        return averageDailyLoginCount;
    }

    public void setAverageDailyLoginCount(double averageDailyLoginCount) {
        this.averageDailyLoginCount = averageDailyLoginCount;
    }
}
