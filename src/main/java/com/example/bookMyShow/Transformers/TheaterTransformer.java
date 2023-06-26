package com.example.bookMyShow.Transformers;

import com.example.bookMyShow.Dtos.RequestDto.TheaterEntryDto;
import com.example.bookMyShow.Modals.Theater;
import lombok.Data;

@Data
public class TheaterTransformer {
    public static Theater convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        Theater theater= Theater.builder()
                .name(theaterEntryDto.getName())
                .location(theaterEntryDto.getLocation())
                .build();
        return theater;
    }

}
