package com.Project.ProjectManagement.repository;

import com.Project.ProjectManagement.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance,Long> {
    List<Performance> findByCategory(String category);

    List<Performance> findByTitleContaining(String keyword);
}
