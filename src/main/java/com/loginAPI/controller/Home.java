package com.loginAPI.controller;

import com.loginAPI.model.JwtRequest;
import com.loginAPI.model.User;
import com.loginAPI.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin (origins = "*")
public class Home {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/welcome")
    public String welcome(){
        return "This is private page!";
    }

    @GetMapping("/user")
    public String user(Principal principal){
        String name = principal.getName();
        //User user = new User();
        //JwtRequest jwtRequest = new JwtRequest();
        //user.setUsername(jwtRequest.getUsername());
        //return "{\"username\":\"Arif\"}";
        return "{\"username\":\""+name+"\"}";
    }

    /*@GetMapping("/dashboard")
    public String getUser(Principal principal){
        String username = principal.getName();
        User user = userRepo.getUserbyUserName(username);
        System.out.println(user.getUsername());
        return "{\"username\":\""+user.getUsername()+"\"}";

        //return "redirect:/dashboard";
    }*/

}
