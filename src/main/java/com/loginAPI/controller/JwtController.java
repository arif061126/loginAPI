package com.loginAPI.controller;

import com.loginAPI.helper.JwtUtil;
import com.loginAPI.model.JwtRequest;
import com.loginAPI.model.JwtResponse;
import com.loginAPI.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "*")
public class JwtController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }catch (UsernameNotFoundException u){
            u.printStackTrace();
            throw new Exception("It is Username Not Found Exception");
        }catch (BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("It is a Bad Creditials");
        }

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = jwtUtil.generateToken(userDetails);

        System.out.println("JWT: "+token);

        return ResponseEntity.ok(new JwtResponse(token));

    }
}
