package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentMonthUserCountDto {
    private String department;      // 부서명
    private String year;            // YY
    private String month;           // MM
    private int connectedUserCount; // 접속자 수

    // ===== getter / setter =====

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getConnectedUserCount() {
        return connectedUserCount;
    }

    public void setConnectedUserCount(int connectedUserCount) {
        this.connectedUserCount = connectedUserCount;
    }
}
