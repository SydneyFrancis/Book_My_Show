package com.example.project.project_book_my_show.Converter;

import com.example.project.project_book_my_show.Dto.EntryDto.UserEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.UserResponseDto;
import com.example.project.project_book_my_show.Model.UserEntity;

public class UserConverter {

    public static UserEntity convertDtoToEntity(UserEntryDto userDto){
        return UserEntity.builder().name(userDto.getName()).mobileNumber(userDto.getMobileNo()).build();
    }

    public static UserResponseDto convertEntityToDto(UserEntity user){
        return UserResponseDto.builder().ID(user.getID()).name(user.getName()).mobileNo(user.getMobileNumber()).build();
    }
}
