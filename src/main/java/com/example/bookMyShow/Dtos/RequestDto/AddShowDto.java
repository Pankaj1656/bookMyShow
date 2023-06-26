package com.example.bookMyShow.Dtos.RequestDto;

import com.example.bookMyShow.Modals.Movie;
import com.example.bookMyShow.Modals.Theater;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
@Data
public class AddShowDto {
    private Date date;

    private LocalTime timeOfShow;

    private int movieId;

    private int theaterId;
}
