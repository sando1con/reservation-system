package com.Project.ProjectManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @Column(unique = true,name ="payment_no", length = 30)
    private String paymentNo;

    private Integer amount;

    @Column(length = 30)
    private String method;

    @Column(length = 20)
    private String status;

    private LocalDateTime paidAt;
    private LocalDateTime cancelledAt;
}
