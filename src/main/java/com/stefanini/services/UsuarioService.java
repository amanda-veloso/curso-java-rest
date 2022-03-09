package com.stefanini.services;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.management.RuntimeErrorException;

import com.stefanini.DTO.UsuarioDTO;
import com.stefanini.repository.UsuarioRepository;

// Toda regra de negócio faz aqui

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    //public UsuarioService(){}

    //CRUD
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioRepository.listarUsuarios();
    }

    public UsuarioDTO pegarUsuarioPorId(Long idUsuario){
        return usuarioRepository.pegarUsuarioPorId(idUsuario);
    }

    //Criar Usuário
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        if (Objects.nonNull(usuarioDTO.getIdUsuario())){
            throw new RuntimeException("Erro ao cadastrar usuário, não informe o ID");
        }
        return usuarioRepository.criarUsuario(usuarioDTO); 
         
         //Criptografando a senha 
  /*  String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
    usuarioDTO.setSenha(senha);
    return usuarioRepository.criarUsuario(usuarioDTO);
    }*/
}

    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO){
        //usuarioDTO.setDataAtualizacao(LocalDateTime.now());
        if (!Objects.nonNull(usuarioDTO.getIdUsuario())) {
            throw new RuntimeException("Ao alterar mande um ID");

        }
        if (!usuarioDTO.getSenha().isEmpty()){
               //criptografando a senha 
               String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
               usuarioDTO.setSenha(senha);
        }

        
       // usuarioDTO.setDataAtualizacao(LocalDateTime.now());
        return usuarioRepository.alterarUsuario(usuarioDTO);
    }

    public void deletarUsuario (Long idUsuario) {
        usuarioRepository.deletarUsuario(idUsuario);
    } 

    //Outros End-Points

    public List<UsuarioDTO> listarAniversariantesDoMes(){
        return usuarioRepository.listarAniversariantesDoMes();
    }

    public List<UsuarioDTO> listarInicialDoNome(String inicial){
        return usuarioRepository.listarInicialNome(inicial);
    }
}

