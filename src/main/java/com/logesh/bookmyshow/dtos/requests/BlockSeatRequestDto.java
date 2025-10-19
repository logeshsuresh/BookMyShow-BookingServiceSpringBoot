package com.logesh.bookmyshow.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
public class BlockSeatRequestDto {

    private Long showId;

    private Long userId;

    private List<Long> seatIds;

}
