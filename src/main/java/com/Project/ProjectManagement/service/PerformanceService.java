package com.Project.ProjectManagement.service;

import com.Project.ProjectManagement.entity.Performance;
import com.Project.ProjectManagement.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceService {
    private final PerformanceRepository performanceRepository;

    public List<Performance> getPerformances() {// 전체 검색
        return performanceRepository.findAll();
    }

    public Performance getPerformance(Long performanceId) {
        return performanceRepository.findById(performanceId)
                .orElseThrow(() -> new IllegalArgumentException("공연을 찾을 수 없습니다."));
    }

    public List<Performance> getPerformancesByCategory(String category) { //카테고리 분류
        return performanceRepository.findByCategory(category);
    }

    public List<Performance> searchPerformances(String keyword) { // 검색
        return performanceRepository.findByTitleContaining(keyword);
    }
    public Performance createPerformance(Performance performance) { // 공연 생성
        return performanceRepository.save(performance);
    }
    public Performance updatePerformance(Long performanceId, Performance performance) { //공연 수정 및 삭제
        Performance existing = performanceRepository.findById(performanceId)
                .orElseThrow(() -> new IllegalArgumentException("공연을 찾을 수 없습니다."));

        existing.setTitle(performance.getTitle());
        existing.setDescription(performance.getDescription());
        existing.setCategory(performance.getCategory());
        existing.setRunningTime(performance.getRunningTime());
        existing.setAgeLimit(performance.getAgeLimit());
        existing.setStatus(performance.getStatus());

        return performanceRepository.save(existing);
    }

    public void deletePerformance(Long performanceId) {
        Performance performance = performanceRepository.findById(performanceId)
                .orElseThrow(() -> new IllegalArgumentException("공연을 찾을 수 없습니다."));

        performanceRepository.delete(performance);
    }
}
