package dao;

import connection.ConnectionBD;
import model.Grupos;
import model.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GruposDao {


    public GruposDao(){

    }

    public void inserirGrupos(Grupos grupo){
        Connection conexao =  ConnectionBD.getConexaoMySQL();
        String sql = "insert into grupos (codigo," +
                "descricao) " +
                " values (?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1,grupo.getCodigo());
            stmt.setString(2,grupo.getNome());
            stmt.execute();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void inserirGrupoPrincipal (){
        Connection connection = ConnectionBD.getConexaoMySQL();
        String sql = "insert into grupos (codigo,descricao) values (?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,"01");
            stmt.setString(2,"AKI LIMPA");
            stmt.execute();
            stmt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
