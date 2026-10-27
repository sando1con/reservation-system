package com.Project.ProjectManagement.service;

import com.Project.ProjectManagement.entity.Hall;
import com.Project.ProjectManagement.entity.Performance;
import com.Project.ProjectManagement.entity.PerformanceSchedule;
import com.Project.ProjectManagement.repository.HallRepository;
import com.Project.ProjectManagement.repository.PerformanceRepository;
import com.Project.ProjectManagement.repository.PerformanceScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class PerformanceScheduleService {
    private final PerformanceScheduleRepository performanceScheduleRepository;
    private final PerformanceRepository performanceRepository;
    private final HallRepository hallRepository;

    public List<PerformanceSchedule> getSchedules() {// 전체 검색 (아직 안씀)
        return performanceScheduleRepository.findAll();
    }

    //공연 회차 조회
    public List<PerformanceSchedule> getSchedulesByPerformance(Long performanceId) {
        return performanceScheduleRepository.findByPerformance_PerformanceId(performanceId);
    }

    //공연회차 생성
    public PerformanceSchedule createSchedule(
            Long performanceId,
            Long hallId,
            PerformanceSchedule schedule) {

        Performance performance = performanceRepository.findById(performanceId)
                .orElseThrow(() -> new RuntimeException("공연을 찾을 수 없습니다."));

        Hall hall = hallRepository.findById(hallId)
                .orElseThrow(() -> new RuntimeException("공연장을 찾을 수 없습니다."));

        schedule.setPerformance(performance);
        schedule.setHall(hall);

        return performanceScheduleRepository.save(schedule);
    }

}
