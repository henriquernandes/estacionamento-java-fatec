package br.com.fatec.DAO;

import br.com.fatec.Model.Cliente;
import java.sql.SQLException;

import br.com.fatec.Model.Veiculo;
import br.com.fatec.persistencia.Banco;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Aluno
 */
public class VeiculoDAO implements DAO<Veiculo> {
    private  java.sql.PreparedStatement stmt;

    private java.sql.ResultSet rs;

    private Veiculo veiculo;

    @Override
    public boolean insere(Veiculo obj) throws SQLException {
        String sql = "INSERT INTO carro (modelo, marca, ano, placa, cliente_id) VALUES (?,?,?,?,?)";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setString(1, obj.getModelo());
        stmt.setString (2, obj.getMarca());
        stmt.setString(3, obj.getAno());
        stmt.setString(4, obj.getPlaca());
        stmt.setInt(5, obj.getCliente().getId());

        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean remove(Veiculo obj) throws SQLException {
        String sql = "DELETE FROM carro WHERE id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setInt(1, obj.getId());

        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean altera(Veiculo obj) throws SQLException {
        String sql = "UPDATE carro SET modelo = ?, marca = ?, ano = ?, placa = ?, cliente_id = ? WHERE id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setString(1, obj.getModelo());
        stmt.setString (2, obj.getMarca());
        stmt.setString(3, obj.getAno());
        stmt.setString(4, obj.getPlaca());
        stmt.setInt(5, obj.getCliente().getId());
        stmt.setInt(6, obj.getId());

        int res = stmt.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public Veiculo buscaID(Veiculo obj) throws SQLException {
        String sql = "SELECT * FROM carro inner join cliente on carro.cliente_id = cliente.id  WHERE carro.placa = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setString(1, obj.getPlaca());

        rs = stmt.executeQuery();

        veiculo = null;

        if (rs.next()) {
            veiculo = new Veiculo();
            Cliente c = new Cliente();
            c.setId(rs.getInt("cliente_id"));
            c.setNome(rs.getString("cliente_id"));
            c.setEndereco(rs.getString("endereco"));
            c.setTelefone(rs.getString("telefone"));
            c.setMensalista(rs.getBoolean("mensalista"));
            veiculo.setId(rs.getInt("id"));
            veiculo.setModelo(rs.getString("modelo"));
            veiculo.setMarca(rs.getString("marca"));
            veiculo.setAno(rs.getString("ano"));
            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setCliente(c);
        }

        Banco.desconectar();

        return veiculo;
    }
    
    public Veiculo buscaByID(Veiculo obj) throws SQLException {
        String sql = "SELECT * FROM carro WHERE id = ?";

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        stmt.setInt(1, obj.getId());

        rs = stmt.executeQuery();

        veiculo = null;

        if (rs.next()) {
            veiculo = new Veiculo();
            veiculo.setId(rs.getInt("id"));
            veiculo.setModelo(rs.getString("modelo"));
            veiculo.setMarca(rs.getString("marca"));
            veiculo.setAno(rs.getString("ano"));
            veiculo.setPlaca(rs.getString("placa"));
        }

        Banco.desconectar();

        return veiculo;
    }

    @Override
    public Collection<Veiculo> lista(String criterio) throws SQLException {
        String sql = "SELECT * FROM carro";

        if(criterio != null && !criterio.isEmpty()){
            sql += " WHERE " + criterio;
        }

        Banco.conectar();

        stmt = Banco.obterConexao().prepareStatement(sql);

        rs = stmt.executeQuery();

        Collection<Veiculo> veiculos = new ArrayList<>();

        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("cliente_id"));
            veiculo = new Veiculo();
            veiculo.setId(rs.getInt("id"));
            veiculo.setModelo(rs.getString("modelo"));
            veiculo.setMarca(rs.getString("marca"));
            veiculo.setAno(rs.getString("ano"));
            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setCliente(c);

            veiculos.add(veiculo);
        }

        Banco.desconectar();

        return veiculos;
    }
}
