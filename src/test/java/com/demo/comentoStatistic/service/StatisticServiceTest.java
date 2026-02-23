package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StatisticServiceTest {
    @Mock
    private StatisticMapper statisticMapper;

    @InjectMocks
    private StatisticService statisticService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /* =========================
       1. 연도 로그인
    ========================= */

    @Test
    void getYearLogins_success() {
        YearCountDto dto = new YearCountDto();
        dto.setTotCnt(10);

        when(statisticMapper.selectYearLogin("24")).thenReturn(dto);

        YearCountDto result = statisticService.getYearLogins("24");

        assertThat(result.getTotCnt()).isEqualTo(10);
    }

    @Test
    void getYearLogins_invalidFormat() {
        assertThatThrownBy(() -> statisticService.getYearLogins("2024"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getYearLogins_noData() {
        when(statisticMapper.selectYearLogin("24")).thenReturn(null);

        assertThatThrownBy(() -> statisticService.getYearLogins("24"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* =========================
       2. 연월 로그인
    ========================= */

    @Test
    void getYearMonthLogins_success() {
        YearMonthCountDto dto = new YearMonthCountDto();
        dto.setTotCnt(5);

        when(statisticMapper.selectYearMonthLogin("2401"))
                .thenReturn(dto);

        YearMonthCountDto result =
                statisticService.getYearMonthLogins("24", "01");

        assertThat(result.getTotCnt()).isEqualTo(5);
    }

    @Test
    void getYearMonthLogins_invalidMonth() {
        assertThatThrownBy(() ->
                statisticService.getYearMonthLogins("24", "13"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* =========================
       3. 연월일 로그인
    ========================= */

    @Test
    void getYearMonthDayLogins_success() {
        YearMonthDayCountDto dto = new YearMonthDayCountDto();
        dto.setTotCnt(3);

        when(statisticMapper.selectYearMonthDayLogin("240101"))
                .thenReturn(dto);

        YearMonthDayCountDto result =
                statisticService.getYearMonthDayLogins("24", "01", "01");

        assertThat(result.getTotCnt()).isEqualTo(3);
    }

    @Test
    void getYearMonthDayLogins_invalidDay() {
        assertThatThrownBy(() ->
                statisticService.getYearMonthDayLogins("24", "01", "32"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* =========================
       4. 전체 로그인
    ========================= */

    @Test
    void getAllLogins_success() {
        LoginCountDto dto = new LoginCountDto();
        dto.setTotCnt(100);

        when(statisticMapper.selectAllLogin()).thenReturn(dto);

        LoginCountDto result = statisticService.getAllLogins();

        assertThat(result.getTotCnt()).isEqualTo(100);
    }

    /* =========================
       5. 평균 로그인
    ========================= */

    @Test
    void getAvgDailyLogin_null() {
        when(statisticMapper.selectAvgDailyLogin()).thenReturn(null);

        AverageDailyLoginCountDto result =
                statisticService.getAvgDailyLogin();

        assertThat(result.getAverageDailyLoginCount())
                .isEqualTo(0.0);
    }

    /* =========================
       6. 로그인 요청 전체
    ========================= */

    @Test
    void getLoginRequests_null() {
        when(statisticMapper.selectAllLoginRequest())
                .thenReturn(null);

        LoginRequestCountDto result =
                statisticService.getLoginRequests();

        assertThat(result.getTotCnt()).isEqualTo(0);
    }

    /* =========================
       7. 로그인 요청 일별
    ========================= */

    @Test
    void getLoginRequestByDay_success() {
        LoginRequestDayCountDto dto =
                new LoginRequestDayCountDto();

        when(statisticMapper
                .selectYearMonthDayLoginRequest("240101"))
                .thenReturn(dto);

        LoginRequestDayCountDto result =
                statisticService.getLoginRequestByDay(
                        "24", "01", "01");

        assertThat(result).isNotNull();
    }

    @Test
    void getLoginRequestByDay_noData() {
        when(statisticMapper
                .selectYearMonthDayLoginRequest("240101"))
                .thenReturn(null);

        assertThatThrownBy(() ->
                statisticService.getLoginRequestByDay(
                        "24", "01", "01"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* =========================
       8. 부서 로그인
    ========================= */

    @Test
    void getLoginByDepartment_success() {
        DepartmentUserCountDto dto =
                new DepartmentUserCountDto();
        dto.setConnectedUserCount(4);

        when(statisticMapper
                .selectConnectedUserCountByDepartment("IT"))
                .thenReturn(dto);

        DepartmentUserCountDto result =
                statisticService.getLoginByDepartment("IT");

        assertThat(result.getConnectedUserCount())
                .isEqualTo(4);
    }

    @Test
    void getLoginByDepartment_notExist() {
        when(statisticMapper
                .selectConnectedUserCountByDepartment("IT"))
                .thenReturn(null);

        assertThatThrownBy(() ->
                statisticService.getLoginByDepartment("IT"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* =========================
       9. 부서 월별 로그인
    ========================= */

    @Test
    void getDepartmentMonthUserCount_success() {
        DepartmentMonthUserCountDto dto =
                new DepartmentMonthUserCountDto();
        dto.setConnectedUserCount(7);

        when(statisticMapper
                .selectDepartmentMonthUserCount(
                        "IT", "24", "01"))
                .thenReturn(dto);

        DepartmentMonthUserCountDto result =
                statisticService.getDepartmentMonthUserCount(
                        "IT", "24", "01");

        assertThat(result.getConnectedUserCount())
                .isEqualTo(7);
    }

    @Test
    void getDepartmentMonthUserCount_noLoginData() {
        DepartmentMonthUserCountDto dto =
                new DepartmentMonthUserCountDto();
        dto.setConnectedUserCount(0);

        when(statisticMapper
                .selectDepartmentMonthUserCount(
                        "IT", "24", "01"))
                .thenReturn(dto);

        assertThatThrownBy(() ->
                statisticService.getDepartmentMonthUserCount(
                        "IT", "24", "01"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* =========================
       10. 사용자 게시글 요약
    ========================= */

    @Test
    void getUserBoardSummary_success() {
        when(statisticMapper
                .selectBoardCountByUserId("user1"))
                .thenReturn(2);

        when(statisticMapper
                .selectBoardsByUserId("user1"))
                .thenReturn(Collections.emptyList());

        UserBoardSummaryDto result =
                statisticService.getUserBoardSummary("user1");

        assertThat(result.getBoardCount()).isEqualTo(2);
    }

    @Test
    void getUserBoardSummary_noBoard() {
        when(statisticMapper
                .selectBoardCountByUserId("user1"))
                .thenReturn(0);

        assertThatThrownBy(() ->
                statisticService.getUserBoardSummary("user1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* =========================
       11. 공휴일 제외 로그인
    ========================= */

    @Test
    void getLoginCountExcludeHoliday_null() {
        when(statisticMapper
                .selectLoginCountExcludeHoliday())
                .thenReturn(null);

        LoginCountDto result =
                statisticService.getLoginCountExcludeHoliday();

        assertThat(result.getTotCnt()).isEqualTo(0);
    }
}
