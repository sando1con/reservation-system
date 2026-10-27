package com.Project.ProjectManagement.service;

import com.Project.ProjectManagement.entity.Venue;
import com.Project.ProjectManagement.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VenueService {
    private final VenueRepository venueRepository;
    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }
}
