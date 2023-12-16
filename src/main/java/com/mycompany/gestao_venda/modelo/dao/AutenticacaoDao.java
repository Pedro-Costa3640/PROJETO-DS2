/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda.modelo.dao;

import com.mycompany.gestao_venda.modelo.dominio.Usuario;
import com.mycompany.gestao_venda.view.modelo.LoginDto;

/**
 *
 * @author guilh
 */
public class AutenticacaoDao {
    private final UsuarioDao usuarioDao;
    
    public AutenticacaoDao() {
        this.usuarioDao = new UsuarioDao();
    }
    
    public Usuario login(LoginDto login) {
        Usuario usuario = usuarioDao.buscarUsuarioPorUser(login.getUsuario());
        
        if(usuario == null)
            return null;
        
        if(validarSenha(usuario.getSenha(), login.getSenha())) {
            return usuario;
        }
        
        return null;
    }

    private boolean validarSenha(String senhaUsuario, String senhaLogin) {
        return senhaUsuario.equals(senhaLogin);
    }
}
