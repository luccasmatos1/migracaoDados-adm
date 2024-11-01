package dao;

import connection.ConnectionBD;
import model.Fornecedores;
import model.Grupos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedoresDao {


    public FornecedoresDao(){

    }

    public void inserirFornecedores(Fornecedores forn){
        Connection conexao =  ConnectionBD.getConexaoMySQL();
        String sql = "insert into fornecedores (" +
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
                "ativo,fantasia,estado,email) " +
                " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1,forn.getCodigo());
            stmt.setString(2,forn.getTipo());
            stmt.setString(3,forn.getCnpj());
            stmt.setString(4,forn.getIe());
            stmt.setString(5,forn.getCpf());
            stmt.setString(6,forn.getNome());
            stmt.setString(7,forn.getEndereco());
            stmt.setString(8,forn.getBairro());
            stmt.setString(9,forn.getCidade());
            stmt.setString(10,forn.getCep());
            stmt.setString(11,forn.getFone1());
            stmt.setString(12,forn.getFone2());
            stmt.setString(13,forn.getCodMunicipio());
            stmt.setString(14,forn.getIndIEDest());
            stmt.setString(15,forn.getNumero());
            stmt.setString(16,forn.getAtivo());
            stmt.setString(17,forn.getAtivo());
            stmt.setString(18,forn.getEstado());
            stmt.setString(19,forn.getEmail());

            stmt.execute();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
