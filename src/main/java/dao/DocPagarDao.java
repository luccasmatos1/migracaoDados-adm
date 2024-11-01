package dao;

import connection.ConnectionBD;
import model.MovEstoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocPagarDao {


    public DocPagarDao(){

    }


    public void inserirDocPagar (String fornecedor,String tipo,String doc, String emissao, String vencimento,Double valor,String obs,String pgto,Double valorPago,String operador,String dataOperacao, String horaOperacao,String nf){
            Connection conn = ConnectionBD.getConexaoMySQL();

            try {

                PreparedStatement st = conn.prepareStatement("insert into docpagar (fornecedor,tipo,doc,emissao,vencto,valor,obs,pgto,valorpago,operador,nf,empresa,fixa,data_operacao,hora_operacao) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?s)");

                    st.setString(1,fornecedor);
                    st.setString(2,tipo);
                    st.setString(3,doc);
                    st.setString(4,emissao);
                    st.setString(5,vencimento);
                    if (valor == null){
                        valor = 0.00;
                    }
                    st.setDouble(6,valor);
                    st.setString(7,obs);
                    st.setString(8,pgto);
                if (valorPago == null){
                    valorPago = 0.00;
                }
                    st.setDouble(9,valorPago);
                    st.setString(10,operador);
                    st.setString(11, nf);
                    st.setString(12, "N");
                    st.setString(13, dataOperacao);
                    st.setString(14, horaOperacao);


                    st.execute();


                st.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


    }




    public void inserirDocReceber (String cliente,String tipo,String doc, String emissao, String vencimento,Double valor,String obs,String pgto,Double valorPago,String operador,String nf){
        Connection conn = ConnectionBD.getConexaoMySQL();

        try {

            PreparedStatement st = conn.prepareStatement("insert into docreceber (cliente,tipo,doc,emissao,vencto,valor,obs,pgto,valorpago,operador,nf,empresa) values (?,?,?,?,?,?,?,?,?,?,?,?)");

            st.setString(1,cliente);
            st.setString(2,tipo);
            st.setString(3,doc);
            st.setString(4,emissao);
            st.setString(5,vencimento);
            if (valor == null){
                valor = 0.00;
            }
            st.setDouble(6,valor);
            st.setString(7,obs);
            st.setString(8,pgto);
            if (valorPago == null){
                valorPago = 0.00;
            }
            st.setDouble(9,valorPago);
            st.setString(10,operador);

            st.setString(11, nf);
            st.setString(12, "1");

            st.execute();


            st.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
