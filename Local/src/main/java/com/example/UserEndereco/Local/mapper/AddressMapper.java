package com.example.UserEndereco.Local.mapper;


import com.example.UserEndereco.Local.entities.Address;
import com.example.UserEndereco.Local.entities.User;
import com.example.UserEndereco.Local.view.dto.AddressCreateDto;
import com.example.UserEndereco.Local.view.dto.AddressResponseDto;
import com.example.UserEndereco.Local.view.dto.UserCreateDto;
import com.example.UserEndereco.Local.view.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //Converte DTO DE CRIAÇÃO PARA ENTIDADE
    Address toEntityAddress(AddressCreateDto dto);

    //Converte Entidade para Dto de Resposta
    AddressResponseDto toResponseAddress(Address address);
}
