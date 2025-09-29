package com.example.Post.Author.view.dto;

import com.example.Post.Author.entities.Author;
import com.example.Post.Author.entities.Post;

import java.util.List;

public record AuthorResponseDto(Long id, String name, String email, List<PostResponseDto> post) {
}
