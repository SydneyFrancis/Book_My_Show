package com.example.project.project_book_my_show.Service;

import com.example.project.project_book_my_show.Dto.EntryDto.UserEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.UserResponseDto;

public interface UserService {

    void addUser(UserEntryDto user);

    UserResponseDto getUser(int Id);
}
