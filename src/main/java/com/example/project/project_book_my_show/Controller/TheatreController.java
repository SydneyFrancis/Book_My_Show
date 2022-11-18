package com.example.project.project_book_my_show.Controller;

import com.example.project.project_book_my_show.Dto.EntryDto.TheatreEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.TheatreResponseDto;
import com.example.project.project_book_my_show.Service.Implementation.TheatreServiceImpl;
import com.example.project.project_book_my_show.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("/addTheatre")
    public ResponseEntity addTheatre(@RequestBody TheatreEntryDto theatreEntryDto){
        theatreService.addTheatre(theatreEntryDto);
        return new ResponseEntity<>("Theatre successfully added", HttpStatus.ACCEPTED);
    }

    @GetMapping("getTheatre")
    public ResponseEntity<TheatreResponseDto> getTheatre(@RequestParam int ID){
        return new ResponseEntity<>(theatreService.getTheatre(ID),HttpStatus.FOUND);
    }

}
