package com.stefanini.repository;

import java.security.KeyStore.PasswordProtection;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.stefanini.DTO.UsuarioDTO;
import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.UsuarioEntity;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<UsuarioEntity, Long> {

  //  PasswordProtection passwordProtection;

    public List<UsuarioDTO> listarUsuarios (){ //lista do usuário DTO
        List<UsuarioEntity> usuarios = this.listAll();
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO pegarUsuarioPorId (Long id){
        return new UsuarioDTO (this.findById(id));
    }

    @Transactional // persistir no banco ou atualizar  
    public UsuarioDTO criarUsuario (UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.save(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public void deletarUsuario (Long idUsuario){
        this.delete(idUsuario);
    }

    public List<UsuarioDTO> listarAniversariantesDoMes(){
        Query nativeQuery = this.createNativeQuery("SELECT * FROM cadastro WHERE month (data_nascimento) = ?");
        nativeQuery.setParameter(1, LocalDate.now().getMonthValue());
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioDTO> listarInicialNome (String inicial){
        Query nativeQuery = this.createNativeQuery("SELECT * FROM tab_usuario WHERE nome LIKE ?");
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
        
    }
    
}
