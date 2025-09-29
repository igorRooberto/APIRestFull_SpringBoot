package com.example.Post.Author.view.controller;

import com.example.Post.Author.entities.Post;
import com.example.Post.Author.mapper.PostMapper;
import com.example.Post.Author.services.PostServices;
import com.example.Post.Author.view.dto.PostCreateDto;
import com.example.Post.Author.view.dto.PostResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author/post")
public class PostController {

    private final PostServices postServices;
    private final PostMapper postMapper;

    public PostController(PostMapper postMapper, PostServices postServices) {
        this.postMapper = postMapper;
        this.postServices = postServices;
    }

    @PostMapping("/{author_id}")
    public ResponseEntity<PostResponseDto> adicionarPost(@PathVariable Long author_id, @RequestBody PostCreateDto dto){
        PostResponseDto postResponseDto = postServices.adicionarPost(author_id, dto);

        return new ResponseEntity<>(postResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> atualizarPost(@PathVariable Long author_id,
                                                         @PathVariable Long id,
                                                         @RequestBody PostCreateDto dto){

        postServices.atualizarPost(author_id, dto, id);

        Post post = postMapper.toEntity(dto);

        return new ResponseEntity<>(postMapper.toResponse(post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostResponseDto> deletarPost(@PathVariable Long author_id, @PathVariable Long id){
        postServices.deletarPost(author_id, id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
