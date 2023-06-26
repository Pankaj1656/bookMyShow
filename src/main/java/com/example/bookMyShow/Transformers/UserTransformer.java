package com.example.bookMyShow.Transformers;

import com.example.bookMyShow.Dtos.RequestDto.AddUserDto;
import com.example.bookMyShow.Dtos.ResponseDto.UserResponseDto;
import com.example.bookMyShow.Modals.User;

public class UserTransformer {
    public static User convertDtoToEntity(AddUserDto addUserDto){
        User user= User.builder().age(addUserDto.getAge())
                .name(addUserDto.getName())
                .email(addUserDto.getEmailId())
                .mobNo(addUserDto.getMobileNo())
                .build();
        return  user;
    }
    public static UserResponseDto convertEntityToDto(User user){
        UserResponseDto userResponseDto= UserResponseDto.builder()
                .name(user.getName()).age(user.getAge())
                .mobNo(user.getMobNo())
                .build();

        return userResponseDto;
    }
}
