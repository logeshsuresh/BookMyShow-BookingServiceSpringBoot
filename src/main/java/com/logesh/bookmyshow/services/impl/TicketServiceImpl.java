package com.logesh.bookmyshow.services.impl;

import com.logesh.bookmyshow.entities.Ticket;
import com.logesh.bookmyshow.repositories.TicketRepository;
import com.logesh.bookmyshow.services.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void save(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

}
