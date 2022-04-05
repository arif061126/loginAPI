package com.loginAPI.services;

import com.loginAPI.model.CustomUserDetails;
import com.loginAPI.model.User;
import com.loginAPI.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("User not found!");
        }else {
            return new CustomUserDetails(user);
        }


        /*if(username.equals("Arif")){
            return new User("Arif","1234", new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found!");
        }*/
    }
}
