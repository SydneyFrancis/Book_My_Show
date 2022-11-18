package com.example.project.project_book_my_show.Service.Implementation;

import com.example.project.project_book_my_show.Converter.UserConverter;
import com.example.project.project_book_my_show.Dto.EntryDto.UserEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.UserResponseDto;
import com.example.project.project_book_my_show.Model.UserEntity;
import com.example.project.project_book_my_show.Repository.UserRepository;
import com.example.project.project_book_my_show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public void addUser(UserEntryDto user) {
        UserEntity userEntity = UserConverter.convertDtoToEntity(user);
        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int Id) {
        UserEntity userEntity = userRepository.findById(Id).get();
        UserResponseDto userDto = UserConverter.convertEntityToDto(userEntity);
        return userDto;
    }
}
