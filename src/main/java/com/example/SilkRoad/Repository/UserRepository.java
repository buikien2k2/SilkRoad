package com.example.SilkRoad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SilkRoad.Model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByName(String name);

    public User findUserByEmail(String email);

    public Optional<User> findUserById(int id);
}
