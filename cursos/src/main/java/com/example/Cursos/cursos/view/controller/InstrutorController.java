package com.example.Cursos.cursos.view.controller;

import com.example.Cursos.cursos.mapper.InstrutorMapper;
import com.example.Cursos.cursos.services.InstrutorServices;
import com.example.Cursos.cursos.view.dto.InstrutorRequestDto;
import com.example.Cursos.cursos.view.dto.InstrutorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrutor")
public class InstrutorController {

    private final InstrutorServices instrutorServices;

    public InstrutorController(InstrutorServices instrutorServices) {
        this.instrutorServices = instrutorServices;
    }

    @PostMapping
    public ResponseEntity<InstrutorResponseDto> criarInstrutor(@RequestBody InstrutorRequestDto dto){
        InstrutorResponseDto dto1 = instrutorServices.criarInstrutor(dto);

        return new ResponseEntity<>(dto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InstrutorResponseDto>> obterTodos(){
        return new ResponseEntity<>(instrutorServices.obterTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrutorResponseDto> obterPorId(@PathVariable Long id){
        return new ResponseEntity<>(instrutorServices.obterPorId(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrutorResponseDto> atualizar(@PathVariable Long id, @RequestBody InstrutorRequestDto dto){
        InstrutorResponseDto dto1 = instrutorServices.atualizarDados(id, dto);

        return new ResponseEntity<>(dto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        instrutorServices.deletarInstrutor(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
