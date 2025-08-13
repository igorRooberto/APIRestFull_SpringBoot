package br.com.Primeiro_teste_SpringBoot.model;

public class User {

    private String name;
    private Integer id;
    private Integer cpf;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCpf(){
        return cpf;
    }

    public void setCpf(Integer cpf){
        this.cpf = cpf;
    }
}
