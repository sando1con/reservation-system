package com.Project.ProjectManagement.controller;

import com.Project.ProjectManagement.entity.PerformanceSchedule;
import com.Project.ProjectManagement.service.PerformanceScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performances/{performanceId}/schedules")
@RequiredArgsConstructor
public class PerformanceScheduleController {
    private final PerformanceScheduleService performanceScheduleService;

    @GetMapping
    public List<PerformanceSchedule> getSchedulesByPerformance(//공연 회차 조회
            @PathVariable Long performanceId) {
        return performanceScheduleService.getSchedulesByPerformance(performanceId);
    }

    @PostMapping
    public PerformanceSchedule createSchedule(
            @PathVariable Long performanceId,
            @RequestParam Long hallId,
            @RequestBody PerformanceSchedule schedule) {

        return performanceScheduleService.createSchedule(
                performanceId, hallId, schedule);
    }
}
