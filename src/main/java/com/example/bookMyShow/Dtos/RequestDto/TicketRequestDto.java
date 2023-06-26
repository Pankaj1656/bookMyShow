package com.example.bookMyShow.Dtos.RequestDto;

import com.example.bookMyShow.Modals.Show;
import com.example.bookMyShow.Modals.ShowSeat;
import com.example.bookMyShow.Modals.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
public class TicketRequestDto {

    private Integer userId;

    private Integer showId;

    private List<String> requestedSeats;
}
