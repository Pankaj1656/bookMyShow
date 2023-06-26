package com.example.bookMyShow.Controller;

import com.example.bookMyShow.Dtos.RequestDto.AddShowDto;
import com.example.bookMyShow.Dtos.RequestDto.ShowSeatDto;
import com.example.bookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    @Autowired
    ShowService showService;
    @PostMapping("/addShow")
    public ResponseEntity<String > addShow(@RequestBody AddShowDto addShowDto){
        try{
            String response=showService.addShow(addShowDto);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/associate-seats")
    public ResponseEntity<String> associateSeats(@RequestBody ShowSeatDto showSeatDto){
        try{
            String  response= showService.associateSeats(showSeatDto);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch(Exception e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
