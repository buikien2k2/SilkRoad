package com.example.model;


import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Base64;

@Entity
@Table(name = "tesst")
public class Post  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "tag")
    private String tag;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Post user_id;

    @Column(name = "file_name")
    private String fileName;

    @Lob
    @Column(name = "post_image", columnDefinition = "BLOB")
    private byte[] postImage;

    private LocalDateTime createTime;

    // Getters and setters


    public Post() {
    }

    public Post( String tag, String text, Post user_id, String fileName, byte[] postImage) {

        this.tag = tag;
        this.text = text;
        this.user_id = user_id;
        this.fileName = fileName;
        this.postImage = postImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getUser_id() {
        return user_id;
    }

    public void setUser_id(Post user_id) {
        this.user_id = user_id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getPostImage() {
        return postImage;
    }

    public void setPostImage(byte[] postImage) {
        this.postImage = postImage;
    }

    public Post(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public String getBase64Image() {
        if (postImage != null && postImage.length > 0) {
            return Base64.getEncoder().encodeToString(postImage);
        }
        return null;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
        }
    public long getElapsedTimeInMinutes() {
        if (createTime != null) {
            return Duration.between(createTime, LocalDateTime.now()).toMinutes();
        }
        return 0;
    }

}