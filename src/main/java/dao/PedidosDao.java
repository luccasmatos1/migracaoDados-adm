package dao;

import connection.ConnectionBD;
import model.Grupos;
import model.Pedidos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidosDao {


    public PedidosDao(){

    }

    public void inserirPedidos(Pedidos pedido){
        Connection conexao =  ConnectionBD.getConexaoMySQL();
        String sql = "insert into pedidos (pedido," +
                "local, " +
                "tabela, " +
                "itens, " +
                "subtotal, " +
                "desconto, " +
                "total, " +
                "cliente, " +
                "vendedor, " +
                "parcelas, " +
                "prazo, " +
                "intervalo, " +
                "vencto, " +
                "liberacao, " +
                "empresa, " +
                "digitado, " +
                "tipo, " +
                "liberado, " +
                "formapagto, " +
                "hrLiberacao, " +
                "data,nf,cancelado) " +
                " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1,pedido.getPedido());
            stmt.setString(2,pedido.getLocal());
            stmt.setString(3,pedido.getTabela());
            stmt.setInt(4,pedido.getItens());
            stmt.setDouble(5,pedido.getSubtotal());
            stmt.setDouble(6,pedido.getDesconto());
            stmt.setDouble(7,pedido.getTotal());
            stmt.setString(8,pedido.getCliente());
            stmt.setString(9,pedido.getVendedor());
            stmt.setString(10,pedido.getParcelas());
            stmt.setString(11,pedido.getPrazo());
            stmt.setString(12,pedido.getIntervalo());
            stmt.setString(13,pedido.getVencto());
            stmt.setString(14,pedido.getLiberacao());
            stmt.setString(15,pedido.getEmpresa());
            stmt.setString(16,pedido.getDigitado());
            stmt.setString(17,pedido.getTipo());
            stmt.setString(18,pedido.getLiberado());
            stmt.setString(19,pedido.getFormapgto());
            stmt.setString(20,pedido.getHrLiberacao());
            stmt.setString(21,pedido.getDataDigitacao());
            stmt.setString(22,pedido.getNf());
            stmt.setString(23,pedido.getCancelado());

            stmt.execute();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
