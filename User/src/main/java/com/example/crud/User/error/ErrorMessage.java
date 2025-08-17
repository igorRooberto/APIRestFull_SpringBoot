package com.example.crud.User.error;

public class ErrorMessage {

    private String titulo;
    private Integer status;
    private String message;

    public ErrorMessage(String titulo, Integer status, String message) {
        this.titulo = titulo;
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
