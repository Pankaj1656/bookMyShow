package com.example.bookMyShow.Transformers;

import com.example.bookMyShow.Dtos.RequestDto.AddMovieDto;
import com.example.bookMyShow.Modals.Movie;

public class MovieTransformer {
    public static Movie convertDtoToEntity(AddMovieDto addMovieDto){
        Movie movie= Movie.builder()
                .movieName(addMovieDto.getMovieName())
                .duration(addMovieDto.getDuration())
                .genre(addMovieDto.getGenre())
                .language(addMovieDto.getLanguages())
                .releaseDate(addMovieDto.getReleaseDate())
                .rating(addMovieDto.getRating())
                .build();

        return movie;
    }
}
