package com.example.bookMyShow.Service;

import com.example.bookMyShow.Dtos.RequestDto.AddMovieDto;
import com.example.bookMyShow.Modals.Movie;
import com.example.bookMyShow.Repository.MovieRepository;
import com.example.bookMyShow.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(AddMovieDto addMovieDto) {
        Movie movie= MovieTransformer.convertDtoToEntity(addMovieDto);
        movieRepository.save(movie);
        return "Movie has been added successfully";
    }
}
