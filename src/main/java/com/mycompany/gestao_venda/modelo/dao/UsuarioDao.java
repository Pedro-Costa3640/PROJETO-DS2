/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda.modelo.dao;

import com.mycompany.gestao_venda.modelo.conexao.Conexao;
import com.mycompany.gestao_venda.modelo.conexao.ConexaoMysql;
import com.mycompany.gestao_venda.modelo.dominio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class UsuarioDao {
    
    private final Conexao conn;
    
    public UsuarioDao() {
        this.conn = new ConexaoMysql();
    }
    
    public String salvar(Usuario usuario) {
        return usuario.getId() == 0 ? adicionar(usuario) : editar(usuario);
    }

    private String adicionar(Usuario usuario) {
        String sql = "INSERT INTO tb_usuarios(nome, usuario, senha) VALUES (?, ?, ?)";
        
        Usuario usuarioTemporario = buscarUsuarioPorUser(usuario.getUsuario());
        
        if(usuarioTemporario != null) {
            return String.format("Erro: usuário %s já existe no sistema", usuario.getUsuario());
        }
        
        try {
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            
            fillValuesPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Usuário adicionado com sucesso" : "Erro ao adicionar usuário";
        } catch (SQLException e) {
            return String.format("Erro: %s", e.getMessage());
        }
    }

    private String editar(Usuario usuario) {
        String sql = "UPDATE tb_usuarios SET nome = ?, usuario = ?, senha = ? WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            
            fillValuesPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Usuário editado com sucesso" : "Erro ao editar usuário";
        } catch (SQLException e) {
            return String.format("Erro: %s", e.getMessage());
        }
    }

    private void fillValuesPreparedStatement(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getUsuario());
        preparedStatement.setString(3, usuario.getSenha());
        
        
        if(usuario.getId() != 0) {
            preparedStatement.setInt(4, usuario.getId());
        } else {
        }
    }
    
    public List<Usuario> buscarTodosUsuarios() {
        String sql = "SELECT * FROM tb_usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet resultSet = conn.getConnection().prepareCall(sql).executeQuery();
            
            while(resultSet.next()) {
                usuarios.add(getUsuario(resultSet));                
            }
        } catch (SQLException e) {
            System.out.println(String.format("Erro: ", e.getMessage()));
        }
        
        return usuarios;
    }
     
    private Usuario getUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        
        usuario.setId(resultSet.getInt("id"));
        usuario.setNome(resultSet.getString("nome"));
        usuario.setUsuario(resultSet.getString("usuario"));
        usuario.setSenha(resultSet.getString("senha"));
        usuario.setData_hora_criacao(resultSet.getObject("data_hora_criacao", LocalDateTime.class));
        usuario.setUltimoLogin(resultSet.getObject("ultimo_login", LocalDateTime.class));
        return usuario;
    }
    
    public Usuario buscarUsuarioPorId(int id) {
        String sql = String.format("SELECT * FROM tb_usuarios WHERE id = %d", id);
        
        try {
            ResultSet resultSet = conn.getConnection().prepareCall(sql).executeQuery();
            
            while(resultSet.next()) {
                return getUsuario(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Erro: ", e.getMessage()));
        }
        
        return null;
    }
    
    public Usuario buscarUsuarioPorUser(String usuario) {
        String sql = String.format("SELECT * FROM tb_usuarios WHERE id = %d", usuario);
        
        try {
            ResultSet resultSet = conn.getConnection().prepareCall(sql).executeQuery();
            
            while(resultSet.next()) {
                return getUsuario(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Erro: ", e.getMessage()));
        }
        
        return null;
    }
}
