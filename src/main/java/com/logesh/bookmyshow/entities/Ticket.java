package com.logesh.bookmyshow.entities;

import com.logesh.bookmyshow.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseModel {

    private BigDecimal amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @OneToMany
    private Set<ShowSeat> showSeats;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;

}
