package com.logesh.bookmyshow.entities;

import com.logesh.bookmyshow.enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat extends BaseModel {

    private String seatNumber;

    private Integer rowValue;

    private Integer columnValue;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne
    private Auditorium auditorium;

}
