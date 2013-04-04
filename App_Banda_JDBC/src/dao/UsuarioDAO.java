/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Usuario retrieve(String login) throws SQLException {
        Usuario usrDept = new Usuario();
        String sql = "SELECT COD,LOGIN,SENHA FROM USUARIO WHERE LOGIN=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setString(1, login);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            usrDept.setCod(rs.getInt("COD"));
            usrDept.setLogin(rs.getString("LOGIN"));
            usrDept.setSenha(rs.getString("SENHA"));
        }
        rs.close();
        pst.close();
        return usrDept;
    }
}
