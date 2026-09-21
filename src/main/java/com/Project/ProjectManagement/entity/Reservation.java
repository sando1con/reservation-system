package com.Project.ProjectManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Getter
@Table(name = "reservations")
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private PerformanceSchedule schedule;

    @Column(unique = true, name ="reservation_no", length = 30)
    private String reservationNo;

    @Column(length = 20)
    private String status;

    @Column(name = "total_amount")
    private Integer totalAmount;

    private LocalDateTime reservedAt;
    private LocalDateTime cancelledAt;
}
