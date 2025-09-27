package com.example.UserEndereco.Local.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String cidade;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(String cidade, String rua, User user) {
        this.cidade = cidade;
        this.rua = rua;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address() {
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
