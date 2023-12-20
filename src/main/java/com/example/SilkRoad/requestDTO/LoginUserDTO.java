package com.example.SilkRoad.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDTO {
    private String email;

    private String password;

    public String checkProperties() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields()) {
            if (f.get(this) == null) {
                String[] arr = f.toString().split("\\.");
                String t = arr[arr.length - 1];
                if (t.equalsIgnoreCase("email")
                        || t.equalsIgnoreCase("password")) {
                    return t;
                }
            }
        }
        return null;
    }

}
