/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import br.com.fatec.persistencia.Banco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import br.com.fatec.Model.Endereco;

/**
 *
 * @author rebel
 */
public class EnderecoDAO implements DAO<Endereco>{
    
     private  java.sql.PreparedStatement stmt;

    private java.sql.ResultSet rs;

    private Endereco endereco;


    @Override
    public boolean insere(Endereco obj) throws SQLException {
            String sql = "INSERT INTO endereco (cep, endereco, numero, complemento, bairro, cidade, estado, cliente_id) VALUES (?,?,?,?,?,?,?,?)";

            Banco.conectar();

            stmt = Banco.obterConexao().prepareStatement(sql);

            stmt.setString(1, obj.getCep());
            stmt.setString(2, obj.getEndereco());
            stmt.setString(3, obj.getNumero());
            stmt.setString(4, obj.getComplemento());
            stmt.setString(5, obj.getBairro());
            stmt.setString(6, obj.getCidade());
            stmt.setString(7, obj.getEstado());
            stmt.setInt(8, obj.getCliente_id());

            int res = stmt.executeUpdate();

            Banco.desconectar();

            return res != 0;
    }

    @Override
    public boolean remove(Endereco obj) throws SQLException {
        String sql = "DELETE FROM endereco WHERE cliente_id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setInt(1, obj.getCliente_id());

        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean altera(Endereco obj) throws SQLException {
        String sql = "UPDATE endereco SET cep = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ? WHERE cliente_id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setString(1, obj.getCep());
        stmt.setString (2, obj.getEndereco());
        stmt.setString(3, obj.getNumero());
        stmt.setString(4, obj.getComplemento());
        stmt.setString(5, obj.getBairro());
        stmt.setString(6, obj.getCidade());
        stmt.setString(7, obj.getEstado());
        stmt.setInt(8, obj.getCliente_id());
        
        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public Endereco buscaID(Endereco obj) throws SQLException {
        String sql = "SELECT * FROM endereco WHERE cliente_id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setInt(1, obj.getCliente_id());

        rs = stmt.executeQuery();

        if(rs.next()){
            endereco = new Endereco();
            endereco.setCep(rs.getString("cep"));
            endereco.setEndereco(rs.getString("endereco"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));
        } else {
            endereco = null;
        }

        Banco.desconectar();

        return endereco;
    }

    @Override
    public Collection<Endereco> lista(String criterio) throws SQLException {
        ArrayList<Endereco> lista = new ArrayList<>();

        String sql = "SELECT * FROM endereco";

        if(criterio != null && !criterio.isEmpty()){
            sql += " WHERE " + criterio;
        }

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        rs = stmt.executeQuery();

        while(rs.next()){
            endereco = new Endereco();
            endereco.setCep(rs.getString("cep"));
            endereco.setEndereco(rs.getString("endereco"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));
            lista.add(endereco);
        }

        Banco.desconectar();

        return lista;
    }
    
}
