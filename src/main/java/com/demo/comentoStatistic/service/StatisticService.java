package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {

    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin(year+month);
    }

    public YearMonthDayCountDto getYearMonthDayLogins(String year, String month, String day){
        return statisticMapper.selectYearMonthDayLogin(year+month+day);
    }

    public LoginCountDto getAllLogins(){
        return statisticMapper.selectAllLogin();
    }

    public double getAvgDailyLogin() {
        return statisticMapper.selectAvgDailyLogin();
    }

    public LoginRequestCountDto getLoginRequests(){
        return statisticMapper.selectAllLoginRequest();
    }

    public LoginRequestDayCountDto getYearMonthDayLoginRequests(String year, String month, String day){
        return statisticMapper.selectYearMonthDayLoginRequest(year+month+day);
    }

    public DepartmentUserCountDto getLoginByDepartment(String department) {
        return statisticMapper.selectConnectedUserCountByDepartment(department);
    }

    public DepartmentMonthUserCountDto getDepartmentMonthUserCount(
            String department, String year, String month) {

         // "2024","08" -> "2408"
        DepartmentMonthUserCountDto dto =
                statisticMapper.selectDepartmentMonthUserCount(department, year+month);

        if (dto == null) {
            dto = new DepartmentMonthUserCountDto();
            dto.setDepartment(department);
            dto.setYearMonth(year+month);
            dto.setConnectedUserCount(0);
        }

        return dto;
    }

    public UserBoardSummaryDto getUserBoardSummary(String userId) {

        int count = statisticMapper.selectBoardCountByUserId(userId);
        List<BoardDto> boards = statisticMapper.selectBoardsByUserId(userId);

        UserBoardSummaryDto dto = new UserBoardSummaryDto();
        dto.setPostCount(count);
        dto.setBoards(boards);

        return dto;
    }

    public LoginCountDto getLoginCountExcludeHoliday() {
        return statisticMapper.selectLoginCountExcludeHoliday();
    }





}
