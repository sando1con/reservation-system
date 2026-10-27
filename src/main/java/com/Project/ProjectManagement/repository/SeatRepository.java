package com.Project.ProjectManagement.repository;

import com.Project.ProjectManagement.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findByHall_HallId(Long hallId);
}
