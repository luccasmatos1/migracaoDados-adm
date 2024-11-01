package dao;

import connection.ConnectionBD;
import model.Grupos;
import model.MovPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovPedidoDao {


    public MovPedidoDao(){

    }

    public void inserirMovPedido(MovPedido mvp){
        Connection conexao =  ConnectionBD.getConexaoMySQL();
        String sql = "insert into movpedido (venda," +
                "seq, " +
                "produto, " +
                "und, " +
                "qtd, " +
                "unit, " +
                "descv, " +
                "total, " +
                "nomeProduto, " +
                "local, " +
                "tabela) " +
                " values (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1,mvp.getVenda());
            stmt.setString(2,mvp.getSeq());
            stmt.setString(3,mvp.getProd());
            stmt.setString(4,mvp.getUnd());
            stmt.setDouble(5,mvp.getQtd());
            stmt.setDouble(6,mvp.getUnit());
            stmt.setDouble(7,mvp.getDescv());
            stmt.setDouble(8,mvp.getTotal());
            stmt.setString(9,mvp.getNomeProduto());
            stmt.setString(10,mvp.getLocal());
            stmt.setString(11,mvp.getTabela());
            stmt.execute();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }






}
