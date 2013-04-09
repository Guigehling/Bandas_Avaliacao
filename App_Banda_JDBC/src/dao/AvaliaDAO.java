/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;

/**
 *
 * @author Gustavo
 */
public class AvaliaDAO {

    private Connection conexao ;

    public AvaliaDAO(Connection conexao) {
        this.conexao = conexao;
    }
}
