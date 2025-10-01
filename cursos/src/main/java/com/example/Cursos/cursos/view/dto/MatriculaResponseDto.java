package com.example.Cursos.cursos.view.dto;

import java.time.LocalDate;

public record MatriculaResponseDto(Long id,
                                   LocalDate dataMatricula,
                                   String nomeAluno,
                                   String nomeCurso) {
}
