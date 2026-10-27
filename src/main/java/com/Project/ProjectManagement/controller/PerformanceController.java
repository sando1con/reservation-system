package com.Project.ProjectManagement.controller;

import com.Project.ProjectManagement.entity.Performance;
import com.Project.ProjectManagement.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performances")
@RequiredArgsConstructor
public class PerformanceController {
    private final PerformanceService performanceService;

    @GetMapping
    public List<Performance> getPerformances( // 카테고리 분류랑 검색 기능
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword
    ) {
        if (category != null) { //없을때 기본
            return performanceService.getPerformancesByCategory(category);
        }

        if (keyword != null) {
            return performanceService.searchPerformances(keyword);
        }

        return performanceService.getPerformances();
    }

    @GetMapping("/{performanceId}") //공연 id 검색
    public Performance getsPerformance(@PathVariable Long performanceId) {
        return performanceService.getPerformance(performanceId);
    }

    @PostMapping
    public Performance createPerformance(@RequestBody Performance performance) { //공연 생성후 저장
        return performanceService.createPerformance(performance);
    }

    @PutMapping("/{performanceId}")
    public Performance updatePerformance(@PathVariable Long performanceId, @RequestBody Performance performance) {
        return performanceService.updatePerformance(performanceId, performance);
    }

    @DeleteMapping("/{performanceId}")
    public void deletePerformance(@PathVariable Long performanceId) {
        performanceService.deletePerformance(performanceId);
    }
}
