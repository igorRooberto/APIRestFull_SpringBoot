package com.example.UserEndereco.Local.view.controller;

import com.example.UserEndereco.Local.entities.User;
import com.example.UserEndereco.Local.mapper.UserMapper;
import com.example.UserEndereco.Local.services.UserServices;
import com.example.UserEndereco.Local.view.dto.UserCreateDto;
import com.example.UserEndereco.Local.view.dto.UserResponseDto;
import org.mapstruct.control.MappingControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;
    private final UserMapper userMapper;

    public UserController(UserMapper userMapper, UserServices userServices) {
        this.userMapper = userMapper;
        this.userServices = userServices;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        return new ResponseEntity<>(userServices.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(userServices.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> cadastrar(@RequestBody UserCreateDto dto){
        userServices.createUser(dto);
        User user = userMapper.toEntity(dto);

        return new ResponseEntity<>(userMapper.toResponse(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> atualizar(@RequestBody UserCreateDto dto, @PathVariable Long id){
        userServices.getById(id);

        userServices.UpdateData(id, dto);
        User user = userMapper.toEntity(dto);

        return new ResponseEntity<>(userMapper.toResponse(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deletar(@PathVariable Long id){
        userServices.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
