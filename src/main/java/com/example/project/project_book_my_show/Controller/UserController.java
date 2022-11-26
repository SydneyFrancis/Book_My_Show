package com.example.project.project_book_my_show.Controller;

import com.example.project.project_book_my_show.Dto.EntryDto.UserEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.UserResponseDto;
import com.example.project.project_book_my_show.Service.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){
        userService.addUser(userEntryDto);
        return new ResponseEntity<>("User added", HttpStatus.ACCEPTED);
    }


    @GetMapping("/getUser")
    public ResponseEntity<UserResponseDto> getUser(@RequestParam("id")int ID){
        return new ResponseEntity<>(userService.getUser(ID),HttpStatus.FOUND);
    }
}
