package dao;

import connection.ConnectionBD;
import model.Clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientesDao {


    public ClientesDao(){

    }

    public void inserirClientes(Clientes cli){
        Connection conexao =  ConnectionBD.getConexaoMySQL();
        String sql = "insert into clientes (" +
                "codigo," +
                "tipo," +
                "cnpj," +
                "ie, " +
                "cpf, " +
                "nome, " +
                "endereco, " +
                "bairro, " +
                "cidade, " +
                "cep, " +
                "fone1, " +
                "fone2, " +
                "codMunicipio, " +
                "indIEDest, " +
                "numero, " +
                "ativo,fantasia,estado,email,telefone1,telefone2,consfinal) " +
                " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1,cli.getCodigo());
            stmt.setString(2,cli.getTipo());
            stmt.setString(3,cli.getCnpj());
            stmt.setString(4,cli.getIe());
            stmt.setString(5,cli.getCpf());
            stmt.setString(6,cli.getNome());
            stmt.setString(7,cli.getEndereco());
            stmt.setString(8,cli.getBairro());
            stmt.setString(9,cli.getCidade());
            stmt.setString(10,cli.getCep());
            stmt.setString(11,cli.getFone1());
            stmt.setString(12,cli.getFone2());
            stmt.setString(13,cli.getCodMunicipio());
            stmt.setString(14,cli.getIndIEDest());
            stmt.setString(15,cli.getNumero());
            stmt.setString(16,cli.getAtivo());
            stmt.setString(17,cli.getAtivo());
            stmt.setString(18,cli.getEstado());
            stmt.setString(19,cli.getEmail());
            stmt.setString(20,cli.getTelefone1());
            stmt.setString(21,cli.getTelefone2());
            stmt.setString(22,cli.getConsumidorFinal());

            stmt.execute();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
