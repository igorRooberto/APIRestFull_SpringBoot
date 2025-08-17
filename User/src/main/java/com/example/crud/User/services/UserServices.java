package com.example.crud.User.services;

import com.example.crud.User.entities.User;
import com.example.crud.User.exceptions.ResourceNotFoundException;
import com.example.crud.User.mapper.UserMapper;
import com.example.crud.User.repository.UserRepository;
import com.example.crud.User.shared.UserDto;
import com.example.crud.User.view.model.UserRequest;
import com.example.crud.User.view.model.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;


    public List<UserDto> findAll(){
        List<User> users = userRepository.findAll();

            return users.stream().map(UserMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public UserDto adicionar(UserDto userDto){
        User User = UserMapper.INSTANCE.toEntity(userDto);
        User userSaved = userRepository.save(User);
        return UserMapper.INSTANCE.toDto(userSaved);
    }

    public UserDto findById(Integer id){
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado!");
        }

        return UserMapper.INSTANCE.toDto(userOptional.get());
    }

    public void deletar(Integer id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new InputMismatchException("Não foi possível deletar o produto!");
        }

        userRepository.deleteById(id);
    }

    public UserDto atualizar(UserDto userDto, Integer id){
        userDto.setId(id);

        User user = UserMapper.INSTANCE.toEntity(userDto);
        userRepository.save(user);

        return UserMapper.INSTANCE.toDto(user);
    }
}
