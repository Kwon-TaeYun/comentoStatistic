package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentMonthUserCountDto {
    private String department;       // 부서명
    private String yearMonth;        // YYYYMM
    private int connectedUserCount;  // 접속자 수

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public int getConnectedUserCount() {
        return connectedUserCount;
    }

    public void setConnectedUserCount(int connectedUserCount) {
        this.connectedUserCount = connectedUserCount;
    }
}
