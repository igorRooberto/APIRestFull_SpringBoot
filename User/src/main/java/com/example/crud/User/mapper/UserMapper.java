package com.example.crud.User.mapper;

import com.example.crud.User.entities.User;
import com.example.crud.User.shared.UserDto;
import com.example.crud.User.view.model.UserRequest;
import com.example.crud.User.view.model.UserResponse;
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
    UserDto toResponse(UserRequest request);

}
