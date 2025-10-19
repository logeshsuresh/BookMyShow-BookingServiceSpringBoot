package com.logesh.bookmyshow.entities;

import com.logesh.bookmyshow.enums.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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

    @ManyToOne
    private ShowSeat showSeat;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;

}
