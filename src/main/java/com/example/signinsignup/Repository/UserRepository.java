package com.example.signinsignup.Repository;

import com.example.signinsignup.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByName(String name);
    public User findUserByEmail(String email);
    public Optional<User> findUserById(int id);
}
