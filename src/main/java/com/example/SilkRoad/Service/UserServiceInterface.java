package com.example.SilkRoad.Service;

import com.example.SilkRoad.Model.User;
import com.example.SilkRoad.requestDTO.RegisterUserDTO;

public interface UserServiceInterface {
    void registerAccount(RegisterUserDTO registerUserDTO);

    User GetOneUserById(int userid);

    User getUserByEmail(String email);

    void UpdateUser(User user);
}
