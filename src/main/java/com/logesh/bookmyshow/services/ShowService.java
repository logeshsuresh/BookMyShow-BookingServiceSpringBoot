package com.logesh.bookmyshow.services;

import com.logesh.bookmyshow.entities.Show;

public interface ShowService {
    Show findShowById(Long showId);
}
