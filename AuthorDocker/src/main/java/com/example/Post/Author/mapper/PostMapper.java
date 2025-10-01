package com.example.Post.Author.mapper;

import com.example.Post.Author.entities.Author;
import com.example.Post.Author.entities.Post;
import com.example.Post.Author.view.dto.AuthorCreateDto;
import com.example.Post.Author.view.dto.AuthorResponseDto;
import com.example.Post.Author.view.dto.PostCreateDto;
import com.example.Post.Author.view.dto.PostResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    //Converte dto de create para entity
    Post toEntity(PostCreateDto dto);

    //Converte Entity para dto de reposta
    PostResponseDto toResponse(Post post);
}
