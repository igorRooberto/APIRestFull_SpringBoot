package com.example.User.UserApi.services;

import com.example.User.UserApi.entities.User;
import com.example.User.UserApi.handler.exception.ResourceNotFoundException;
import com.example.User.UserApi.mapper.UserMapper;
import com.example.User.UserApi.repository.UserRepository;
import com.example.User.UserApi.view.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> obterTodos(){
        List<User> users = userRepository.findAll();

        return users.stream().map(UserMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public UserDto obterPorId(Long id){
         Optional<User> user = userRepository.findById(id);

         if(user.isEmpty()){
             throw new InputMismatchException("O Usuário não foi encontrado!");
         }

         return UserMapper.INSTANCE.toDto(user.get());
    }

    public UserDto adicionar(UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);

        User userSaved = userRepository.save(user);

        return UserMapper.INSTANCE.toDto(userSaved);
    }

    public void deletar(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new ResourceNotFoundException("O id não existe");
        }

        userRepository.deleteById(id);
    }

    public UserDto atualizar(Long id, UserDto userDto){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new ResourceNotFoundException("O id do produto não existe");
        }

        userDto.setId(id);

        User user1 = UserMapper.INSTANCE.toEntity(userDto);
        User userSaved = userRepository.save(user1);

        return UserMapper.INSTANCE.toDto(userSaved);
    }

}
