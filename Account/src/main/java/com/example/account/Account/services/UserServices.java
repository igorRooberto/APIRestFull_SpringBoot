package com.example.account.Account.services;

import com.example.account.Account.entities.User;
import com.example.account.Account.mapper.UserMapper;
import com.example.account.Account.repository.UserRepository;
import com.example.account.Account.view.dto.UserCreateDto;
import com.example.account.Account.view.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServices {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServices(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDto> getAllUsers(){
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserResponseDto createUser(UserCreateDto dto){
        User user = userMapper.toEntity(dto);
        User userSaved = userRepository.save(user);
        return userMapper.toResponse(userSaved);
    }

    public UserResponseDto getUserById(UUID id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return userMapper.toResponse(user);
    }
}
