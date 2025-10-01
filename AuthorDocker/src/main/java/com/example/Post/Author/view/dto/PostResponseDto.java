package com.example.Post.Author.view.dto;

import java.time.Instant;

public record PostResponseDto(Long id, String content, Instant createTimeStamp) {
}
