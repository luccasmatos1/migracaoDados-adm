package dao;

import connection.ConnectionBD;
import model.MovEstoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovEstoqueDao {


    public MovEstoqueDao(){

    }

    public List<MovEstoque> listarProdutosPedLiberado(){
        Connection conn = ConnectionBD.getConexaoMySQL();

        List<MovEstoque> mv = new ArrayList<>();
        String sql = "select " +
                "p.nf," +
                "p.cliente," +
                "mp.produto," +
                "p.data," +
                "p.tipo," +
                "mp.und," +
                "mp.qtd," +
                "mp.unit," +
                "mp.total," +
                "p.empresa," +
                "p.vendedor," +
                "'S' as localizado from pedidos p inner join movpedido mp on p.pedido = mp.venda where p.nf is not null or p.nf <> ''";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()){
               String nf =  rs.getString("nf");
               String cliente =  rs.getString("cliente");
               String produto = rs.getString("produto");
               String data =  rs.getString("data");
               String tipo =  rs.getString("tipo");
               String und = rs.getString("und");
               String qtd =  rs.getString("qtd");
               String unit =  rs.getString("unit");
               String total =  rs.getString("total");
               String empresa =  rs.getString("empresa");
               String vendedor =  rs.getString("vendedor");
               String localizado = rs.getString("localizado");
               MovEstoque movEstoque = new MovEstoque(nf,cliente,produto,data,tipo,und,qtd,unit,total,empresa,vendedor,localizado);
               mv.add(movEstoque);
            }

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mv;
    }


    public void inserirMovEstoque (List<MovEstoque> mov){
            Connection conn = ConnectionBD.getConexaoMySQL();

            try {
                listarProdutosPedLiberado();
                PreparedStatement st = conn.prepareStatement("insert into movestoque (documento,favorecido,produto,data,tipomov,und,qtd,vlrunit,vlrtotal,empresa,vendedor,localizado) values (?,?,?,?,?,?,?,?,?,?,?,?)");

                for (int i = 0; i < mov.size() ; i++) {
                    st.setString(1,mov.get(i).getDocumento());
                    st.setString(2,mov.get(i).getFavorecido());
                    st.setString(3,mov.get(i).getProduto());
                    st.setString(4,mov.get(i).getData());
                    st.setString(5,mov.get(i).getTipoMov());
                    st.setString(6,mov.get(i).getUnd());
                    st.setString(7,mov.get(i).getQtd());
                    st.setString(8,mov.get(i).getVlrUnit());
                    st.setString(9,mov.get(i).getVlrTotal());
                    st.setString(10,mov.get(i).getEmpresa());
                    st.setString(11,mov.get(i).getVendedor());
                    st.setString(12,mov.get(i).getLocalizado());

                    st.execute();
                }


                st.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


    }

}
