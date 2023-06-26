package com.example.bookMyShow.Controller;

import com.example.bookMyShow.Dtos.RequestDto.TicketRequestDto;
import com.example.bookMyShow.Dtos.ResponseDto.TicketResponseDto;
import com.example.bookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/bookTicket")
    public TicketResponseDto bookTicket(@RequestBody TicketRequestDto ticketRequestDto){
        try{
            TicketResponseDto responseDto=ticketService.bookTicket(ticketRequestDto);
            responseDto.setResponseMessage("Ticket has been booked !!");
            return responseDto;
        }
        catch (Exception e){
            TicketResponseDto ticketResponseDto=new TicketResponseDto();
            ticketResponseDto.setResponseMessage(e.getMessage());
            return  ticketResponseDto;
        }
    }
}
