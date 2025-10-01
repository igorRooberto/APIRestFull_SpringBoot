package com.example.Cursos.cursos.mapper;

import com.example.Cursos.cursos.entities.Curso;
import com.example.Cursos.cursos.view.dto.CursoRequestDto;
import com.example.Cursos.cursos.view.dto.CursoResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    Curso toEntity(CursoRequestDto dto);

    @Mapping(source = "instrutor.name", target = "nomeInstrutor")
    CursoResponseDto toResponse(Curso curso);
}
