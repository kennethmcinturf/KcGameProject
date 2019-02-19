package com.example.kcgamesite.controllers;

import com.example.kcgamesite.models.User;
import com.example.kcgamesite.repositories.UserRepository;
import com.example.kcgamesite.repositories.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private UserRepository userDao;

    public UserController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        Long one = Long.parseLong("1");
        if(users.findOne(one) == null){
            User user = new User("World", "World@email.com", "admin");
            users.save(user);
        }
        model.addAttribute("user", new User());
        return "System/Sign-Up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/games")
    public String login(){
        return "Game/Games";
    }
}
