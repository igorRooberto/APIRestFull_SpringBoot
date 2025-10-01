package com.example.Cursos.cursos.services;

import com.example.Cursos.cursos.entities.Aluno;
import com.example.Cursos.cursos.entities.Curso;
import com.example.Cursos.cursos.entities.Matricula;
import com.example.Cursos.cursos.mapper.MatriculaMapper;
import com.example.Cursos.cursos.repository.AlunoRepository;
import com.example.Cursos.cursos.repository.CursoRepository;
import com.example.Cursos.cursos.repository.MatriculaRepository;
import com.example.Cursos.cursos.view.dto.MatriculaRequestDto;
import com.example.Cursos.cursos.view.dto.MatriculaResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MatriculaServices {

    private final MatriculaRepository matriculaRepository;
    private final MatriculaMapper matriculaMapper;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaServices(AlunoRepository alunoRepository,
                             MatriculaRepository matriculaRepository,
                             MatriculaMapper matriculaMapper,
                             CursoRepository cursoRepository) {

        this.alunoRepository = alunoRepository;
        this.matriculaRepository = matriculaRepository;
        this.matriculaMapper = matriculaMapper;
        this.cursoRepository = cursoRepository;
    }

    public MatriculaResponseDto matricular(Long aluno_id, Long curso_id){
        Aluno aluno = alunoRepository.findById(aluno_id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Curso curso = cursoRepository.findById(curso_id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Matricula matricula = new Matricula(aluno, curso, LocalDate.now());
        Matricula matriculaSalva = matriculaRepository.save(matricula);
        return matriculaMapper.toResponse(matriculaSalva);
    }

    public void cancelarMatricula(Long id){
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mátricula não encontrada"));

        matriculaRepository.deleteById(id);
    }

    public List<MatriculaResponseDto> obterMatriculasPorAluno(Long aluno_id){
        Aluno aluno = alunoRepository.findById(aluno_id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));


        List<Matricula> matriculas = matriculaRepository.findByAluno(aluno);

        return matriculas.stream().map(matriculaMapper::toResponse).collect(Collectors.toList());
    }

    public List<MatriculaResponseDto> obterMatriculasPorCurso(Long curso_id){
        Curso curso = cursoRepository.findById(curso_id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        List<Matricula> matriculas = matriculaRepository.findByCurso(curso);

        return matriculas.stream().map(matriculaMapper::toResponse).collect(Collectors.toList());
    }
}
