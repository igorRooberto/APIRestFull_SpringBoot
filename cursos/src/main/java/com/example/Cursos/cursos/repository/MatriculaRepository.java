package com.example.Cursos.cursos.repository;

import com.example.Cursos.cursos.entities.Aluno;
import com.example.Cursos.cursos.entities.Curso;
import com.example.Cursos.cursos.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    boolean existsByAlunoAndCurso(Aluno aluno, Curso curso);

    List<Matricula> findByAlunoId(Long alunoId);

    List<Matricula> findByCursoId(Long cursoId);

    List<Matricula> findByAluno(Aluno aluno);

    List<Matricula> findByCurso(Curso curso);
}
