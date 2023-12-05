package com.example.signinsignup.Service;

import com.example.signinsignup.Model.Role;
import com.example.signinsignup.Model.User;
import com.example.signinsignup.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {
//    private final MailSender mailSender;
    private final UserRepository userRepository;


    public void saveUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }
    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public boolean addUser(User user){
        User userByEmail = userRepository.findUserByEmail(user.getEmail());

        if (userByEmail != null){
            return false;
        }

        user.setRole(Role.USER);
        user.setEnabled(true);

        userRepository.save(user);

        return true;
    }
}
