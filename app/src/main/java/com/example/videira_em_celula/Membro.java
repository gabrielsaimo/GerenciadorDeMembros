package com.example.videira_em_celula;

import java.io.Serializable;

public class Membro implements Serializable {

private Integer id;
private String nome;
private String telefone;
private String data_de_nacimento;
private String endereco;
private String email;
private String batizado;

    public String getBatizado() {
        return batizado;
    }

    public void setBatizado(String batizado) {
        this.batizado = batizado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData_de_nacimento() {
        return data_de_nacimento;
    }

    public void setData_de_nacimento(String data_de_nacimento) {
        this.data_de_nacimento = data_de_nacimento;
    }


    public String toString(){
    return nome;
    }
}

