/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import br.com.fatec.Model.Mensalidade;
import br.com.fatec.persistencia.Banco;
import java.sql.SQLException;

/**
 *
 * @author rebel
 */
public class MensalidadeDAO {
    private static java.sql.PreparedStatement stmt;

    private static java.sql.ResultSet rs;
    private Mensalidade mensalidade;
    
    public Mensalidade buscaID() throws SQLException {
        String sql = "SELECT * FROM mensalidade WHERE id = 1";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        rs = stmt.executeQuery();

        mensalidade = null;

        if(rs.next()){
            mensalidade = new Mensalidade();
            mensalidade.setId(rs.getInt("id"));
            mensalidade.setValor(rs.getDouble("valor"));
        }

        Banco.desconectar();

        return mensalidade;
    }
}
