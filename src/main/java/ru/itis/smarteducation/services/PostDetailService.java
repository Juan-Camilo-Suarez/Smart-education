package ru.itis.smarteducation.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.smarteducation.controllers.dto.PostCreateDto;
import ru.itis.smarteducation.models.Post;
import ru.itis.smarteducation.repositories.PostRepository;

import java.util.List;

@Service
public class PostDetailService implements PostService {

    //эта аннотация используется для автоматического внедрения зависимости в класс
    @Autowired
    PostRepository postRepository;

    public Post post = new Post();

    @Override
    public Post createNewPost(PostCreateDto postCreateDto) throws JsonProcessingException {
        post.setTitle(postCreateDto.getTitle());
        post.setDescription(postCreateDto.getDescription());
        post.setImage(postCreateDto.getImage());
        postRepository.save(post);
        return post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Post> ListAllPosts() {
        return postRepository.findAll();
    }
}
