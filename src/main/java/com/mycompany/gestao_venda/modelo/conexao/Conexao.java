/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestao_venda.modelo.conexao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public interface Conexao {
    public Connection getConnection() throws SQLException;
}
