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

    public YearCountDto getYearLogins(String year) {
        // 숫자 체크
        if (!year.matches("\\d{2}")) {
            throw new IllegalArgumentException("year는 2자리 숫자여야 합니다.");
        }

        YearCountDto result = statisticMapper.selectYearLogin(year);
        if (result == null || result.getTotCnt() == 0) {
            throw new IllegalArgumentException(year + "년의 로그인 데이터가 없습니다.");
        }

        return result;
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){
        if (!year.matches("\\d{2}")) {
            throw new IllegalArgumentException("year 형식이 올바르지 않습니다.");
        }

        if (!month.matches("0[1-9]|1[0-2]")) {
            throw new IllegalArgumentException("month는 01~12 사이여야 합니다.");
        }

        YearMonthCountDto result = statisticMapper.selectYearMonthLogin(year+month);
        if (result == null || result.getTotCnt() == 0) {
            throw new IllegalArgumentException(year + "년 " + month + "월의 로그인 데이터가 없습니다.");
        }

        return result;
    }

    public YearMonthDayCountDto getYearMonthDayLogins(String year, String month, String day){
        if (!year.matches("\\d{2}")) {
            throw new IllegalArgumentException("year 형식이 올바르지 않습니다.");
        }

        if (!month.matches("0[1-9]|1[0-2]")) {
            throw new IllegalArgumentException("month는 01~12 사이여야 합니다.");
        }

        if (!day.matches("0[1-9]|1[0-9]|2[0-9]|3[0-1]")) {
            throw new IllegalArgumentException("day는 01~31 사이여야 합니다.");
        }

        YearMonthDayCountDto result = statisticMapper.selectYearMonthDayLogin(year + month + day);
        if (result == null || result.getTotCnt() == 0) {
            throw new IllegalArgumentException(year + "년 " + month + "월 " + day + "일의 로그인 데이터가 없습니다.");
        }

        return result;
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

        DepartmentUserCountDto dto =
                statisticMapper.selectConnectedUserCountByDepartment(department);

        if (dto == null) {
            throw new IllegalArgumentException("존재하지 않는 부서입니다.");
        }

        if (dto.getConnectedUserCount() == 0) {
            throw new IllegalArgumentException("해당 부서의 접속자 수가 없습니다.");
        }

        return dto;
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
