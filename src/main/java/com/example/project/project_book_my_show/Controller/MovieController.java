package com.example.project.project_book_my_show.Controller;

import com.example.project.project_book_my_show.Dto.EntryDto.MovieEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.MovieResponseDto;
import com.example.project.project_book_my_show.Service.Implementation.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody MovieEntryDto movieEntryDto) throws Exception {
        movieService.addMovie(movieEntryDto);
        return new ResponseEntity("Movie added", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getMovie")
    public ResponseEntity<MovieResponseDto> getMovie(@RequestParam("id") int ID){
        return new ResponseEntity<>(movieService.getMovie(ID),HttpStatus.FOUND);
    }
}
