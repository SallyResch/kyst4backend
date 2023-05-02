package com.sillysally.kyst4backend.service;

import com.sillysally.kyst4backend.repository.UserRepository;
import com.sillysally.kyst4backend.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel saveUserModel(UserModel user) {
        return userRepository.save(user);
    }
}
