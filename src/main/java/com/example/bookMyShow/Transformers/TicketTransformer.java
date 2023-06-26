package com.example.bookMyShow.Transformers;

import com.example.bookMyShow.Dtos.ResponseDto.TicketResponseDto;
import com.example.bookMyShow.Modals.Show;
import com.example.bookMyShow.Modals.Ticket;

public class TicketTransformer {
    public static TicketResponseDto convertEntityToDto(Show show, Ticket ticket){
        TicketResponseDto responseDto= TicketResponseDto.builder()
                .movieName(show.getMovie().getMovieName())
                .bookedSeats(ticket.getBookedSeats())
                .location(show.getTheater().getLocation())
                .showDate(show.getDate())
                .showTime(show.getTime())
                .theaterName(show.getTheater().getName())
                .totalPrice(ticket.getTotalPrice())
                .build();
        return responseDto;
    }
}
