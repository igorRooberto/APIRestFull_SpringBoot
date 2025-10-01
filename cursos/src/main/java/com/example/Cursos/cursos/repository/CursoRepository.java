package com.example.Cursos.cursos.repository;

import com.example.Cursos.cursos.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByInstrutorId(Long instrutorId);
}
