package com.Project.ProjectManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "performances")
@Getter
@NoArgsConstructor
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performanceId;

    @Column(nullable = false, length = 50)
    private String title;

    private String description;

    @Column(nullable = false, length = 50)
    private String category;//공연 종류 ex)뮤지컬, 오케스트라

    @Column(name = "running_time")
    private Integer runningTime;//시작시간

    @Column(name = "age_limit")
    private Integer ageLimit;//나이제한


    @Column(length = 20)
    private Integer status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
