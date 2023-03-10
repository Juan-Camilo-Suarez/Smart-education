package ru.itis.smarteducation.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.smarteducation.controllers.dto.PostCreateDto;
import ru.itis.smarteducation.models.Post;
import ru.itis.smarteducation.services.PostDetailService;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostDetailService postDetailService;

    @GetMapping("/")
    public String listOfPost(Model model) {
        PostCreateDto postDto = new PostCreateDto();
        List<Post> posts = postDetailService.ListAllPosts();
        model.addAttribute("post", posts);
        return "index";
    }
    @PostMapping("/createpost")
    public ModelAndView CreatePostForm(@ModelAttribute("post") @Valid PostCreateDto postCreateDto) throws JsonProcessingException {
        postDetailService.createNewPost(postCreateDto);

        return new ModelAndView("excelent", "post", postCreateDto);
    }
}
