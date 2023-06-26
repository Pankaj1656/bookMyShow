package com.example.bookMyShow.Service;


import com.example.bookMyShow.Dtos.RequestDto.TicketRequestDto;
import com.example.bookMyShow.Dtos.ResponseDto.TicketResponseDto;
import com.example.bookMyShow.Exceptions.NoUserFound;
import com.example.bookMyShow.Exceptions.ShowNotFound;
import com.example.bookMyShow.Modals.Show;
import com.example.bookMyShow.Modals.ShowSeat;
import com.example.bookMyShow.Modals.Ticket;
import com.example.bookMyShow.Modals.User;
import com.example.bookMyShow.Repository.ShowRepository;
import com.example.bookMyShow.Repository.TicketRepository;
import com.example.bookMyShow.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private JavaMailSender emailSender;

    public TicketResponseDto bookTicket(TicketRequestDto ticketRequestDto)throws NoUserFound, ShowNotFound,Exception {

        //User validation
        int userId = ticketRequestDto.getUserId();
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new NoUserFound("User Id is incorrect");
        }

        //Show Validation
        int showId = ticketRequestDto.getShowId();
        Optional<Show> showOptional = showRepository.findById(showId);
        if(!showOptional.isPresent()){
            throw new ShowNotFound("Show is not found");
        }
        Show show = showOptional.get();

        boolean isValid = validateShowAvailability(show,ticketRequestDto.getRequestedSeats());

        if(isValid==false){
            throw new Exception("Requested Seats entered are not available");
        }

        Ticket ticket = new Ticket();
        //calculate the total price

        int totalPrice = calculateTotalPrice(show,ticketRequestDto.getRequestedSeats());

        ticket.setTotalPrice(totalPrice);

        //Convert the list of booked seats into string from list
        String bookedSeats = convertListToString(ticketRequestDto.getRequestedSeats());

        ticket.setBookedSeats(bookedSeats);
        //Do bidirectional mapping

        User user = userOptional.get();

        ticket.setUser(user);
        ticket.setShow(show);

        ticket = ticketRepository.save(ticket);

        user.getTicketList().add(ticket);
        //Saving the relevant repositories

        userRepository.save(user);

        show.getTicketList().add(ticket);

        showRepository.save(show);


        //We can send a mail to the person
        SimpleMailMessage simpleMessageMail = new SimpleMailMessage();

        String body = "Hi "+user.getName()+" ! \n"+
                "You have successfully booked a ticket. Please find the following details \n"+
                "booked seat No's" + bookedSeats+"\n"
                +"movie Name" + show.getMovie().getMovieName()+"\n"
                +"show Date is "+show.getDate()+"/n"+
                "And show time is "+show.getTime()+"\n"+
                "Enjoy the Show !!!";

        simpleMessageMail.setSubject("Ticket Confirmation Mail");
        simpleMessageMail.setFrom("chauhan165699@gmail.com");
        simpleMessageMail.setText(body);
        simpleMessageMail.setTo(user.getEmail());

        emailSender.send(simpleMessageMail);


        return createTicketReponseDto(show,ticket);
    }

    private boolean validateShowAvailability(Show show, List<String> requestedSeats){

        List<ShowSeat> showSeatList = show.getShowSeatList();

        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<requestedSeats.size();i++){
            System.out.println(requestedSeats.get(i));
            map.put(requestedSeats.get(i),i);
        }
        for(ShowSeat showSeat : showSeatList){
            System.out.println(showSeat.getSeatNo()+"  "+ showSeat.getPrice());
            String seatNo = showSeat.getSeatNo();
            if(map.containsKey(seatNo)){
                System.out.println("hello");
                if(showSeat.getAvailable()==false)
                    return false;
            }
        }
        return true;

    }

    private int calculateTotalPrice(Show show, List<String> requestedSeats){

        int totalPrice = 0;

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(ShowSeat showSeat : showSeatList){

            if(requestedSeats.contains(showSeat.getSeatNo())){
                System.out.println(showSeat.getSeatNo()+"hello");
                totalPrice = totalPrice + showSeat.getPrice();
                showSeat.setAvailable(false);
            }
        }

        return totalPrice;
    }

    String convertListToString(List<String> seats){

        String result = "";
        for(String seatNo : seats){
            result = result + seatNo+", ";
        }
        return result;
    }

    private TicketResponseDto createTicketReponseDto(Show show, Ticket ticket){

        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .bookedSeats(ticket.getBookedSeats())
                .location(show.getTheater().getLocation())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .showDate(show.getDate())
                .showTime(show.getTime())
                .totalPrice(ticket.getTotalPrice())
                .build();

        return ticketResponseDto;
    }
}