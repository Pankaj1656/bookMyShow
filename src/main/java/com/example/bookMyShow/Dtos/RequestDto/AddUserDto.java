package com.example.bookMyShow.Dtos.RequestDto;

import lombok.Data;

@Data
public class AddUserDto {
    private String name;

    private Integer age;

    private String  mobileNo;

    private String emailId;
}
