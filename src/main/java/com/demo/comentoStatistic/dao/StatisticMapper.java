package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StatisticMapper {
    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);
    YearMonthDayCountDto selectYearMonthDayLogin(String yearMonthDay);
    LoginCountDto selectAllLogin();
    AverageDailyLoginCountDto selectAvgDailyLogin();
    LoginRequestCountDto selectAllLoginRequest();
    LoginRequestDayCountDto selectYearMonthDayLoginRequest(String yearMonthDay);
    DepartmentUserCountDto selectConnectedUserCountByDepartment(
            @Param("department") String department
    );

    DepartmentMonthUserCountDto selectDepartmentMonthUserCount(
            @Param("department") String department,
            @Param("year") String year,
            @Param("month") String month
    );
    List<BoardDto> selectBoardsByUserId(String userId);

    int selectBoardCountByUserId(String userId);

    LoginCountDto selectLoginCountExcludeHoliday();
}

