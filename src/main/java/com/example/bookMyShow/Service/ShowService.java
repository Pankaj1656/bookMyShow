package com.example.bookMyShow.Service;

import com.example.bookMyShow.Dtos.RequestDto.AddShowDto;
import com.example.bookMyShow.Dtos.RequestDto.ShowSeatDto;
import com.example.bookMyShow.Enums.SeatType;
import com.example.bookMyShow.Exceptions.ShowNotFound;
import com.example.bookMyShow.Modals.*;
import com.example.bookMyShow.Repository.MovieRepository;
import com.example.bookMyShow.Repository.ShowRepository;
import com.example.bookMyShow.Repository.TheaterRepository;
import com.example.bookMyShow.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    public String addShow(AddShowDto addShowDto) {
        Movie movie=movieRepository.findById(addShowDto.getMovieId()).get();
        Theater theater=theaterRepository.findById(addShowDto.getTheaterId()).get();

        Show show=new Show();
        show.setDate(addShowDto.getDate());
        show.setTime(addShowDto.getTimeOfShow());
        show.setMovie(movie);
        show.setTheater(theater);
        showRepository.save(show);

        movie.getShowList().add(show);
        movieRepository.save(movie);

        theater.getShowList().add(show);
        theaterRepository.save(theater);
        return "Show has been added";
    }

    public String associateSeats(ShowSeatDto showSeatsDto) throws ShowNotFound {
        Optional<Show> optionalShow = showRepository.findById(showSeatsDto.getShowId());

        //Validation check
        if(!optionalShow.isPresent()){
            throw new ShowNotFound("Show Id incorrect!!");
        }

        //Valid Show Now
        Show show = optionalShow.get();



        //We need to theaterSeats
        Theater theater = show.getTheater();

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        //Each seat needs to be added in the ?????? -->

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(TheaterSeat theaterSeat : theaterSeatList){

            ShowSeat showSeat = new ShowSeat();

            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC))
                showSeat.setPrice(showSeatsDto.getPriceOfClassicSeats());
            else
                showSeat.setPrice(showSeatsDto.getPriceOfPremiumSeats());

            //Foreign key mapping
            showSeat.setShow(show);
            showSeat.setAvailable(true);
            showSeat.setFoodAttached(false);


            showSeatList.add(showSeat);
        }
        showRepository.save(show);
        //Child will automatically get saved.....

        return "Show seats has been successfully added";
    }
}
