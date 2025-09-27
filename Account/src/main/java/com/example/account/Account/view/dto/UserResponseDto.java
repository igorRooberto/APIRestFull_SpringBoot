package com.example.account.Account.view.dto;

import java.util.List;
import java.util.UUID;

public record UserResponseDto(UUID id, String name, String email, List<UserOrderResponseDto> userOrders) {
}
