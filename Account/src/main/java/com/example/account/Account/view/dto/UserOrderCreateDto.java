package com.example.account.Account.view.dto;

import java.util.UUID;

public record UserOrderCreateDto(String description, UUID userId) {
}
