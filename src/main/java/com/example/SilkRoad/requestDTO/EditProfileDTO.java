package com.example.SilkRoad.requestDTO;

import java.util.Date;

// import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditProfileDTO {
    private String name;

    // @Size(min = 10, max = 11, message = "Số điện thoại hợp lệ từ 10 - 11 số")
    private String phone;
    private int gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
}
