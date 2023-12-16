/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SilkRoad.Model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Base64;
import org.springframework.lang.Nullable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "post")
public class Post  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "tag")
    private String tag;
    
    @Column(name = "text")
    private String text;
    
    @Column(name = "file_name")
    @Nullable
    private String fileName;
    
    @Lob
    @Column(name = "postImg", columnDefinition = "BLOB")
    @Nullable
    private byte[] postImage;
    
    @Lob
    @Column(name = "post_video", columnDefinition = "LONGBLOB")
    @Nullable
    private byte[] postVideo;

    
    private LocalDateTime createTime;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


   
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
    public String getBase64Video() {
        if (postVideo != null && postVideo.length > 0) {
            return Base64.getEncoder().encodeToString(postVideo);
        }
        return null;
    }

}