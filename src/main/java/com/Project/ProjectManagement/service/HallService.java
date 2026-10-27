package com.Project.ProjectManagement.service;

import com.Project.ProjectManagement.entity.Hall;
import com.Project.ProjectManagement.entity.Venue;
import com.Project.ProjectManagement.repository.HallRepository;
import com.Project.ProjectManagement.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallRepository hallRepository;
    private final VenueRepository venueRepository;

    // 전체 조회
    public List<Hall> getHalls() {
        return hallRepository.findAll();
    }

    // 단건 조회
    public Hall getHall(Long hallId) {
        return hallRepository.findById(hallId)
                .orElseThrow(() -> new RuntimeException("극장을 찾을 수 없습니다."));
    }

    // 등록
    public Hall createHall(Long venueId, Hall hall) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("공연장을 찾을 수 없습니다."));

        hall.setVenue(venue);
        return hallRepository.save(hall);
    }

    // 수정
    public Hall updateHall(Long hallId, Hall request) {
        Hall hall = getHall(hallId);
        hall.setName(request.getName());
        hall.setCapacity(request.getCapacity());

        return hallRepository.save(hall);
    }

    // 삭제
    public void deleteHall(Long hallId) {
        Hall hall = getHall(hallId);
        hallRepository.delete(hall);
    }
}
