
//Classes necessárias para uso de Banco de dados //
package connection;

import utils.Propriedades;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;


public class ConnectionBD {

    public static String status = "Não conectou...";







    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;

        String server = null;
        String porta = null;
        String banco = null;
        String user =  null;
        String senha = null;

        try {
            Properties props = Propriedades.getProp();
             server = props.getProperty("server");
             porta = props.getProperty("porta");
             banco = props.getProperty("banco");
             user = props.getProperty("user");
             senha = props.getProperty("senha");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            //nome do seu banco de dados

            String url = "jdbc:mysql://"+ server + ":" + porta + "/" + banco +"?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
            //sua senha de acesso

            connection = DriverManager.getConnection(url, user, senha);




            return connection;



        } catch (ClassNotFoundException e) {  //Driver não encontrado

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }



    }


    public static String statusConection() {

        return status;

    }



    public static boolean FecharConexao() {

        try {

            ConnectionBD.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }



    }




    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();
        return ConnectionBD.getConexaoMySQL();

    }

}

