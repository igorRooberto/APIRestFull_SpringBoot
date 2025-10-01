package com.example.Post.Author.services;

import com.example.Post.Author.entities.Author;
import com.example.Post.Author.entities.Post;
import com.example.Post.Author.mapper.PostMapper;
import com.example.Post.Author.repository.AuthorRepository;
import com.example.Post.Author.repository.PostRepository;
import com.example.Post.Author.view.dto.PostCreateDto;
import com.example.Post.Author.view.dto.PostResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PostServices {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final AuthorRepository authorRepository;

    public PostServices(AuthorRepository authorRepository, PostRepository postRepository, PostMapper postMapper) {
        this.authorRepository = authorRepository;
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public PostResponseDto adicionarPost(Long author_id, PostCreateDto dto){
        Author author = authorRepository.findById(author_id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Post post = postMapper.toEntity(dto);
        post.setAuthor(author);
        Post postSaved = postRepository.save(post);
        return postMapper.toResponse(postSaved);
    }

    public void deletarPost(Long author_id, Long id){
        Author author = authorRepository.findById(author_id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encotrado!"));

        postRepository.deleteById(id);
    }

    public PostResponseDto atualizarPost(Long author_id, PostCreateDto dto, Long id){
        Author author = authorRepository.findById(author_id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encotrado!"));

        Post post1 = postMapper.toEntity(dto);
        post1.setAuthor(author);

        Post postSaved = postRepository.save(post1);
        return postMapper.toResponse(postSaved);
    }


}
