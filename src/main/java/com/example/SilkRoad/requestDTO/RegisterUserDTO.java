package com.example.SilkRoad.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {
    private String name;

    private String email;

    @Size(min = 4, max = 16, message = "Password phải có độ dài từ 4 đến 16 ký tự")
    private String password;

    @Nullable
    private String role;

    private int day;

    private int month;

    private int year;

    private String gender;

    public String checkProperties() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields()) {
            if (f.get(this) == null) {
                String[] arr = f.toString().split("\\.");
                String t = arr[arr.length - 1];
                if (t.equalsIgnoreCase("name")
                        || t.equalsIgnoreCase("email")
                        || t.equalsIgnoreCase("role")
                        || t.equalsIgnoreCase("password")
                        || t.equalsIgnoreCase("day")
                        || t.equalsIgnoreCase("month")
                        || t.equalsIgnoreCase("year")
                        || t.equalsIgnoreCase("gender")) {
                    return t;
                }
            }
        }
        return null;
    }

}