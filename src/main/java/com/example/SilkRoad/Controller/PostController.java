/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SilkRoad.Controller;

import lombok.RequiredArgsConstructor;

import com.example.SilkRoad.Model.Post;
import com.example.SilkRoad.Repository.PostRepository;
import com.example.SilkRoad.Service.PostService;
import com.example.SilkRoad.Service.UserServiceInterface;
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
import javax.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Acer
 */
@Controller
@RequestMapping("/home") // Thêm đường dẫn cơ sở cho PostController
public class PostController {

    @Autowired
    private UserServiceInterface userService;
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @GetMapping("/home") // Đường dẫn cuối cùng là "/posts/home"
    public String index(@AuthenticationPrincipal UserDetails user, Model model) {
        List<Post> posts = (List<Post>) postRepository.findAll();
        System.out.println(posts);
        // Sort posts by creation time in descending order, handling null values
        posts.sort(Comparator.comparing(post -> post.getCreateTime(), Comparator.nullsLast(Comparator.reverseOrder())));

        model.addAttribute("posts", posts);
        model.addAttribute("post", new Post());
        return "index";
    }

    @PostMapping("/home/save")
public String savePost(@AuthenticationPrincipal UserDetails user, @ModelAttribute("post") Post post,
                       @RequestParam("image") MultipartFile image) throws IOException {
    if (!image.isEmpty()) {
        post.setPostImage(image.getBytes());
    }

    // Set the creation time to the current time
    post.setCreateTime(LocalDateTime.now());

    // Kiểm tra quyền của người dùng
    if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
        postService.savePost(post);
    } else {
        // Xử lý khi người dùng không có quyền
        return "error"; // hoặc chuyển hướng đến trang lỗi nếu cần
    }

    // Sử dụng đường dẫn tương đối trong trường hợp này
    return "redirect:/home";


    }
}
