package com.example.Cursos.cursos.services;

import com.example.Cursos.cursos.entities.Aluno;
import com.example.Cursos.cursos.mapper.AlunoMapper;
import com.example.Cursos.cursos.repository.AlunoRepository;
import com.example.Cursos.cursos.view.dto.AlunoRequestDto;
import com.example.Cursos.cursos.view.dto.AlunoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoServices {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoServices(AlunoMapper alunoMapper, AlunoRepository alunoRepository) {
        this.alunoMapper = alunoMapper;
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponseDto criarAluno(AlunoRequestDto dto){
        Aluno aluno = alunoMapper.toEntity(dto);

        Aluno alunoSaved = alunoRepository.save(aluno);
        AlunoResponseDto alunoResponseDto = alunoMapper.toResponse(alunoSaved);
        return alunoResponseDto;
    }

    public List<AlunoResponseDto> obterTodos(){
        List<Aluno> aluno = alunoRepository.findAll();

        return aluno.stream().map(alunoMapper::toResponse).collect(Collectors.toList());
    }

    public AlunoResponseDto obterPorId(Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return alunoMapper.toResponse(aluno);
    }

    public AlunoResponseDto atualizar(AlunoRequestDto dto, Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Aluno aluno1 = alunoMapper.toEntity(dto);
        aluno1.setId(id);

        Aluno alunoSaved = alunoRepository.save(aluno1);
        AlunoResponseDto dtoResponse = alunoMapper.toResponse(alunoSaved);

        return dtoResponse;
    }

    public void deletar(Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        alunoRepository.deleteById(id);
    }
}
