package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value="/api/v1/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){

        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){

        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}/{day}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthDayLoginCount(@PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("day") String day){

        return ResponseEntity.ok(statisticService.getYearMonthDayLogins(year, month, day));
    }

    @RequestMapping(value="/api/v1/logins", produces = "application/json")
    @ResponseBody
    public Object getYearMonthDayLoginCount(){

        return ResponseEntity.ok(statisticService.getAllLogins());
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

}