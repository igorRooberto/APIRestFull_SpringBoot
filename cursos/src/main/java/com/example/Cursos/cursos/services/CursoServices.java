package com.example.Cursos.cursos.services;

import com.example.Cursos.cursos.entities.Curso;
import com.example.Cursos.cursos.entities.Instrutor;
import com.example.Cursos.cursos.mapper.CursoMapper;
import com.example.Cursos.cursos.repository.CursoRepository;
import com.example.Cursos.cursos.repository.InstrutorRepository;
import com.example.Cursos.cursos.view.dto.CursoRequestDto;
import com.example.Cursos.cursos.view.dto.CursoResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServices {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;
    private final InstrutorRepository instrutorRepository;

    public CursoServices(CursoMapper cursoMapper, CursoRepository cursoRepository, InstrutorRepository instrutorRepository) {
        this.cursoMapper = cursoMapper;
        this.cursoRepository = cursoRepository;
        this.instrutorRepository = instrutorRepository;
    }

    public CursoResponseDto criarCurso(CursoRequestDto dto){

        Instrutor instrutor = instrutorRepository.findById(dto.instrutor_id())
                .orElseThrow(() -> new RuntimeException("Instrutor com ID " + dto.instrutor_id() + " não encontrado."));

        Curso curso = cursoMapper.toEntity(dto);
        curso.setInstrutor(instrutor);

        Curso cursoSaved = cursoRepository.save(curso);

        return cursoMapper.toResponse(cursoSaved);
    }

    public List<CursoResponseDto> obterTodos(){
        List<Curso> curso = cursoRepository.findAll();

        return curso.stream().map(cursoMapper::toResponse).collect(Collectors.toList());
    }

    public CursoResponseDto obterPorId(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        return cursoMapper.toResponse(curso);
    }

    public CursoResponseDto atualizar(CursoRequestDto dto, Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Curso curso1 = cursoMapper.toEntity(dto);
        curso1.setId(id);

        Instrutor novoInstrutor = instrutorRepository.findById(dto.instrutor_id())
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado!"));

        curso1.setInstrutor(novoInstrutor);

        Curso cursoSaved = cursoRepository.save(curso1);
        CursoResponseDto responseDto = cursoMapper.toResponse(cursoSaved);

        return responseDto;
    }

    public void deletar(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        cursoRepository.deleteById(id);
    }

    public List<CursoResponseDto> obterPorInstrutor(Long instrutor_id){
        List<Curso> cursoBanco = cursoRepository.findByInstrutorId(instrutor_id);

        return cursoBanco.stream().map(cursoMapper::toResponse).collect(Collectors.toList());
    }
}
