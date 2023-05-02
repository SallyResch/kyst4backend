package com.sillysally.kyst4backend.controller;

import com.sillysally.kyst4backend.service.UserService;
import com.sillysally.kyst4backend.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody UserModel user){
        userService.saveUserModel(user);
        return "New user is added";
    }

    @GetMapping("/getAll")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }
}
