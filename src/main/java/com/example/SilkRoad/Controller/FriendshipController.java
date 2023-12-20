package com.example.SilkRoad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.SilkRoad.Model.User;
import com.example.SilkRoad.Service.FriendShipServiceInterface;
import com.example.SilkRoad.Service.UserServiceInterface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FriendshipController {
    @Autowired
    private UserServiceInterface usersService;
    @Autowired
    private FriendShipServiceInterface friendShipService;

    // FRIENDSHIP
    @GetMapping("/friendship/request/{userid}")
    public String RequestFriend(@PathVariable("userid") int userid,
            @AuthenticationPrincipal UserDetails userDetailsLoggedIn) {
        User userLoggedIn = usersService.getUserByEmail(userDetailsLoggedIn.getUsername());
        friendShipService.requestFriend(userLoggedIn.getId(), userid);
        return "redirect:/profile/" + userid;
    }

    @GetMapping("/friendship/accept/{userid}")
    public String AcceptFriend(@PathVariable("userid") int userid,
            @AuthenticationPrincipal UserDetails userDetailsLoggedIn) {
        User userLoggedIn = usersService.getUserByEmail(userDetailsLoggedIn.getUsername());
        friendShipService.acceptFriend(userid, userLoggedIn.getId());
        return "redirect:/profile/" + userid;
    }

    @GetMapping("/friendship/remove/{userid}")
    public String removeFriendship(@PathVariable("userid") int userid,
            @AuthenticationPrincipal UserDetails userDetailsLoggedIn) {
        User userLoggedIn = usersService.getUserByEmail(userDetailsLoggedIn.getUsername());
        friendShipService.removeFriendship(userid, userLoggedIn.getId());
        return "redirect:/profile/" + userid;
    }
}
