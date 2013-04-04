/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Banda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gustavo
 */
public class BandaDAO {
    private Connection conexao;

    public BandaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Banda band) throws SQLException {
        if (this.valida(band)) {
            String sql = "INSERT INTO banda (cod,nome,biografia) VALUES (NEXTVAL('seqbanda'),?,?)";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, band.getDescricao());
            pst.setString(2, band.getLocalizacao());
            pst.executeUpdate();
            
            Statement st = this.conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT CURRVAL('seqbanda')");
//            if (rs.next()) {
//                band.setCod(rs.getInt(1));
//            }
            rs.close();
            st.close();
            pst.close();
        }
    }

    private boolean valida(Banda band) {
                boolean ret = false;
        if (band != null) {
            ret = true;
        }
        return ret;
    }
    
}
