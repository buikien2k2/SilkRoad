package com.example.SilkRoad.Service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SilkRoad.Model.FriendShip;
import com.example.SilkRoad.Model.User;
import com.example.SilkRoad.Repository.FriendshipRepository;
import com.example.SilkRoad.Repository.UserRepository;
import com.example.SilkRoad.Service.FriendShipServiceInterface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FriendShipService implements FriendShipServiceInterface {
    private final FriendshipRepository friendshipRepository;
    private final UserRepository userRepository;

    public List<User> getFriendsById(int userid) {
        User user = userRepository.findById(userid).get();
        List<FriendShip> friendships = friendshipRepository.findByUser1OrUser2AndFriendshipStatus(user, 1);
        List<User> friends = new ArrayList<>();
        for (FriendShip friendship : friendships) {
            friends.add(friendship.getOtherUser(user));
        }
        return friends;
    }

    public FriendShip getFriendShipBy2Userid(int user1Id, int user2Id) {
        User user1 = userRepository.findById(user1Id).orElse(null);
        User user2 = userRepository.findById(user2Id).orElse(null);
        Optional<FriendShip> friendship = friendshipRepository.findByUserIds(user1, user2);
        if (friendship.isEmpty()) {
            return null;
        }
        return friendship.get();
    }

    public List<User> getUserByUser1AndFriendshipStatus(int userid, int friendshipStatus) {
        User user = userRepository.findById(userid).get();
        List<FriendShip> friendships = friendshipRepository.findByUser1AndFriendshipStatus(user, friendshipStatus);

        List<User> friends = new ArrayList<>();
        for (FriendShip friendship : friendships) {
            friends.add(friendship.getOtherUser(user));
        }
        return friends;
    }

    public List<User> getUserByUser2AndFriendshipStatus(int userid, int friendshipStatus) {
        User user = userRepository.findById(userid).get();
        List<FriendShip> friendships = friendshipRepository.findByUser2AndFriendshipStatus(user, friendshipStatus);

        List<User> friends = new ArrayList<>();
        for (FriendShip friendship : friendships) {
            friends.add(friendship.getOtherUser(user));
        }
        return friends;
    }

    public void requestFriend(int requestId, int user2Id) {
        User user1 = userRepository.findById(requestId).orElse(null);
        User user2 = userRepository.findById(user2Id).orElse(null);
        Optional<FriendShip> friendship = friendshipRepository.findByUser1AndUser2(user1, user2);
        if (user1 == null || user2 == null) {
            throw new RuntimeException("Make friend error!");
        }

        // empty => add
        if (friendship.isEmpty()) {
            FriendShip newFriendShip = new FriendShip();
            newFriendShip.setFriendshipStatus(0);
            newFriendShip.setUser1(user1);
            newFriendShip.setUser2(user2);
            newFriendShip.setRequestTime(new Date());

            friendshipRepository.save(newFriendShip);
        }
        return;
    }

    public void removeFriendship(int user1Id, int user2Id) {
        User user1 = userRepository.findById(user1Id).orElse(null);
        User user2 = userRepository.findById(user2Id).orElse(null);
        Optional<FriendShip> friendship = friendshipRepository.findByUserIds(user1, user2);
        if (user1 == null || user2 == null) {
            throw new RuntimeException("Remove friend error! Wrong id!");
        }

        // empty => add
        if (friendship.isEmpty()) {
            return;
        } else {
            // pending => delete
            // friended => unfriend
            friendshipRepository.delete(friendship.get());
        }
        return;
    }

    public void acceptFriend(int user1Id, int acceptId) {
        User user1 = userRepository.findById(user1Id).orElse(null);
        User user2 = userRepository.findById(acceptId).orElse(null);
        Optional<FriendShip> friendship = friendshipRepository.findByUser1AndUser2(user1, user2);
        if (friendship.isEmpty()) {
            throw new IllegalArgumentException("Accept friend error!");
        }
        friendship.get().setFriendshipStatus(1);
        friendshipRepository.save(friendship.get());
    }
}
