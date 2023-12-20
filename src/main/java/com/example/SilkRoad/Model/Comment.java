/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SilkRoad.Model;

import java.time.Duration;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Base64;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "comment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    
    @ManyToOne
    @Nullable
    @JoinColumn(name = "user_id")
    private User user;
    
    @Lob
    @Column(name = "comment_img", columnDefinition = "LONGBLOB")
    @Nullable
    private byte[] commentImg;
    
    @ManyToOne
    @Nullable
    @JoinColumn(name = "replyID", referencedColumnName = "id")
    private Comment comment_id;
    
    public String getBase64Image() {
        if (commentImg != null && commentImg.length > 0) {
            return Base64.getEncoder().encodeToString(commentImg);
        }
        return null;
    }

    public LocalDateTime getCreateTime() {
        return timestamp;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.timestamp = createTime;
    }

    public long getElapsedTimeInMinutes() {
        if (timestamp != null) {
            return Duration.between(timestamp, LocalDateTime.now()).toMinutes();
        }
        return 0;
    }

}
