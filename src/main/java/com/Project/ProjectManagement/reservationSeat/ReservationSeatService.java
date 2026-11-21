package com.Project.ProjectManagement.reservationSeat;

import com.Project.ProjectManagement.reservation.Reservation;
import com.Project.ProjectManagement.seat.Seat;
import com.Project.ProjectManagement.reservation.ReservationRepository;
import com.Project.ProjectManagement.seat.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationSeatService {
    private final ReservationSeatRepository reservationSeatRepository;
    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;

    // 예약 좌석 등록
    public ReservationSeat createReservationSeat(
            Long reservationId, Long seatId, Integer price) {

        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("예약을 찾을 수 없습니다."));

        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("좌석을 찾을 수 없습니다."));

        ReservationSeat reservationSeat = new ReservationSeat();
        reservationSeat.setReservation(reservation);
        reservationSeat.setSeat(seat);
        reservationSeat.setPrice(price);

        return reservationSeatRepository.save(reservationSeat);
    }
    public List<ReservationSeat> getReservationSeats(Long reservationId) {
        return reservationSeatRepository.findByReservation_ReservationId(reservationId);
    }

}
