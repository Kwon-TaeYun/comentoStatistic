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

    @GetMapping(value = "/logins/departments",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getDepartmentLogin(
            @RequestParam String department,
            @RequestParam(required = false) String year,
            @RequestParam(required = false) String month
    ) {
        try {

            // department만 있는 경우
            if (year == null && month == null) {
                DepartmentUserCountDto dto =
                        statisticService.getLoginByDepartment(department);

                return ResponseEntity.ok(
                        ApiResponse.success(dto, "부서별 접속자 수 조회 성공")
                );
            }

            // year + month 둘 다 있어야 함
            if (year != null && month != null) {
                DepartmentMonthUserCountDto dto =
                        statisticService.getDepartmentMonthUserCount(
                                department, year, month
                        );

                return ResponseEntity.ok(
                        ApiResponse.success(
                                dto,
                                year + "년 " + month + "월 "
                                        + department + " 부서 로그인 통계 조회 성공"
                        )
                );
            }

            // year만 있거나 month만 있는 경우
            throw new IllegalArgumentException(
                    "year와 month는 함께 전달되어야 합니다."
            );

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.fail(e.getMessage()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.fail("서버 오류가 발생했습니다."));
        }
    }


    @GetMapping(value = "/logins/statistic/daily-average",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getAverageDailyLoginCount() {
        try {
            return ResponseEntity.ok(
                    ApiResponse.success(
                            statisticService.getAvgDailyLogin(),
                            "일 평균 로그인 수 조회 성공"
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.fail("서버 오류가 발생했습니다."));
        }
    }

    @GetMapping(value = "/logins/statistic/exclude-holidays",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getLoginExcludeHoliday() {
        try {
            return ResponseEntity.ok(
                    ApiResponse.success(
                            statisticService.getLoginCountExcludeHoliday(),
                            "휴일 제외 로그인 수 조회 성공"
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.fail("서버 오류가 발생했습니다."));
        }
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

    @GetMapping("/api/v1/boards/users/{userId}")
    public ResponseEntity<UserBoardSummaryDto> getBoardsByUser(
            @PathVariable String userId) {

        return ResponseEntity.ok(
                statisticService.getUserBoardSummary(userId)
        );
    }

}
