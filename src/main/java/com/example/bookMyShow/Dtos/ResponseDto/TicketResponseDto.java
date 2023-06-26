package com.example.bookMyShow.Dtos.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TicketResponseDto {
    private  String responseMessage;

    private String movieName;

    private LocalTime showTime;

    private Date showDate;

    private String theaterName;

    private String location;

    private String bookedSeats;

    private int totalPrice;

}
