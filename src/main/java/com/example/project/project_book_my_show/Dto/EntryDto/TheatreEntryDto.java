package com.example.project.project_book_my_show.Dto.EntryDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreEntryDto {
    private String name;

    private String address;

    private String city;
}
