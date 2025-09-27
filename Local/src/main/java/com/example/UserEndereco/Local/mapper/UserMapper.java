package com.example.UserEndereco.Local.mapper;

import com.example.UserEndereco.Local.entities.Address;
import com.example.UserEndereco.Local.entities.User;
import com.example.UserEndereco.Local.view.dto.AddressCreateDto;
import com.example.UserEndereco.Local.view.dto.AddressResponseDto;
import com.example.UserEndereco.Local.view.dto.UserCreateDto;
import com.example.UserEndereco.Local.view.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //Converte Dto de Criação para Entidade
    User toEntity(UserCreateDto dto);

    //Converte Entidade para dto de Resposta
    @Mapping(source = "address", target = "addressResponseDto")
    UserResponseDto toResponse(User user);
}
