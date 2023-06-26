package com.example.bookMyShow.Controller;

import com.example.bookMyShow.Dtos.RequestDto.TheaterEntryDto;
import com.example.bookMyShow.Dtos.RequestDto.TheaterSeatsDto;
import com.example.bookMyShow.Service.TheaterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterController {

    @Autowired
    TheaterServices theaterServices;
    @PostMapping("/addTheater")
    public String addTheater(@RequestBody TheaterEntryDto theaterEntryDto){
        theaterServices.addTheater(theaterEntryDto);
        return "Theater has been added successfully";
    }
    @PostMapping("/addTheaterSeats")
    public ResponseEntity<String > addTheaterSeats(@RequestBody TheaterSeatsDto theaterSeatsDto){
        String res= theaterServices.addTheaterSeats(theaterSeatsDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }
}
