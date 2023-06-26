package com.example.bookMyShow.Service;

import com.example.bookMyShow.Dtos.RequestDto.AddUserDto;
import com.example.bookMyShow.Dtos.ResponseDto.UserResponseDto;
import com.example.bookMyShow.Modals.User;
import com.example.bookMyShow.Repository.UserRepository;
import com.example.bookMyShow.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public  List<User> findUsersGreaterThanAge(Integer age) {
           List<User> userList=userRepository.findAllUsersGreaterThanAge(age);
           return  userList;
    }

    public String addUser(AddUserDto addUserDto) {
        User user= UserTransformer.convertDtoToEntity(addUserDto);
        userRepository.save(user);
        return  "User has been added ";
    }

    public UserResponseDto getOlderUser() {
        List<User> userList=userRepository.findAll();
        int age=0;
        User olderUser=null;
        for(User user:userList){
            if(user.getAge()>age){
                age=user.getAge();
                olderUser=user;
            }
        }
      UserResponseDto userResponseDto=UserTransformer.convertEntityToDto(olderUser);
        return userResponseDto;
    }
}
