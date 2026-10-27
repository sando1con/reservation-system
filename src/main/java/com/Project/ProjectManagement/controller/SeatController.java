package com.Project.ProjectManagement.controller;

import com.Project.ProjectManagement.entity.Hall;
import com.Project.ProjectManagement.entity.Seat;
import com.Project.ProjectManagement.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    // 특정 극장의 좌석 조회
    @GetMapping
    public List<Seat> getSeatsByHall(@RequestParam Long hallId) {
        return seatService.getSeatsByHall(hallId);
    }

    // 좌석 등록
    @PostMapping
    public Seat createSeat(@RequestParam Long hallId, @RequestBody Seat seat) {
        return seatService.createSeat(hallId, seat);
    }

    @PutMapping("/{seatId}")
    public Seat updateSeat(@PathVariable Long seatId, @RequestBody Seat seat) {
        return seatService.updateSeat(seatId, seat);
    }

    @DeleteMapping("/{seatId}")
    public void deleteSeat(@PathVariable Long seatId) {
        seatService.deleteSeat(seatId);
    }
}
