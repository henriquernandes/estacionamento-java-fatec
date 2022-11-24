package br.com.fatec.DAO;

import java.sql.SQLException;
import br.com.fatec.persistencia.Banco;
import br.com.fatec.Model.Cliente;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Aluno
 */
public class ClienteDAO implements DAO<Cliente> {
    private  java.sql.PreparedStatement stmt;

    private java.sql.ResultSet rs;

    private Cliente cliente;


    @Override
    public boolean insere(Cliente obj) throws SQLException {
            String sql = "INSERT INTO cliente (nome, endereco, telefone, mensalista) VALUES (?,?,?,?)";

            Banco.conectar();

            stmt = Banco.obterConexao().prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString (2, obj.getEndereco());
            stmt.setString(3, obj.getTelefone());
            stmt.setBoolean(4, obj.isMensalista());

            int res = stmt.executeUpdate();

            Banco.desconectar();

            return res != 0;
    }

    @Override
    public boolean remove(Cliente obj) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setInt(1, obj.getId());

        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean altera(Cliente obj) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ?, mensalista = ? WHERE id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setString(1, obj.getNome());
        stmt.setString (2, obj.getEndereco());
        stmt.setString(3, obj.getTelefone());
        stmt.setBoolean(4, obj.isMensalista());
        stmt.setInt(5, obj.getId());

        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public Cliente buscaID(Cliente obj) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setInt(1, obj.getId());

        rs = stmt.executeQuery();

        if(rs.next()){
            cliente = new Cliente();
            cliente.setNome(rs.getString("nome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setMensalista(rs.getBoolean("mensalista"));
        } else {
            cliente = null;
        }

        Banco.desconectar();

        return cliente;
    }

    @Override
    public Collection<Cliente> lista(String criterio) throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        if(criterio != null && !criterio.isEmpty()){
            sql += " WHERE " + criterio;
        }

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        rs = stmt.executeQuery();

        while(rs.next()){
            cliente = new Cliente();
            cliente.setNome(rs.getString("nome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setMensalista(rs.getBoolean("mensalista"));
            lista.add(cliente);
        }

        Banco.desconectar();

        return lista;
    }
}
