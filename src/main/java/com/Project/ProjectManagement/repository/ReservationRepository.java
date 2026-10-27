package com.Project.ProjectManagement.repository;

import com.Project.ProjectManagement.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByUser_UserId(Long userId);

    Optional<Reservation> findByReservationNo(String reservationNo);


}
