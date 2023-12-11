package com.example.SilkRoad.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SilkRoad.Model.Userdetail;
import com.example.SilkRoad.Repository.UserdetailRepository;
import com.example.SilkRoad.Service.UserdetailServiceInterface;

@Service
public class UserdetailService implements UserdetailServiceInterface {
    @Autowired
    private UserdetailRepository userdetailRepo;

    public Userdetail GetOneUserById(int userid) {
        Userdetail user = userdetailRepo.findById(userid).get();
        return user;
    }

    public void UpdateUserdetail(Userdetail userdetail) {
        userdetailRepo.save(userdetail);
    }
}
