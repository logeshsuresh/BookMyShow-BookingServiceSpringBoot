package com.logesh.bookmyshow.services;

import com.logesh.bookmyshow.entities.ShowSeat;
import com.logesh.bookmyshow.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    boolean blockSeats(Long showId, List<Long> seatIds, Long userId);
    Optional<Ticket> bookTicket(Long showId, List<Long> seatIds, Long userId);
}
