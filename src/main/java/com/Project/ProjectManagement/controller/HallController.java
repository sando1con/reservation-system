package com.Project.ProjectManagement.controller;

import com.Project.ProjectManagement.entity.Hall;
import com.Project.ProjectManagement.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
@RequiredArgsConstructor
public class HallController {

    private final HallService hallService;

    @GetMapping
    public List<Hall> getHalls() {
        return hallService.getHalls();
    }

    @GetMapping("/{hallId}")
    public Hall getHall(@PathVariable Long hallId) {
        return hallService.getHall(hallId);
    }

    @PostMapping
    public Hall createHall(@RequestParam Long venueId, @RequestBody Hall hall) {
        return hallService.createHall(venueId, hall);
    }

    @PutMapping("/{hallId}")
    public Hall updateHall(@PathVariable Long hallId, @RequestBody Hall hall) {
        return hallService.updateHall(hallId, hall);
    }

    @DeleteMapping("/{hallId}")
    public void deleteHall(@PathVariable Long hallId) {
        hallService.deleteHall(hallId);
    }
}
