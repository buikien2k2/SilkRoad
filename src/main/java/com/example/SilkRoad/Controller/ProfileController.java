package com.example.SilkRoad.Controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.SilkRoad.Model.FriendShip;
import com.example.SilkRoad.Model.User;
import com.example.SilkRoad.Model.Userdetail;
import com.example.SilkRoad.Service.FriendShipServiceInterface;
import com.example.SilkRoad.Service.UserServiceInterface;
import com.example.SilkRoad.Service.UserdetailServiceInterface;
import com.example.SilkRoad.requestDTO.EditProfileDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProfileController {
    @Autowired
    private UserServiceInterface usersService;
    @Autowired
    private UserdetailServiceInterface userdetailService;
    @Autowired
    private FriendShipServiceInterface friendShipService;

    // private final ResourceLoader resourceLoader;
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @GetMapping("/profile/{userid}")
    public String Profile(@PathVariable("userid") int userid, Model model,
            @AuthenticationPrincipal UserDetails userDetailsLoggedIn) {
        if (userDetailsLoggedIn == null) {
            return "redirect:/login";
        }
        User userLoggedIn = usersService.getUserByEmail(userDetailsLoggedIn.getUsername());
        User user = usersService.GetOneUserById(userid);
        Userdetail userdetail = userdetailService.GetOneUserById(userid);
        List<User> friends = friendShipService.getFriendsById(userid);

        if (userLoggedIn.getId() != userid) {
            FriendShip friendShip = friendShipService.getFriendShipBy2Userid(userLoggedIn.getId(), userid);
            model.addAttribute("friendship", friendShip);
        } else {
            List<User> friendsWaiting = friendShipService.getUserByUser1AndFriendshipStatus(userLoggedIn.getId(),
                    0);

            List<User> friendsWaitingSelf = friendShipService.getUserByUser2AndFriendshipStatus(userLoggedIn.getId(),
                    0);

            model.addAttribute("friendsWaiting", friendsWaiting);
            model.addAttribute("friendsWaitingSelf", friendsWaitingSelf);
        }

        model.addAttribute("userLoggedIn", userLoggedIn);
        model.addAttribute("user", user);
        model.addAttribute("userdetail", userdetail);
        model.addAttribute("friends", friends);
        return "profile";
    }

    @PostMapping("/profile/{userid}/edit")
    public String EditUser(@PathVariable("userid") int userid, @Valid @ModelAttribute EditProfileDTO editProfileDTO,
            BindingResult result, Model model) {
        // System.out.println(result + " [user]");
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error));
            return "redirect:/profile/" + userid;
        }

        User user = usersService.GetOneUserById(userid);
        user.setName(editProfileDTO.getName());
        user.setPhone(editProfileDTO.getPhone());
        user.setGender(editProfileDTO.getGender());
        // user.setBirth(java.sql.Date.valueOf(editProfileDTO.getBirth()));
        user.setBirth(editProfileDTO.getBirth());

        usersService.UpdateUser(user);
        return "redirect:/profile/" + userid;
    }

    @PostMapping("/profile/{userid}/editDetail")
    public String EditUserDetail(@PathVariable("userid") int userid,
            @Valid @ModelAttribute("userdetail") Userdetail userdetail,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/profile/" + userid;
        }
        userdetail.setId(userid);
        userdetailService.UpdateUserdetail(userdetail);
        return "redirect:/profile/" + userid;
    }

    @PostMapping("/profile/uploadAvatarImg/{userid}")
    public String handleFileUploadAvatarImg(@RequestParam("file") MultipartFile file,
            @PathVariable("userid") int userid,
            Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "redirect:/profile/" + userid;
        }

        // check host account

        try {
            byte[] bytes = file.getBytes();
            String imagePath = saveImage(bytes, "avatar", file.getOriginalFilename());
            User user = usersService.GetOneUserById(userid);

            user.setAvatarName(imagePath);
            usersService.UpdateUser(user);

            model.addAttribute("message", "Avatar uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Avatar upload failed");
        }

        return "redirect:/profile/" + userid;
    }

    @PostMapping("/profile/uploadCoverImg/{userid}")
    public String handleFileUploadCoverImg(@RequestParam("file") MultipartFile file,
            @PathVariable("userid") int userid,
            Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "redirect:/profile/" + userid;
        }

        // check host account

        try {
            byte[] bytes = file.getBytes();
            String imagePath = saveImage(bytes, "profileCover", file.getOriginalFilename());
            User user = usersService.GetOneUserById(userid);

            user.setCoverImg(imagePath);
            usersService.UpdateUser(user);

            model.addAttribute("message", "Cover uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Cover upload failed");
        }

        return "redirect:/profile/" + userid;
    }

    private String saveImage(byte[] bytes, String imgFolderName, String originalFilename) throws IOException {
        Path staticPath = Paths.get("src", "main", "resources", "static");
        Path imagePath = Paths.get("img");
        Path imageFolder = Paths.get(imgFolderName);

        // Kiểm tra và tạo thư mục cha
        Path folderPath = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(imageFolder);
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        // Kiểm tra và tạo thư mục con
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        // Tạo đường dẫn và ghi dữ liệu vào file
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        long currentTime = System.currentTimeMillis();
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(imageFolder).resolve(currentTime + "." + fileExtension);

        String downloadPath = "/img/" + imgFolderName + "/" + currentTime + "." + fileExtension;

        Files.write(file, bytes);
        return downloadPath;
    }

}
