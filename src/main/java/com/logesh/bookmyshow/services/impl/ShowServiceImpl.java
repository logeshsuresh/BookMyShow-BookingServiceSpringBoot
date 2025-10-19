package com.logesh.bookmyshow.services.impl;

import com.logesh.bookmyshow.entities.Show;
import com.logesh.bookmyshow.repositories.ShowRepository;
import com.logesh.bookmyshow.services.ShowService;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public Show findShowById(Long showId) {
        return this.showRepository.findById(showId).orElseThrow(() -> new RuntimeException(String.format("ShowId: {} not found", showId)));
    }

}
