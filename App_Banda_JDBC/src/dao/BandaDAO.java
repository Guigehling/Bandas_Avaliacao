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
import java.util.ArrayList;
import java.util.List;

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
            pst.setString(1, band.getNome());
            pst.setString(2, band.getBiografia());
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

    public List<Banda> listaTodos() throws SQLException {
        List<Banda> lista = new ArrayList<Banda>();
        String sql = "SELECT cod,nome,biografia FROM banda ORDER BY COD";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Banda band = new Banda(rs.getInt("COD"), rs.getString("nome"), rs.getString("biografia"));
            lista.add(band);
        }
        rs.close();
        st.close();
        return lista;
    }

    public Banda retrieve(Banda band) throws SQLException {
        Banda bandRet = null;
        String sql = "SELECT COD,nome,biografia FROM banda WHERE COD=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, band.getCod());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            bandRet = new Banda();
            bandRet.setCod(rs.getInt("cod"));
            bandRet.setNome(rs.getString("nome"));
            bandRet.setBiografia(rs.getString("biografia"));
        }
        rs.close();
        pst.close();
        return bandRet;
    }
}
