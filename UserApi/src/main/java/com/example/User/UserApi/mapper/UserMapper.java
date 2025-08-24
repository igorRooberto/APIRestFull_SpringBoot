package com.example.User.UserApi.mapper;

import com.example.User.UserApi.entities.User;
import com.example.User.UserApi.view.dto.UserDto;
import com.example.User.UserApi.view.dto.UserRequest;
import com.example.User.UserApi.view.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Converte UserDto → User (entidade)
    User toEntity(UserDto dto);

    // Converte UserDto → UserResponse
    UserResponse toResponse(UserDto dto);

    // Converte User → UserDto
    UserDto toDto(User user);

    // Converte UserRequest → UserDto
    UserDto toRequest(UserRequest request);


}
