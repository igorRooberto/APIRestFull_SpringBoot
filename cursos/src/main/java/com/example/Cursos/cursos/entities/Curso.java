package com.example.Cursos.cursos.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curso")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrutor_id",nullable = false)
    private Instrutor instrutor;

    @OneToMany(mappedBy = "curso")
    private List<Matricula> matricula;

    public Curso(String categoria, Long id, Instrutor instrutor, List<Matricula> matricula, String name) {
        this.categoria = categoria;
        this.id = id;
        this.instrutor = instrutor;
        this.matricula = matricula;
        this.name = name;
    }

    public Curso() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public List<Matricula> getMatricula() {
        return matricula;
    }

    public void setMatricula(List<Matricula> matricula) {
        this.matricula = matricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
