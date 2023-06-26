package com.example.bookMyShow.Dtos.RequestDto;

import lombok.Data;

@Data
public class TheaterSeatsDto {
    private Integer noOfColoums;

    private Integer noOfClassicSeats;

    private  Integer noOfPremiumSeats;

    private String location;
}
