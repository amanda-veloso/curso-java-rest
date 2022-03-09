package com.stefanini.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stefanini.DTO.UsuarioDTO;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table (name = "tab_usuario") 
public class UsuarioEntity {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY) // GERAR A CHAVE PRIMÁRIA AUTOMATICAMENTE
    private long idUsuario;

    
    @Column (nullable = false, length = 50)
    private String nome;

    @Column (nullable = false, unique = true, length = 20)
    private String login;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String senha;

    @Column (name = "data_nascimento")
    private LocalDate dataNascimento;

    @CreationTimestamp
    @Column (name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column (name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    // Construtores
    public UsuarioEntity(){

    }
        
    public UsuarioEntity(UsuarioDTO usuarioDTO){
       // System.out.println(usuarioDTO);
       // this.idUsuario = usuarioDTO.getIdUsuario();
        this.nome = usuarioDTO.getNome();
        this.login = usuarioDTO.getLogin();
        this.senha = usuarioDTO.getSenha();
        this.email = usuarioDTO.getEmail();
        this.dataNascimento = usuarioDTO.getDataNascimento();
        this.dataCriacao = usuarioDTO.getDataCriacao();
        this.dataAtualizacao = usuarioDTO.getDataAtualizacao();
        
    }
    
    //Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

  
}
