package com.example.Cursos.cursos.mapper;

import com.example.Cursos.cursos.entities.Aluno;
import com.example.Cursos.cursos.view.dto.AlunoRequestDto;
import com.example.Cursos.cursos.view.dto.AlunoResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    Aluno toEntity(AlunoRequestDto dto);

    AlunoResponseDto toResponse(Aluno aluno);
}
