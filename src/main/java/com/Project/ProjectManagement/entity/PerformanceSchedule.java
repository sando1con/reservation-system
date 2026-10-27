package com.Project.ProjectManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.patterns.PerObject;

import java.time.LocalDateTime;
@Entity
@Table(name = "performanceSchedules")
@NoArgsConstructor
@Getter
@Setter
public class PerformanceSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "performance_id", nullable = false)
    private Performance performance;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @Column(length = 20)
    private String status;//

    private LocalDateTime startAt;
    private LocalDateTime createdAt;
}
