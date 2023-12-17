/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SilkRoad.Controller;

import com.example.SilkRoad.Model.Post;
import com.example.SilkRoad.Model.User;
import com.example.SilkRoad.Repository.PostRepository;
import com.example.SilkRoad.Service.PostService;
import com.example.SilkRoad.Service.UserServiceInterface;
import com.example.SilkRoad.requestDTO.SavePostDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Acer
 */
@Controller
public class PostController {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @GetMapping("/home") // Đường dẫn cuối cùng là "/posts/home"
    public String index(@AuthenticationPrincipal UserDetails user, Model model) {
        if (user == null) {
            return "redirect:/login";
        }
        List<Post> posts = (List<Post>) postRepository.findAll();
        User userLoggedIn = userService.getUserByEmail(user.getUsername());
        model.addAttribute("user", userLoggedIn);
        // Sort posts by creation time in descending order, handling null values
        posts.sort(Comparator.comparing(post -> post.getCreateTime(), Comparator.nullsLast(Comparator.reverseOrder())));

        model.addAttribute("posts", posts);
        model.addAttribute("post", new Post());
        return "index";
    }

    @PostMapping("/home/save/{userid}")
    public String savePost(@AuthenticationPrincipal UserDetails user, @ModelAttribute("post") SavePostDTO post,
            @RequestParam("image") MultipartFile image, @PathVariable("userid") int userid,
            @RequestParam("from") String fromPage)
            throws IOException {
        if (!image.isEmpty()) {
            post.setPostImage(image.getBytes());
        }

        User userFromParam = userService.GetOneUserById(userid);

        Post newPost = new Post();
        newPost.setCreateTime(LocalDateTime.now());

        newPost.setText(post.getText());

        if (post.getPostImage() != null) {
            newPost.setPostImage(post.getPostImage());
        }
        newPost.setTag("Something");

        if (post.getPostVideo() != null) {
            newPost.setPostVideo(post.getPostVideo());
        }

        newPost.setUser(userFromParam);
        // Kiểm tra quyền của người dùng
        if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
            postService.savePost(newPost);
        } else {
            // Xử lý khi người dùng không có quyền
            return "error"; // hoặc chuyển hướng đến trang lỗi nếu cần
        }

        return "redirect:" + fromPage;

    }

    @GetMapping("/post/delete/{postid}")
    public String deletePost(@AuthenticationPrincipal UserDetails user, @PathVariable("postid") int postid)
            throws IOException {
        User userLoggedIn = userService.getUserByEmail(user.getUsername());

        postService.deletePost(postid);

        return "redirect:/profile/" + userLoggedIn.getId();
    }
}
