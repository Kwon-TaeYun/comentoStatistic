package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentUserCountDto {

    private String department;
    private int connectedUserCount;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getConnectedUserCount() {
        return connectedUserCount;
    }

    public void setConnectedUserCount(int connectedUserCount) {
        this.connectedUserCount = connectedUserCount;
    }

}
