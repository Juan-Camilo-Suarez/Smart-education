package ru.itis.smarteducation.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateDto {
    private String title;

    private String description;

    private String image;
}
