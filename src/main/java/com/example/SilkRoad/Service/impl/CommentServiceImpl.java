package com.example.SilkRoad.Service.impl;

import com.example.SilkRoad.Model.Comment;
import com.example.SilkRoad.Model.Post;
import com.example.SilkRoad.Repository.CommentRepository;
import com.example.SilkRoad.Repository.PostRepository;
import com.example.SilkRoad.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findCommentsByPostId(int postId) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isPresent()) {
            // Nếu muốn sử dụng một phương thức có sẵn trong repository
            // thì bạn có thể sử dụng commentRepository.findByPost(post.get());
            return commentRepository.findByPost(post.get());
        } else {
            // Xử lý trường hợp khi bài đăng không tồn tại
            throw new IllegalArgumentException("Post not found");
        }
    }

    @Override
    public Comment findCommentById(int id) {
        return commentRepository.findById(id).orElse(null);
    }
}
