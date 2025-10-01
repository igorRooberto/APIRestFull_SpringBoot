package com.example.Cursos.cursos.view.controller;

import com.example.Cursos.cursos.mapper.CursoMapper;
import com.example.Cursos.cursos.services.CursoServices;
import com.example.Cursos.cursos.view.dto.CursoRequestDto;
import com.example.Cursos.cursos.view.dto.CursoResponseDto;
import com.example.Cursos.cursos.view.dto.InstrutorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    public final CursoServices cursoServices;

    public CursoController(CursoServices cursoServices) {
        this.cursoServices = cursoServices;
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> obterTodos(){
        return new ResponseEntity<>(cursoServices.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> obterPorId(@PathVariable Long id){
        return new ResponseEntity<>(cursoServices.obterPorId(id), HttpStatus.OK);
    }

    @GetMapping("/instrutor/{instrutor_id}")
    public ResponseEntity<List<CursoResponseDto>> obterPorInstrutor(@PathVariable Long instrutor_id){
        return new ResponseEntity<>(cursoServices.obterPorInstrutor(instrutor_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CursoResponseDto> cadastrarCurso(@RequestBody CursoRequestDto dto){
        return new ResponseEntity<>(cursoServices.criarCurso(dto),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> atualizar(@PathVariable Long id, @RequestBody CursoRequestDto dto){
        return new ResponseEntity<>(cursoServices.atualizar(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCurso(@PathVariable Long id){
        cursoServices.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
