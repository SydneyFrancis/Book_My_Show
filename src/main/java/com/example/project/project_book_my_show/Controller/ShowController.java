package com.example.project.project_book_my_show.Controller;

import com.example.project.project_book_my_show.Dto.EntryDto.ShowEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.ShowResponseDto;
import com.example.project.project_book_my_show.Service.Implementation.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping(value = "/show")
public class ShowController {
    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody ShowEntryDto showEntryDto){
        showService.addShow(showEntryDto);
        return  new ResponseEntity<>("show succesfully added", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getShow")
    public  ResponseEntity<ShowResponseDto> getShow(@RequestParam("id") int ID){
        return new ResponseEntity<>(showService.getShow(ID),HttpStatus.FOUND);
    }
}
