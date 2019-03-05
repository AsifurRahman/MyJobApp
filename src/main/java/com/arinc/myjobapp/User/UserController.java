package com.arinc.myjobapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerSave(User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/userList")
    public String userList(Model model) {
        List<User> userList=userService.userList();
        model.addAttribute("userList",userList);
        return "userList";
    }
}
