package com.example.SilkRoad.Service;

import com.example.SilkRoad.Model.Userdetail;

public interface UserdetailServiceInterface {
    Userdetail GetOneUserById(int userid);

    void UpdateUserdetail(Userdetail userdetail);
}
