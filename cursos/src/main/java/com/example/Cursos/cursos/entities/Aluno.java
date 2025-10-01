package com.example.Cursos.cursos.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false)
    private String name;

    @Column(name = "cpf",nullable = false,unique = true)
    private String cpf;

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;

    public Aluno(String cpf, Long id, List<Matricula> matriculas, String name) {
        this.cpf = cpf;
        this.id = id;
        this.matriculas = matriculas;
        this.name = name;
    }

    public Aluno() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
