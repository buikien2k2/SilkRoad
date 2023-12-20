/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SilkRoad.Controller;

import com.example.SilkRoad.Model.Comment;
import com.example.SilkRoad.Model.Post;
import com.example.SilkRoad.Model.User;
import com.example.SilkRoad.Repository.CommentRepository;
import com.example.SilkRoad.Repository.PostRepository;
import com.example.SilkRoad.Service.CommentService;
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
import java.util.ArrayList;
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
    
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @GetMapping("/home")
    public String index(@AuthenticationPrincipal UserDetails user, Model model) {
        if (user == null) {
            return "redirect:/login";
        }

        // Lấy danh sách bài viết và sắp xếp theo thời gian tạo, xử lý null values
        List<Post> posts = (List<Post>)postRepository.findAll();
        posts.sort(Comparator.comparing(post -> post.getCreateTime(), Comparator.nullsLast(Comparator.reverseOrder())));

        User userLoggedIn = userService.getUserByEmail(user.getUsername());
        model.addAttribute("user", userLoggedIn);
        model.addAttribute("posts", posts);
        model.addAttribute("post", new Post());

        // Tạo danh sách để chứa các comment
        List<Comment> allComments = new ArrayList<>();

        // Lặp qua từng bài viết và lấy danh sách comment
        for (Post post : posts) {
            List<Comment> comments = commentService.findCommentsByPostId(post.getId());
            comments.sort(Comparator.comparing(comment -> comment.getTimestamp(), Comparator.nullsLast(Comparator.reverseOrder())));
            allComments.addAll(comments);
        }
        
        model.addAttribute("comments", allComments);
        model.addAttribute("comment", new Comment());

        return "index";
    }

    @PostMapping("/home/save/{userid}")
    public String savePost(@AuthenticationPrincipal UserDetails user, @ModelAttribute("post") SavePostDTO post,
            @RequestParam("image") MultipartFile image, @RequestParam("video") MultipartFile video, 
            @PathVariable("userid") int userid, @RequestParam("from") String fromPage)
            throws IOException {
        if (!image.isEmpty()) {
            post.setPostImage(image.getBytes());
        }
        if (!video.isEmpty()) {
            post.setPostVideo(video.getBytes());
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
//    @GetMapping("/home/post/{postId}/comments")
//    public String getComments(@PathVariable int postId, Model model) {
//        List<Comment> comments = commentService.findCommentsByPostId(postId);
//
//        // Sắp xếp comment theo thời gian tạo, xử lý null values
//        comments.sort(Comparator.comparing(comment -> comment.getTimestamp(), Comparator.nullsLast(Comparator.reverseOrder())));
//
//        model.addAttribute("postId", postId);
//        model.addAttribute("comments", comments);
//        model.addAttribute("comment", new Comment());
//
//        return "comment";
//    }

    @PostMapping("/post/save/{postId}")
    public String saveComment(@AuthenticationPrincipal UserDetails user
                              ,@PathVariable int postId,
                              @ModelAttribute("comment") Comment comment) throws IOException {

        User userLoggedIn = userService.getUserByEmail(user.getUsername());

        Post post = new Post();
        post.setId(postId);
        comment.setText(comment.getText());
        comment.setPost(post);
        comment.setUser(userLoggedIn);
        comment.setTimestamp(LocalDateTime.now());

        commentService.saveComment(comment);

        
        return "redirect:/home";
    }

    @GetMapping("/comment/delete/{commentId}")
    public String deleteComment(@AuthenticationPrincipal UserDetails user, @PathVariable int commentId) {
        User userLoggedIn = userService.getUserByEmail(user.getUsername());

        Comment comment = commentService.findCommentById(commentId);

//        if (comment != null && comment.getUser().getId().equals(userLoggedIn.getId())) {
//            commentService.deleteComment(commentId);
//        }

        // Redirect to the post's comments page or handle as needed
        return "redirect:/post/" + comment.getPost().getId() + "/comments";
    }


}
