package com.Project.ProjectManagement.service;

import com.Project.ProjectManagement.entity.Hall;
import com.Project.ProjectManagement.entity.Seat;
import com.Project.ProjectManagement.repository.HallRepository;
import com.Project.ProjectManagement.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    private final HallRepository hallRepository;

    // 특정 극장의 좌석 조회
    public List<Seat> getSeatsByHall(Long hallId) {
        return seatRepository.findByHall_HallId(hallId);
    }

    // 좌석 등록
    public Seat createSeat(Long hallId, Seat seat) {
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow(() -> new RuntimeException("극장을 찾을 수 없습니다."));

        seat.setHall(hall);

        return seatRepository.save(seat);
    }
    // 좌석 수정
    public Seat updateSeat(Long seatId, Seat request) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("좌석을 찾을 수 없습니다."));

        seat.setSeatRow(request.getSeatRow());
        seat.setSeatNumber(request.getSeatNumber());
        seat.setSeatType(request.getSeatType());

        return seatRepository.save(seat);
    }

    // 좌석 삭제
    public void deleteSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("좌석을 찾을 수 없습니다."));

        seatRepository.delete(seat);
    }
}