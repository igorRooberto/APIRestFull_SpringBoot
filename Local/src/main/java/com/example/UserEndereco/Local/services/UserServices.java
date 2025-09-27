package com.example.UserEndereco.Local.services;

import com.example.UserEndereco.Local.entities.User;
import com.example.UserEndereco.Local.handler.exception.ResourceNotFoundException;
import com.example.UserEndereco.Local.mapper.UserMapper;
import com.example.UserEndereco.Local.repository.UserRepository;
import com.example.UserEndereco.Local.view.dto.UserCreateDto;
import com.example.UserEndereco.Local.view.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServices {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServices(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto createUser(UserCreateDto dto){
        User user = userMapper.toEntity(dto);
        User userSaved = userRepository.save(user);
        return userMapper.toResponse(userSaved);
    }

    public void deleteUser(Long id){
        Optional user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new ResourceNotFoundException("Usuário não encontrado!");
        }
          userRepository.deleteById(id);
    }

    public List<UserResponseDto> getAllUser(){
        List<User> user = userRepository.findAll();

        return user.stream().map(UserMapper.INSTANCE::toResponse).collect(Collectors.toList());
    }

    public UserResponseDto getById(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new ResourceNotFoundException("Usuário não encontrado!");
        }

        return userMapper.toResponse(user.get());
    }

    public UserResponseDto UpdateData(Long id, UserCreateDto dto){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new ResourceNotFoundException("Usuário não encontrado!");
        }

        User user1 = userMapper.toEntity(dto);
        user1.setId(id);

        User userSaved = userRepository.save(user1);

        return userMapper.toResponse(userSaved);
    }

}
