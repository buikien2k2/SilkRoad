package com.example.SilkRoad.Service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.SilkRoad.Model.Role;
import com.example.SilkRoad.Model.User;
import com.example.SilkRoad.Repository.RoleRepository;
import com.example.SilkRoad.Repository.UserRepository;
import com.example.SilkRoad.Service.UserServiceInterface;
import com.example.SilkRoad.requestDTO.RegisterUserDTO;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    // register
    @Override
    public void registerAccount(RegisterUserDTO user) {

        // validate data from client
        validateAccount(user);

        User newuser = addUser(user);

        try {
            userRepository.save(newuser);
        } catch (Exception e) {
            throw new RuntimeException("Error when register user");
        }
    }

    public User addUser(RegisterUserDTO userDTO) {
        User newuser = new User();

        newuser.setName(userDTO.getName());
        newuser.setEmail(userDTO.getEmail());
        newuser.setGender(Integer.parseInt(userDTO.getGender()));
        newuser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        // date
        int day = userDTO.getDay();
        int month = userDTO.getMonth();
        int year = userDTO.getYear();
        LocalDate date = LocalDate.of(year, month, day);
        if (!date.isBefore(LocalDate.now())) {
            throw new RuntimeException("Invalid Date of Birth");
        }
        newuser.setBirth(java.sql.Date.valueOf(date));

        // role
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName(userDTO.getRole()));
        newuser.setRoles(roles);

        // others
        newuser.setAvatarName("");
        newuser.setBio("");
        newuser.setCoverImg("");

        // uwe
        newuser.setEnabled(true);
        newuser.setAccountNonExpired(true);
        newuser.setAccountNonLocked(true);
        newuser.setCredentialsNonExpired(true);

        return newuser;
    }

    private void validateAccount(RegisterUserDTO user) {
        if (ObjectUtils.isEmpty(user)) {
            throw new IllegalArgumentException("Request data not found!");
        }

        try {
            if (!ObjectUtils.isEmpty(user.checkProperties())) {
                throw new RuntimeException(
                        "Request data not found!");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Service Unavailable");
        }

        List<String> roles = roleRepository.findAll().stream().map(Role::getName).toList();

        if (!roles.contains(user.getRole())) {
            throw new IllegalArgumentException("Invalid roles");
        }

        User userExisted = userRepository.findUserByEmail(user.getEmail());

        if (!ObjectUtils.isEmpty(userExisted)) {
            throw new RuntimeException("User had existed!!!");
        }

    }
}
