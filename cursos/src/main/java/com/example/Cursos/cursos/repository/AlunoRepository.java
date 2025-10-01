package com.example.Cursos.cursos.repository;

import com.example.Cursos.cursos.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
