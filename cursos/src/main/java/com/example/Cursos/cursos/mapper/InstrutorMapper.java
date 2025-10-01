package com.example.Cursos.cursos.mapper;

import com.example.Cursos.cursos.entities.Instrutor;
import com.example.Cursos.cursos.view.dto.InstrutorRequestDto;
import com.example.Cursos.cursos.view.dto.InstrutorResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface InstrutorMapper {

    Instrutor toEntity(InstrutorRequestDto dto);

    InstrutorResponseDto toResponse(Instrutor instrutor);
}
