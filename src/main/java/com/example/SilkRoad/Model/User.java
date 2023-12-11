package com.example.SilkRoad.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar_name")
    @Nullable
    private String avatarName;

    @Column(name = "coverImg")
    @Nullable
    private String coverImg;

    @Column(name = "Phone")
    @Nullable
    private String phone;

    @Nullable
    @Column(name = "Bio")
    private String bio;

    @Column(name = "Birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @Column(name = "Gender")
    private int gender; // 0: male, 1: female

    // security require
    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    // Set: các roles không trùng lặp
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinTable(name = "userdetail", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private Userdetail userdetail;

    // @OneToMany
    // @JoinTable(name = "friendship", joinColumns = @JoinColumn(name =
    // "subscriber_id", referencedColumnName = "id"))
    // private List<FriendShip> friendShips;
}
