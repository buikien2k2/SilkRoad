package com.example.SilkRoad.Service;

import java.util.List;

import com.example.SilkRoad.Model.FriendShip;
import com.example.SilkRoad.Model.User;

public interface FriendShipServiceInterface {
    List<User> getFriendsById(int userid);

    FriendShip getFriendShipBy2Userid(int user1Id, int user2Id);

    void requestFriend(int requestId, int user2Id);

    void acceptFriend(int user1Id, int acceptId);

    void removeFriendship(int user1Id, int user2Id);

    List<User> getUserByUser2AndFriendshipStatus(int userid, int friendshipStatus);

    List<User> getUserByUser1AndFriendshipStatus(int userid, int friendshipStatus);
}
