package com.example.bookMyShow.Controller;

import com.example.bookMyShow.Dtos.RequestDto.AddUserDto;
import com.example.bookMyShow.Dtos.ResponseDto.UserResponseDto;
import com.example.bookMyShow.Modals.User;
import com.example.bookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody AddUserDto addUserDto){
        String add=userService.addUser(addUserDto);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }
    @GetMapping("/olderUser")
    public UserResponseDto getOlderUser(){
           try{
               UserResponseDto olserUser=userService.getOlderUser();
               olserUser.setStatusCode("200");
               olserUser.setStatusMessage("Success");
               return  olserUser;
           }
           catch (Exception e){
               UserResponseDto responseDto=new UserResponseDto();
               responseDto.setStatusMessage("Failure");
               responseDto.setStatusCode("500");
               return responseDto;
           }
    }
    @GetMapping("/findUsersGreaterThanAge")
    public List<User> findUsersGreaterThanAge(@RequestParam ("age") Integer age){
        List<User> userList=userService.findUsersGreaterThanAge(age);
        return  userList;
    }
}
