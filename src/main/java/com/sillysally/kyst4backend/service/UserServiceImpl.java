package com.sillysally.kyst4backend.service;

import com.sillysally.kyst4backend.repository.UserModelRepository;
import com.sillysally.kyst4backend.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserModelService {


    private UserModelRepository userModelRepository;

    @Autowired
    public UserServiceImpl(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return userModelRepository.save(user);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userModelRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userModelRepository.findByUsername(username);
    }
}
