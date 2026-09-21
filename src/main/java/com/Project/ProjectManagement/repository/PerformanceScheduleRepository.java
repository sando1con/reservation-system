package com.Project.ProjectManagement.repository;

import com.Project.ProjectManagement.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceScheduleRepository extends JpaRepository<Performance,Long> {
}
