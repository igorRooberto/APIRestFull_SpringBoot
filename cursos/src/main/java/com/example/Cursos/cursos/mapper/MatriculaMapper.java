package com.example.Cursos.cursos.mapper;

import com.example.Cursos.cursos.entities.Matricula;
import com.example.Cursos.cursos.view.dto.MatriculaRequestDto;
import com.example.Cursos.cursos.view.dto.MatriculaResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatriculaMapper {

    Matricula toEntity(MatriculaRequestDto dto);

    @Mapping(source = "aluno.name", target = "nomeAluno")
    @Mapping(source = "curso.name", target = "nomeCurso")
    MatriculaResponseDto toResponse(Matricula matricula);
}
