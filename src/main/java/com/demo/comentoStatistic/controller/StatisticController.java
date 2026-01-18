package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.config.ApiResponse;
import com.demo.comentoStatistic.dto.*;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/v1")
public class StatisticController {

    @Autowired
    StatisticService statisticService;


//    @GetMapping(value="/logins", produces = "application/json")
//    @ResponseBody
//    public ResponseEntity<?> getYearLoginCount(@RequestParam("year") String year) {
//        try {
//            YearCountDto result = statisticService.getYearLogins(year);
//            return ResponseEntity.ok(ApiResponse.success(result, year + "년 로그인 통계 조회 성공!"));
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(ApiResponse.fail(e.getMessage()));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(ApiResponse.fail("서버 오류가 발생했습니다."));
//        }
//    }
//
//    @GetMapping(value="/logins", produces = "application/json")
//    @ResponseBody
//    public Object getYearMonthLoginCount(@RequestParam("year") String year, @RequestParam("month") String month){
//        try {
//            YearMonthCountDto result = statisticService.getYearMonthLogins(year, month);
//            return ResponseEntity.ok(ApiResponse.success(result, year + "년 " + month + "월 로그인 통계 조회 성공!"));
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(ApiResponse.fail(e.getMessage()));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(ApiResponse.fail("서버 오류가 발생했습니다."));
//        }
//    }

    @GetMapping(value = "/logins", produces = "application/json")
    public ResponseEntity<?> getLoginCount(
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "month", required = false) String month,
            @RequestParam(value = "day", required = false) String day
    ) {
        try {

            // 🔹 조건 없음 → 전체 조회
            if (year == null) {
                LoginCountDto result = statisticService.getAllLogins();
                return ResponseEntity.ok(
                        ApiResponse.success(result, "전체 로그인 통계 조회 성공!")
                );
            }

            // 🔹 year + month + day
            if (month != null && day != null) {
                YearMonthDayCountDto result =
                        statisticService.getYearMonthDayLogins(year, month, day);
                return ResponseEntity.ok(
                        ApiResponse.success(result,
                                year + "년 " + month + "월 " + day + "일 로그인 통계 조회 성공!")
                );
            }

            // 🔹 year + month
            if (month != null) {
                YearMonthCountDto result =
                        statisticService.getYearMonthLogins(year, month);
                return ResponseEntity.ok(
                        ApiResponse.success(result,
                                year + "년 " + month + "월 로그인 통계 조회 성공!")
                );
            }

            // 🔹 year only
            YearCountDto result = statisticService.getYearLogins(year);
            return ResponseEntity.ok(
                    ApiResponse.success(result,
                            year + "년 로그인 통계 조회 성공!")
            );

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ApiResponse.fail(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.fail("서버 오류가 발생했습니다."));
        }
    }

    @RequestMapping(value="/api/v1/logins/average", produces = "application/json")
    @ResponseBody
    public Object getAverageDailyLoginCount(){

        return ResponseEntity.ok(statisticService.getAvgDailyLogin());
    }

    @RequestMapping(value="/api/v1/requests", produces = "application/json")
    @ResponseBody
    public Object getLoginRequestCount(){

        return ResponseEntity.ok(statisticService.getLoginRequests());
    }

    @RequestMapping(value="/api/v1/requests/{year}/{month}/{day}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthDayLoginRequestCount(@PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("day") String day){

        return ResponseEntity.ok(statisticService.getYearMonthDayLoginRequests(year, month, day));
    }

    @RequestMapping(value="/api/v1/logins/departments/{department}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<DepartmentUserCountDto> getByDepartmentLogin(
            @PathVariable String department) {

        // URL 디코딩으로 한글 깨짐 방지
        String decodedDept = URLDecoder.decode(department, StandardCharsets.UTF_8);

        DepartmentUserCountDto dto = statisticService.getLoginByDepartment(decodedDept);

        if (dto == null) {
            // 조회 결과 없으면 빈 DTO 반환
            dto = new DepartmentUserCountDto();
            dto.setDepartment(decodedDept);
            dto.setConnectedUserCount(0);
        }

        return ResponseEntity.ok(dto);
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}/departments/{department}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<DepartmentMonthUserCountDto> getDepartmentMonthLogin(
            @PathVariable String year,
            @PathVariable String month,
            @PathVariable String department) {

        // 한글 디코딩
        String decodedDept = URLDecoder.decode(department, StandardCharsets.UTF_8);

        DepartmentMonthUserCountDto dto =
                statisticService.getDepartmentMonthUserCount(decodedDept, year, month);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/api/v1/boards/users/{userId}")
    public ResponseEntity<UserBoardSummaryDto> getBoardsByUser(
            @PathVariable String userId) {

        return ResponseEntity.ok(
                statisticService.getUserBoardSummary(userId)
        );
    }

    @GetMapping("/api/v1/logins/exclude-holidays")
    public LoginCountDto getLoginExcludeHoliday() {
        return statisticService.getLoginCountExcludeHoliday();
    }
}
