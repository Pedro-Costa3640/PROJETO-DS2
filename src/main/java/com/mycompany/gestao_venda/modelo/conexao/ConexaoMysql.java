/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda.modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class ConexaoMysql implements Conexao {

    private final String USUARIO = "root";
    private final String SENHA = "";
    private final String URL = "jdbc:mysql://localhost:3306/gestao_venda";
    private Connection conn;
    
    @Override
    public Connection getConnection() throws SQLException {
        if(conn == null) {
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        
        return conn;
    };
    
}
