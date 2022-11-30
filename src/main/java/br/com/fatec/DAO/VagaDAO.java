/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import br.com.fatec.Model.Cliente;
import br.com.fatec.Model.Vaga;
import br.com.fatec.Model.Veiculo;
import br.com.fatec.persistencia.Banco;

import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Aluno
 */
public class VagaDAO implements DAO<Vaga>{

    private static java.sql.PreparedStatement stmt;

    private static java.sql.ResultSet rs;

    @Override
    public boolean insere(Vaga obj) throws SQLException {
        String sql = "INSERT INTO vaga (cod_vaga, carro_id, coberta) VALUES (?,?,?)";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setString(1, obj.getCod_vaga());
        stmt.setInt(2, obj.getCarro().getId());
        stmt.setBoolean(3, obj.isCoberta());

        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean remove(Vaga obj) throws SQLException {
        String sql = "DELETE FROM vaga WHERE id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setInt(1, obj.getCarro().getId());

        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean altera(Vaga obj) throws SQLException {
        String sql = "UPDATE vaga SET cod_vaga = ?, carro_id = ?, coberta = ? WHERE id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setString(1, obj.getCod_vaga());
        stmt.setInt(2, obj.getCarro().getId());
        stmt.setBoolean(3, obj.isCoberta());
        stmt.setInt(4, obj.getId());

        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }
    
    @Override
    public Vaga buscaID(Vaga obj) throws SQLException {
        String sql = "SELECT * FROM vaga WHERE cod_vaga = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setString(1, obj.getCod_vaga());

        rs = stmt.executeQuery();

        Vaga vaga = null;

        if(rs.next()){
            vaga = new Vaga();
            Veiculo v = new Veiculo();
            v.setId(rs.getInt("carro_id"));
            vaga.setId(rs.getInt("id"));
            vaga.setCod_vaga(rs.getString("cod_vaga"));
            vaga.setCoberta(rs.getBoolean("coberta"));
            vaga.setCarro(v);
        }

        Banco.desconectar();

        return vaga;
    }

    @Override
    public Collection<Vaga> lista(String criterio) throws SQLException {
        String sql = "SELECT * FROM vaga";

        if(criterio != null && !criterio.isEmpty()){
            sql += " WHERE " + criterio;
        }

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setString(1, criterio);

        rs = stmt.executeQuery();

        Collection<Vaga> vagas = new java.util.ArrayList<>();

        while(rs.next()){
            Vaga vaga = new Vaga();
            vaga.setCod_vaga(rs.getString("cod_vaga"));
            vaga.setCoberta(rs.getBoolean("coberta"));
            vaga.setCarro(rs.getObject("carro_id", Veiculo.class));
            vagas.add(vaga);
        }

        Banco.desconectar();

        return vagas;
    }
}
