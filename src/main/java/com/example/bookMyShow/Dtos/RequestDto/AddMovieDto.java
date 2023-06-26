package com.example.bookMyShow.Dtos.RequestDto;

import com.example.bookMyShow.Enums.Genre;
import com.example.bookMyShow.Enums.Languages;
import com.example.bookMyShow.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class AddMovieDto {
    private String movieName;

    private Double duration;

    private  Double rating;

    private Genre genre;

    private Languages languages;

    private Date releaseDate;
}
