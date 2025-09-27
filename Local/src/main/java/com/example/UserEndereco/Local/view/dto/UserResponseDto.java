package com.example.UserEndereco.Local.view.dto;

public record UserResponseDto(String name, String cpf, Long id, AddressResponseDto addressResponseDto) {
}
