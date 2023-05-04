package com.sillysally.kyst4backend.controller;

import com.sillysally.kyst4backend.service.UserModelService;
import com.sillysally.kyst4backend.models.UserModel;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", maxAge=3600)
@RestController
@RequestMapping("/user")
public class UserRestController {


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
