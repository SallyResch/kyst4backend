package com.sillysally.kyst4backend.service;
import com.sillysally.kyst4backend.models.UserModel;
import com.sillysally.kyst4backend.repository.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserModelService{
    public UserModel saveUser(UserModel user);
    public List <UserModel> getAllUsers();

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
