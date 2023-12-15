/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda.main;

import com.mycompany.gestao_venda.modelo.conexao.Conexao;
import com.mycompany.gestao_venda.modelo.conexao.ConexaoMysql;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        
        Conexao conn = new ConexaoMysql();
        
        System.out.println(conn.getConnection());
    }
}
