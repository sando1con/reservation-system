package com.Project.ProjectManagement.repository;

import com.Project.ProjectManagement.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {


}
