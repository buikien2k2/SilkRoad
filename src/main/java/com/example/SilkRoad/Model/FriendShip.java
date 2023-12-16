package com.example.SilkRoad.Model;

import java.util.Date;

import javax.persistence.Column;
// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "friendship")
public class FriendShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int FriendshipID;

    @OneToOne
    @JoinColumn(name = "subscriber_id")
    private User user1;
    // @Column(name = "UserID")
    // private Long UserID1;

    @OneToOne
    @JoinColumn(name = "accept_id")
    private User user2;
    // @Column(name = "UserID")
    // private Long UserID2;

    // private int user1Id;

    // private int user2Id;

    @Column(name = "status")
    private int FriendshipStatus; // 1: friended, 0: pending

    @Column(name = "RequestTime")
    private Date RequestTime;

    public User getOtherUser(User user) {
        if (this.user1.equals(user)) {
            return this.user2;
        } else {
            return this.user1;
        }
    }
}
