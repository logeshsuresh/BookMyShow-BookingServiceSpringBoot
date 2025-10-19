package com.logesh.bookmyshow.controllers.v1;

import com.logesh.bookmyshow.dtos.requests.BlockSeatRequestDto;
import com.logesh.bookmyshow.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public boolean blockSeats(@RequestBody BlockSeatRequestDto blockSeatRequestDto) {
        return this.bookingService.blockSeats(blockSeatRequestDto.getShowId(), blockSeatRequestDto.getSeatIds(), blockSeatRequestDto.getUserId());
    }

}
