package com.example.bookMyShow.Controller;

import com.example.bookMyShow.Dtos.RequestDto.AddMovieDto;
import com.example.bookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody AddMovieDto addMovieDto){
        String response=movieService.addMovie(addMovieDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
