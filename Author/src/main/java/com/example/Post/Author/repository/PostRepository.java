package com.example.Post.Author.repository;

import com.example.Post.Author.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
