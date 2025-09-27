package com.example.account.Account.view.controller;


import com.example.account.Account.services.UserServices;
import com.example.account.Account.view.dto.UserCreateDto;
import com.example.account.Account.view.dto.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateDto userCreatedDto){
        return new ResponseEntity<>(userServices.createUser(userCreatedDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return new ResponseEntity<>(userServices.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable UUID id){
        return new ResponseEntity<>(userServices.getUserById(id), HttpStatus.OK);
    }
}
