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
    double selectAvgDailyLogin();
    LoginRequestCountDto selectAllLoginRequest();
    LoginRequestDayCountDto selectYearMonthDayLoginRequest(String yearMonthDay);
    DepartmentUserCountDto selectConnectedUserCountByDepartment(
            @Param("department") String department
    );
    DepartmentMonthUserCountDto selectDepartmentMonthUserCount(
            @Param("department") String department,
            String yearMonth
    );
    int selectBoardCountByUserId(@Param("userId") String userId);

    List<BoardDto> selectBoardsByUserId(@Param("userId") String userId);

    LoginCountDto selectLoginCountExcludeHoliday();
}

