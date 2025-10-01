package com.example.Post.Author.mapper;

import com.example.Post.Author.entities.Author;
import com.example.Post.Author.view.dto.AuthorCreateDto;
import com.example.Post.Author.view.dto.AuthorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    //Converte dto de create para entity
    Author toEntity(AuthorCreateDto dto);

    //Converte Entity para dto de reposta
    AuthorResponseDto toResponse(Author author);

}
