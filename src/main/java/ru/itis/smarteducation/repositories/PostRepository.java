package ru.itis.smarteducation.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.smarteducation.models.Post;

import java.util.List;

public interface PostRepository  extends CrudRepository<Post, Long> {
    List<Post> findAll();
}
