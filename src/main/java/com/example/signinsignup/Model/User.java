package com.example.signinsignup.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users", schema = "SildRoadDB")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String password;

    @Transient
    private String rpassword;
    @Transient
    private int day;
    @Transient
    private int month;
    @Transient
    private int year;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "avatar_name")
    private String avatarName;

    @Column(name = "coverImg")
    private String coverImg;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Bio")
    private String bio;
    @Column(name = "Birth")
    private Date birth;
    @Column(name = "Gender")
    private int gender;


}
