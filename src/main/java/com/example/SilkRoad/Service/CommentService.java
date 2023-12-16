/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SilkRoad.Service;

import com.example.SilkRoad.Repository.*;
import com.example.SilkRoad.Model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class CommentService {

//    private final CommentRepository CommentRepository;
//    private final PostRepository PostRepository;
//    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//
//    public void saveComment(String text, long id){
//        Post message = PostRepository.getById(id);
//
//        String timeNow = LocalDateTime.now().format(formatter);
//
//        LocalDateTime parse = LocalDateTime.parse(timeNow,formatter);
//
//        Comment comment = Comment.builder()
//                .text(text)
//                .message(message)
//                .timestamp(parse).build();
//
//        commentRepository.save(comment);
//    }
//
//    public void deleteComment(long id){
//        commentRepository.deleteById(id);
//    }
}