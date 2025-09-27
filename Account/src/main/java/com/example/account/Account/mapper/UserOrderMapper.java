package com.example.account.Account.mapper;

import com.example.account.Account.entities.UserOrders;
import com.example.account.Account.view.dto.UserOrderCreateDto;
import com.example.account.Account.view.dto.UserOrderResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserOrderMapper {

    // Converte DTO de criação -> Entidade
    UserOrders toEntity(UserOrderCreateDto dto);

    // Converte Entidade -> DTO de resposta
    UserOrderResponseDto toResponse(UserOrders order);
}
