package com.example.controller;

import com.example.model.Post;
import com.example.repository.PostRepository;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = (List<Post>) postRepository.findAll();

        // Sort posts by creation time in descending order, handling null values
        posts.sort(Comparator.comparing(post -> post.getCreateTime(), Comparator.nullsLast(Comparator.reverseOrder())));

        model.addAttribute("posts", posts);
        model.addAttribute("post", new Post());
        return "index";
    }


    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post,
                           @RequestParam("image") MultipartFile image,
                           @RequestParam("video") MultipartFile video) throws IOException {
        if (!image.isEmpty()) {
            post.setPostImage(image.getBytes());
        }

        if (!video.isEmpty()) {
            post.setPostVideo(video.getBytes());
        }

        // Set the creation time to the current time
        post.setCreateTime(LocalDateTime.now());

        postService.savePost(post);
        return "redirect:/";
    }
}