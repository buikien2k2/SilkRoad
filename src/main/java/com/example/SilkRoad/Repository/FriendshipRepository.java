package com.example.SilkRoad.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SilkRoad.Model.FriendShip;
import com.example.SilkRoad.Model.User;

public interface FriendshipRepository extends JpaRepository<FriendShip, Integer> {
    @Query("SELECT f FROM FriendShip f WHERE (f.user1 = ?1 OR f.user2 = ?1) AND f.FriendshipStatus = ?2")
    List<FriendShip> findByUser1OrUser2AndFriendshipStatus(User user, int friendshipStatus);

    @Query("SELECT f FROM FriendShip f " +
            "WHERE (f.user1 = :user1 AND f.user2 = :user2)" +
            " OR (f.user1 = :user2 AND f.user2 = :user1)")
    Optional<FriendShip> findByUserIds(@Param("user1") User user1, @Param("user2") User user2);

    Optional<FriendShip> findByUser1AndUser2(User user1, User user2);
}
