package com.example.Post.Author.view.controller;

import com.example.Post.Author.entities.Author;
import com.example.Post.Author.mapper.AuthorMapper;
import com.example.Post.Author.services.AuthorServices;
import com.example.Post.Author.view.dto.AuthorCreateDto;
import com.example.Post.Author.view.dto.AuthorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorServices authorServices;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorMapper authorMapper, AuthorServices authorServices) {
        this.authorMapper = authorMapper;
        this.authorServices = authorServices;
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthor(){
        return new ResponseEntity<>(authorServices.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(authorServices.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> cadastrar(@RequestBody AuthorCreateDto dto){
        // 1. Chame o serviço e guarde o DTO de resposta que ele retorna
        AuthorResponseDto responseDto = authorServices.cadastrar(dto);

        // 2. Simplesmente retorne esse DTO na resposta
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> atualizar(@RequestBody AuthorCreateDto dto, @PathVariable Long id){
        authorServices.atualizar(dto, id);
        Author author = authorMapper.toEntity(dto);

        return new ResponseEntity<>(authorMapper.toResponse(author), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> deletar(Long id){
        authorServices.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
