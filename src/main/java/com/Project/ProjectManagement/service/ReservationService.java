package com.Project.ProjectManagement.service;

import com.Project.ProjectManagement.entity.PerformanceSchedule;
import com.Project.ProjectManagement.entity.User;
import com.Project.ProjectManagement.repository.PerformanceScheduleRepository;
import com.Project.ProjectManagement.repository.ReservationRepository;
import com.Project.ProjectManagement.repository.ReservationSeatRepository;
import com.Project.ProjectManagement.repository.UserRepository;
import com.Project.ProjectManagement.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final PerformanceScheduleRepository performanceScheduleRepository;

    // 예약 생성
    public Reservation createReservation(Long userId, Long scheduleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        PerformanceSchedule schedule =
                performanceScheduleRepository.findById(scheduleId)
                        .orElseThrow(() -> new RuntimeException("공연 회차를 찾을 수 없습니다."));

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setSchedule(schedule);
        reservation.setReservationNo(UUID.randomUUID().toString());
        reservation.setStatus("RESERVED");
        reservation.setTotalAmount(0);
        reservation.setReservedAt(LocalDateTime.now());

        return reservationRepository.save(reservation);
    }

    //예약 조회
    public List<Reservation> getReservations(Long userId) {
        return reservationRepository.findByUser_UserId(userId);
    }


    public Reservation getReservationByNo(String reservationNo) {
        return reservationRepository.findByReservationNo(reservationNo)
                .orElseThrow(() -> new RuntimeException("예약을 찾을 수 없습니다."));
    }

}
