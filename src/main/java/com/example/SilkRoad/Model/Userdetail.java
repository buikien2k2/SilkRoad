package com.example.SilkRoad.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "userdetail")
public class Userdetail {
    @Id
    @JoinColumn(name = "id")
    private int id;

    // @OneToOne
    // @JoinTable(name = "users", joinColumns = @JoinColumn(name = "id",
    // referencedColumnName = "UserID"))
    // private User user;

    @JoinColumn(name = "WorkAt")
    private String WorkAt;

    @JoinColumn(name = "LiveAt")
    private String LiveAt;

    @JoinColumn(name = "School")
    private String School;

    @JoinColumn(name = "Relation")
    private int Relation; // 0: single, 1:...

}
