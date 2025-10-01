package com.example.Cursos.cursos.view.controller;

import com.example.Cursos.cursos.entities.Aluno;
import com.example.Cursos.cursos.mapper.AlunoMapper;
import com.example.Cursos.cursos.services.AlunoServices;
import com.example.Cursos.cursos.view.dto.AlunoRequestDto;
import com.example.Cursos.cursos.view.dto.AlunoResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    private final AlunoServices alunoServices;
    private final AlunoMapper alunoMapper;

    public AlunoController(AlunoMapper alunoMapper, AlunoServices alunoServices) {
        this.alunoMapper = alunoMapper;
        this.alunoServices = alunoServices;
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDto>> obterTodos(){
        return new ResponseEntity<>(alunoServices.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> obterPorId(@PathVariable Long id){
        return new ResponseEntity<>(alunoServices.obterPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDto> cadastrarAluno(@RequestBody AlunoRequestDto dto){
        AlunoResponseDto dto1 = alunoServices.criarAluno(dto);

        return new ResponseEntity<>(dto1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> atualizarAluno(@PathVariable Long id, @RequestBody AlunoRequestDto dto){
        AlunoResponseDto dto1 = alunoServices.atualizar(dto, id);

        return new ResponseEntity<>(dto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(Long id){
        alunoServices.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
