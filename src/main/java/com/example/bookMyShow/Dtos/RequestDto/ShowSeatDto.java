package com.example.bookMyShow.Dtos.RequestDto;

import lombok.Data;

@Data
public class ShowSeatDto {
    private int showId;

    private int priceOfClassicSeats;

    private int priceOfPremiumSeats;
}
