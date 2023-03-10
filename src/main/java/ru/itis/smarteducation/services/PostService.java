package ru.itis.smarteducation.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.smarteducation.controllers.dto.PostCreateDto;
import ru.itis.smarteducation.models.Post;

public interface PostService {
    Post createNewPost(PostCreateDto postCreateDto) throws JsonProcessingException;
}
