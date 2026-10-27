package com.Project.ProjectManagement.repository;

import com.Project.ProjectManagement.entity.ReservationSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReservationSeatRepository extends JpaRepository<ReservationSeat,Long> {
    List<ReservationSeat> findByReservation_ReservationId(Long reservationId);
}
