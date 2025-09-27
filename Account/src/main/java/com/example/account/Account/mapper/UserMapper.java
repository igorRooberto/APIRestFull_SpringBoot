package com.example.account.Account.mapper;

import com.example.account.Account.entities.User;
import com.example.account.Account.view.dto.UserCreateDto;
import com.example.account.Account.view.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Converte DTO de criação -> Entidade
    User toEntity(UserCreateDto dto);

    // Converte Entidade -> DTO de resposta
    UserResponseDto toResponse(User user);
}
