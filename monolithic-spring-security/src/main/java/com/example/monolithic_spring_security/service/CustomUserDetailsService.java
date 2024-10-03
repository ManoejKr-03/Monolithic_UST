package com.example.monolithic_spring_security.service;

 
import java.util.Optional;

import com.example.monolithic_spring_security.dao.AuthUserDao;
import com.example.monolithic_spring_security.entity.AuthUser;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    
    @Autowired
    AuthUserDao authUserDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AuthUser> userInfoEntity = authUserDao.findByauthUsername(username);
        

        // but we have return UserDetails and not UserInfoEntity

        //copy the authuser details to userDetails( needed)
        System.out.println(userInfoEntity.get().getAuthUsername()+"------"+ userInfoEntity.get().getAuthPassword()+"---------"+userInfoEntity.get().getAllRoles());
        return userInfoEntity
        .map((userInfo)->new CustomUserDetails(userInfo.getAuthUsername(), userInfo.getAuthPassword(), userInfo.getAllRoles()))
        .orElseThrow(()-> new UsernameNotFoundException(username + " not found"));

        
        
        
    }

     
    
}


