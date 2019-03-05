package com.arinc.myjobapp.Controller;

import com.arinc.myjobapp.User.User;
import com.arinc.myjobapp.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String username=auth.getName();
        User user= userRepository.getUserByUserName(username);
        model.addAttribute("fullName",user.getFullName());
        return "index";
    }

}
