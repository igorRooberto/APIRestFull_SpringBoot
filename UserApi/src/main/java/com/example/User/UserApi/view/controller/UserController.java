package com.example.User.UserApi.view.controller;

import com.example.User.UserApi.mapper.UserMapper;
import com.example.User.UserApi.services.UserServices;
import com.example.User.UserApi.view.dto.UserDto;
import com.example.User.UserApi.view.dto.UserRequest;
import com.example.User.UserApi.view.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<UserResponse>> obterTodos(){
        List<UserDto> userDtos = userServices.obterTodos();
        List<UserResponse> response = userDtos.stream().map(UserMapper.INSTANCE::toResponse).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> obterPorId(@PathVariable Long id){
        UserDto userDto = userServices.obterPorId(id);

        return new ResponseEntity<>(UserMapper.INSTANCE.toResponse(userDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> adicionar(@RequestBody UserRequest userRequest){
        UserDto userDto = UserMapper.INSTANCE.toRequest(userRequest);

        UserDto userSaved = userServices.adicionar(userDto);

        return new ResponseEntity<>(UserMapper.INSTANCE.toResponse(userSaved), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        userServices.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> atualizar(@RequestBody UserRequest userRequest, @PathVariable Long id){
        UserDto userDto = UserMapper.INSTANCE.toRequest(userRequest);
        UserDto userSaved = userServices.atualizar(id, userDto);

        return new ResponseEntity<>(UserMapper.INSTANCE.toResponse(userSaved), HttpStatus.OK );
    }

}
