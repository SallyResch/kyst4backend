package com.sillysally.kyst4backend.service;
import com.sillysally.kyst4backend.user.UserModel;
import java.util.List;


public interface UserService {
    public UserModel saveUser(UserModel user);
    public List <UserModel> getAllUsers();

}
