package com.sillysally.kyst4backend.controller;

import com.sillysally.kyst4backend.service.UserModelService;
import com.sillysally.kyst4backend.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserModelService userModelService;

    @PostMapping("/save")
    public String saveUser(@RequestBody UserModel user){
        userModelService.saveUser(user);
        return "New user is added";
    }

    @GetMapping("/getAll")
    public List<UserModel> getAllUsers(){
        return userModelService.getAllUsers();
    }
}
