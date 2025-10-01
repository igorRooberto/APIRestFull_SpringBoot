package com.example.Cursos.cursos.view.controller;

import com.example.Cursos.cursos.services.MatriculaServices;
import com.example.Cursos.cursos.view.dto.MatriculaRequestDto;
import com.example.Cursos.cursos.view.dto.MatriculaResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaController {

    private final MatriculaServices matriculaServices;

    public MatriculaController(MatriculaServices matriculaServices) {
        this.matriculaServices = matriculaServices;
    }

    @PostMapping("/{aluno_id}/{curso_id}")
    public ResponseEntity<MatriculaResponseDto> matricular( @PathVariable Long aluno_id,
                                                            @PathVariable Long curso_id){
        MatriculaResponseDto response = matriculaServices.matricular(aluno_id, curso_id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelar(@PathVariable Long id){
        matriculaServices.cancelarMatricula(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/alunos/{aluno_id}")
    public ResponseEntity<List<MatriculaResponseDto>> obterPorAluno(@PathVariable Long aluno_id){
        return new ResponseEntity<>(matriculaServices.obterMatriculasPorAluno(aluno_id), HttpStatus.OK);
    }
    @GetMapping("/cursos/{curso_id}")
    public ResponseEntity<List<MatriculaResponseDto>> obterPorCurso(@PathVariable Long curso_id){
        return new ResponseEntity<>(matriculaServices.obterMatriculasPorCurso(curso_id), HttpStatus.OK);
    }
}
