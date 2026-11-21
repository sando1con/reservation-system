package com.Project.ProjectManagement.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByUser_UserId(Long userId);

    Optional<Reservation> findByReservationNo(String reservationNo);


}
