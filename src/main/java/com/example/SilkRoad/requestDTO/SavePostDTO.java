package com.example.SilkRoad.requestDTO;

import java.time.LocalDateTime;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePostDTO {
    private String text;
    
    @Nullable
    private byte[] postImage;

    @Nullable
    private byte[] postVideo;
}
