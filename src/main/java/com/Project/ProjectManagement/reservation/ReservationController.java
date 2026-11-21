package com.Project.ProjectManagement.reservation;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public Reservation createReservation(@RequestParam Long userId, @RequestParam Long scheduleId){
        return reservationService.createReservation(userId, scheduleId);
    }

    @GetMapping
    public List<Reservation> getReservation(@RequestParam Long userId){
        return reservationService.getReservations(userId);
    }

    @GetMapping("/detail")
    public Reservation getReservationDetail(@RequestParam String reservationNo) {
        return reservationService.getReservationByNo(reservationNo);
    }

}
