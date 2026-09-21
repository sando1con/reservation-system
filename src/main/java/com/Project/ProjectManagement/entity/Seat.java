package com.Project.ProjectManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "seats")
@Getter
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    @Column(name = "seat_row", length = 10)
    private String seatRow;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "seat_type", length = 20)
    private String seatType;

    private LocalDateTime createdAt;
}
