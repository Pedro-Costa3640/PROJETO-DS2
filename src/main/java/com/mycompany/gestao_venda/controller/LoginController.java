/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda.controller;

import com.mycompany.gestao_venda.modelo.dominio.Usuario;
import com.mycompany.gestao_venda.view.formulario.Login;
import com.mycompany.gestao_venda.view.modelo.LoginDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author guilh
 */
public class LoginController implements ActionListener{
    private final Login login;
    
    public LoginController(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acao = e.getActionCommand().toLowerCase();
        
        switch(acao) {
            case "login": login(); break;
            case "cancelar": cancelar(); break;
        }
    }

    private void login() {
        String usuario = this.login.getTxtLoginUsuario().getText();
        String senha = this.login.getTxtLoginSenha().getText();
        
        if (usuario.equals("") || senha.equals("")) {
            this.login.getLabelLoginMensagem().setText("Usuário e senha devem ser preenchidos");
        }
        
        LoginDto loginDto = new LoginDto(usuario, senha);
                
                
    }

    private void cancelar() {
        
    }
    
    
}
