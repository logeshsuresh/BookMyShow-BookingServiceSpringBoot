package com.logesh.bookmyshow.services.impl;

import com.logesh.bookmyshow.entities.Show;
import com.logesh.bookmyshow.entities.ShowSeat;
import com.logesh.bookmyshow.entities.Ticket;
import com.logesh.bookmyshow.entities.User;
import com.logesh.bookmyshow.enums.ShowSeatStatus;
import com.logesh.bookmyshow.enums.TicketStatus;
import com.logesh.bookmyshow.repositories.ShowSeatRepository;
import com.logesh.bookmyshow.services.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class RedisBookingServiceImpl implements BookingService {

    private final CacheService cacheService;
    private final ShowService showService;
    private final UserService userService;
    private final ShowSeatRepository showSeatRepository;
    private final TicketService ticketService;

    public RedisBookingServiceImpl(CacheService cacheService, ShowService showService, UserService userService, ShowSeatRepository showSeatRepository, TicketService ticketService) {
        this.cacheService = cacheService;
        this.showService = showService;
        this.userService = userService;
        this.showSeatRepository = showSeatRepository;
        this.ticketService = ticketService;
    }

    @Override
    public boolean blockSeats(Long showId, List<Long> seatIds, Long userId) {
        List<ShowSeat> showSeats = this.showSeatRepository.findAllByShowIdAndSeatIdIn(showId, seatIds);
        for (ShowSeat showSeat : showSeats) {
            if (showSeat.getStatus() == ShowSeatStatus.BOOKED) {
                return false;
            }
        }
        for (ShowSeat showSeat : showSeats) {
            Object status = this.cacheService.get("seatId-"+showSeat.getId()+"userId-"+userId);
            if (Objects.nonNull(status)) {
                return false;
            }
        }
        System.out.println("Printing keys & values before locking");
        this.cacheService.getAllKeysAndValues();
        for (ShowSeat showSeat : showSeats) {
            this.cacheService.set("seatId-"+showSeat.getId()+"userId-"+userId, ShowSeatStatus.LOCKED.name(), 1, TimeUnit.MINUTES);
        }
        System.out.println("Printing keys & values after locking");
        this.cacheService.getAllKeysAndValues();
        return true;
    }

    @Override
    public Optional<Ticket> bookTicket(Long showId, List<Long> seatIds, Long userId) {
        for (Long seatId : seatIds) {
            Object status = this.cacheService.get("seatId-"+seatId+"userId-"+userId);
            if (Objects.isNull(status)) {
                return Optional.empty();
            }
        }
        Show show = this.showService.findShowById(showId);
        User user = this.userService.findUserById(userId);
        Set<ShowSeat> showSeats = this.showSeatRepository.findAllByShowIdAndSeatIdIn(showId, seatIds).stream().collect(Collectors.toUnmodifiableSet());
        Ticket ticket = Ticket.builder()
                .show(show)
                .user(user)
                .showSeats(showSeats)
                .status(TicketStatus.BOOKED)
                .build();
        this.ticketService.save(ticket);
        return Optional.of(ticket);
    }

}
