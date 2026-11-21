package com.Project.ProjectManagement.reservationSeat;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservationseats")
@RequiredArgsConstructor
public class ReservationSeatController {

    private final ReservationSeatService reservationSeatService;

    @PostMapping
    public ReservationSeat createReservationSeat(@RequestParam Long reservationId,
                                                 @RequestParam Long seatId, @RequestParam Integer price) {

        return reservationSeatService.createReservationSeat(
                reservationId, seatId, price);
    }

    @GetMapping
    public List<ReservationSeat> getReservationSeats(
            @RequestParam Long reservationId) {
        return reservationSeatService.getReservationSeats(reservationId);
    }
}
