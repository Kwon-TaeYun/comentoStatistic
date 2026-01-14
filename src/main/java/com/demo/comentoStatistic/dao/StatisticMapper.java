package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticMapper {
    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);
    YearMonthDayCountDto selectYearMonthDayLogin(String yearMonthDay);
    LoginCountDto selectAllLogin();
    double selectAvgDailyLogin();
    LoginRequestCountDto selectAllLoginRequest();
    LoginRequestDayCountDto selectYearMonthDayLoginRequest(String yearMonthDay);
}
