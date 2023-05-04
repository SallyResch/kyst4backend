package com.sillysally.kyst4backend.service;
import com.sillysally.kyst4backend.models.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserModelService extends UserDetailsService{
    public UserModel saveUser(UserModel user);
    public List <UserModel> getAllUsers();

    UserDetails loadUserByUsername(String username);
}
