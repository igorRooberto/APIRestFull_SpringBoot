package com.example.Post.Author.services;

import com.example.Post.Author.entities.Author;
import com.example.Post.Author.mapper.AuthorMapper;
import com.example.Post.Author.repository.AuthorRepository;
import com.example.Post.Author.view.dto.AuthorCreateDto;
import com.example.Post.Author.view.dto.AuthorResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServices {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServices(AuthorMapper authorMapper, AuthorRepository authorRepository) {
        this.authorMapper = authorMapper;
        this.authorRepository = authorRepository;
    }

    public List<AuthorResponseDto> getAllUsers(){
        List<Author> author = authorRepository.findAll();

        return author.stream().map(AuthorMapper.INSTANCE::toResponse).collect(Collectors.toList());
    }

    public AuthorResponseDto getById(Long id){
        Optional<Author> author = authorRepository.findById(id);

        if(author.isEmpty()){
            throw new RuntimeException();
        }

        return authorMapper.toResponse(author.get());
    }

    public AuthorResponseDto cadastrar(AuthorCreateDto dto){
        Author author = authorMapper.toEntity(dto);

        Author authorSaved = authorRepository.save(author);

        AuthorResponseDto responseDto = authorMapper.toResponse(authorSaved);

        return responseDto;
    }

    public AuthorResponseDto atualizar(AuthorCreateDto dto, Long id){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Author author1 = authorMapper.toEntity(dto);
        author1.setId(id);

        Author authorSaved = authorRepository.save(author1);

        return authorMapper.toResponse(authorSaved);
    }


    public void delete(Long id){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        authorRepository.deleteById(id);
    }

}
