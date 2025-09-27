package com.example.UserEndereco.Local.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "password",nullable = true)
    private String password;

    @Column(name = "cpf", nullable = true, unique = true)
    private String cpf;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    public User(String cpf, Long id, String name, String password, Address address) {
        this.cpf = cpf;
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public User() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
