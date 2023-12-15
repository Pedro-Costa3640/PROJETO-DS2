/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda.modelo.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author guilh
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String usuario;
    private LocalDateTime data_hora_criacao;
    private LocalDateTime ultimoLogin;

    public Usuario() {
    }

    public Usuario(int id, String nome, String senha, String usuario, LocalDateTime data_hora_criacao, LocalDateTime ultimoLogin) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.data_hora_criacao = data_hora_criacao;
        this.ultimoLogin = ultimoLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getData_hora_criacao() {
        return data_hora_criacao;
    }

    public void setData_hora_criacao(LocalDateTime data_hora_criacao) {
        this.data_hora_criacao = data_hora_criacao;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }
            
    
    
}
