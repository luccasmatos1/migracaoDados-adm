package dao;

import connection.ConnectionBD;
import model.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutosDao {


    public  ProdutosDao(){

    }

    public void inserirProdutos(Produtos produto){

        Connection conexao =  ConnectionBD.getConexaoMySQL();

        String sql = "insert into produtos (codigo," +
                "nome," +
                "codbarra," +
                "grupo," +
                "qtdemb," +
                "undint," +
                "undext," +
                "fornecedor," +
                "compra," +
                "custo," +
                "unit1," +
                "unit2," +
                "unit3," +
                "vlr1," +
                "vlr2," +
                "vlr3," +
                "ativo," +
                "cadastro," +
                "ncm," +
                "origem) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1,produto.getCodigo());
            stmt.setString(2,produto.getNome());
            stmt.setString(3,produto.getCodbarra());
            stmt.setString(4,produto.getGrupo());
            stmt.setString(5,produto.getQtdemb());
            stmt.setString(6,produto.getUndint());
            stmt.setString(7,produto.getUndext());
            stmt.setString(8,produto.getFornecedor());
            stmt.setDouble(9,produto.getCompra());
            stmt.setDouble(10,produto.getCusto());
            stmt.setDouble(11,produto.getUnit1());
            stmt.setDouble(12,produto.getUnit2());
            stmt.setDouble(13,produto.getUnit3());
            stmt.setDouble(14,produto.getVlr1());
            stmt.setDouble(15,produto.getVlr2());
            stmt.setDouble(16,produto.getVlr3());
            stmt.setString(17,produto.getAtivo());
            stmt.setString(18,produto.getCadastro());
            stmt.setString(19,produto.getNcm());
            stmt.setString(20,produto.getOrigem());
            stmt.execute();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


}
