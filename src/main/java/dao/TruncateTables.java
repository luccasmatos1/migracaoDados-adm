package dao;

import connection.ConnectionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TruncateTables {



    public TruncateTables(){

    }
    public void TruncarTabelas(){

        Connection conn = ConnectionBD.getConexaoMySQL();

        String[] tables = {"TRUNCATE TABLE PEDIDOS",
                "TRUNCATE TABLE MOVPEDIDO",
                "TRUNCATE TABLE CLIENTES" ,
                "TRUNCATE TABLE FORNECEDORES",
                "TRUNCATE TABLE PRODUTOS" ,
                "TRUNCATE TABLE MOVESTOQUE",
                "TRUNCATE TABLE NF",
                "TRUNCATE TABLE DOCPAGAR",
                "TRUNCATE TABLE DOCRECEBER",
                "TRUNCATE TABLE GRUPOS"
        };


        try{
            for (int i = 0; i < tables.length ; i++){
                PreparedStatement stmt = conn.prepareStatement(tables[i]);
                stmt.execute();
                stmt.close();
            }


            System.out.println("TABELAS TRUNCADAS...");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
