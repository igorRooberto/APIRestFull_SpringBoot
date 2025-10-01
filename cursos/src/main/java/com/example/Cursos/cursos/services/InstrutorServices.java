package com.example.Cursos.cursos.services;

import com.example.Cursos.cursos.entities.Instrutor;
import com.example.Cursos.cursos.mapper.InstrutorMapper;
import com.example.Cursos.cursos.repository.InstrutorRepository;
import com.example.Cursos.cursos.view.dto.InstrutorRequestDto;
import com.example.Cursos.cursos.view.dto.InstrutorResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstrutorServices {

    private final InstrutorRepository instrutorRepository;
    private final InstrutorMapper instrutorMapper;

    public InstrutorServices(InstrutorRepository instrutorRepository, InstrutorMapper instrutorMapper){
        this.instrutorRepository = instrutorRepository;
        this.instrutorMapper = instrutorMapper;
    }

    public InstrutorResponseDto criarInstrutor(InstrutorRequestDto dto){
        Instrutor instrutor = instrutorMapper.toEntity(dto);

        Instrutor instrutorSaved = instrutorRepository.save(instrutor);

        InstrutorResponseDto responseDto = instrutorMapper.toResponse(instrutorSaved);

        return responseDto;
    }

    public List<InstrutorResponseDto> obterTodos(){
        List<Instrutor> instrutors = instrutorRepository.findAll();

        return instrutors.stream().map(instrutorMapper::toResponse).collect(Collectors.toList());
    }

    public InstrutorResponseDto obterPorId(Long id){
        Instrutor instrutor = instrutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return instrutorMapper.toResponse(instrutor);
    }

    public InstrutorResponseDto atualizarDados(Long id,InstrutorRequestDto dto){
        Instrutor instrutor = instrutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Instrutor instrutor1 = instrutorMapper.toEntity(dto);
        instrutor1.setId(id);

        Instrutor instrutorSaved = instrutorRepository.save(instrutor1);
        InstrutorResponseDto responseDto = instrutorMapper.toResponse(instrutor);
        return responseDto;
    }

    public void deletarInstrutor(Long id){
        Instrutor instrutor = instrutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        instrutorRepository.deleteById(id);
    }
}
