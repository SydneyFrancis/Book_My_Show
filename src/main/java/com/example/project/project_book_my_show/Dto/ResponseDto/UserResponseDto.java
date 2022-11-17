package com.example.project.project_book_my_show.Dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    int ID;
    String name;
    String mobileNo;
}
