package com.Project.ProjectManagement.repository;

import com.Project.ProjectManagement.entity.PerformanceSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceScheduleRepository extends JpaRepository<PerformanceSchedule,Long> {
    List<PerformanceSchedule> findByPerformance_PerformanceId(Long performanceId);
}
