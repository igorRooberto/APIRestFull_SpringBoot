package com.example.crud.User.view.controller;

import com.example.crud.User.entities.User;
import com.example.crud.User.mapper.UserMapper;
import com.example.crud.User.services.UserServices;
import com.example.crud.User.shared.UserDto;
import com.example.crud.User.view.model.UserRequest;
import com.example.crud.User.view.model.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<UserResponse>> obtertodos() {
        List<UserDto> userDtos = userServices.findAll();
        List<UserResponse> response = userDtos.stream().map(UserMapper.INSTANCE::toResponse).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> adicionar(@RequestBody UserRequest userRequest) {
        UserDto userDto = UserMapper.INSTANCE.toResponse(userRequest);
        UserDto UserDto = userServices.adicionar(userDto);
        return new ResponseEntity<>(UserMapper.INSTANCE.toResponse(UserDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> obterPorId(@PathVariable Integer id) {
        UserDto userDto = userServices.findById(id);

        return new ResponseEntity<>(UserMapper.INSTANCE.toResponse(userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        userServices.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> atualizar(@RequestBody UserRequest userRequest, @PathVariable Integer id) {
        UserDto dto = UserMapper.INSTANCE.toResponse(userRequest);
        dto = userServices.atualizar(dto, id);

        return new ResponseEntity<>(UserMapper.INSTANCE.toResponse(dto), HttpStatus.OK);
    }
}
