package com.loginAPI.repository;

import com.loginAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository <User, Integer> {
    public User findByUsername(String username);

    @Query("from User u where u.username =:username")
    public User getUserbyUserName(@Param("username")  String username);

}
