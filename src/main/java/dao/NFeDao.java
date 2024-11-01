package dao;

import connection.ConnectionBD;
import model.MovPedido;
import model.NfeModel;
import model.NfeSaida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NFeDao {


    public NFeDao(){

    }

    public void inserirNfsEntrada(NfeModel nfe){
        Connection conexao =  ConnectionBD.getConexaoMySQL();
        String sql = "insert into nf (id_nf," +
                "documento, " +
                "favorecido, " +
                "emissao, " +
                "recepcao, " +
                "vlrcontabil, " +
                "basecalculo, " +
                "vlricms, " +
                "totalprodutos, " +
                "protocolonfe, " +
                "idnfe,empresa,tipo,serie,cfop,cancelada,motinutnfe,nfe) " +
                " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1,nfe.getNfId());
            stmt.setString(2,nfe.getDocumento());
            stmt.setString(3,nfe.getFavorecido());
            stmt.setString(4,nfe.getEmissao());
            stmt.setString(5,nfe.getRecepcao());
            stmt.setString(6,nfe.getVlrContabil());
            stmt.setString(7,nfe.getBaseCauculo());
            stmt.setString(8,nfe.getvIcms());
            stmt.setString(9,nfe.getvProd());
            stmt.setString(10,nfe.getNfceProtocolo());
            stmt.setString(11,nfe.getNfeChave());
            stmt.setString(12,"1"); //empresa
            stmt.setString(13,"E"); // tipo
            stmt.setString(14,"1"); // serie
            stmt.setString(15,"1102"); //cfop
            stmt.setString(16,"N"); //cancelada
            stmt.setString(17,"55"); //motinutnfe
            stmt.setString(18,"S"); //nfe
            stmt.execute();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





    public void inserirNfSaida(NfeSaida nfe){
        Connection conexao =  ConnectionBD.getConexaoMySQL();
        String sql = "insert into nf (documento, "  +
                "favorecido, " +
                "serie, " +
                "ambiente, " +
                "idnfe, " +
                "ProtocoloNFe, " +
                "ReciboNFe, " +
                "statusNFe, " +
                "emissao, " +
                "recepcao, " +
                "baseCalculo, " +
                "vlrContabil, " +
                "totalProdutos, " +
                "xmlAssinada, " +
                "empresa, " +
                "tipo, " +
                "cancelada, " +
                "motinutnfe, " +
                "nfe) " +
                " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1,nfe.getDocumento());
            stmt.setString(2,nfe.getFavorecido());
            stmt.setString(3,nfe.getSerie());
            stmt.setString(4,nfe.getAmbiente());
            stmt.setString(5,nfe.getNfeChave());
            stmt.setString(6,nfe.getNfceProtocolo());
            stmt.setString(7,nfe.getNfeRecibo());
            stmt.setString(8,nfe.getNfeStatus());
            stmt.setString(9,nfe.getEmissao());
            stmt.setString(10,nfe.getRecepcao());
            stmt.setString(11,nfe.getBaseCalculo());
            stmt.setString(12,nfe.getVlrContabil());
            stmt.setString(13,nfe.getTotalProdutos());
            stmt.setString(14,nfe.getXmlAssinada());
            stmt.setString(15,"1"); //empresa
            stmt.setString(16,"S"); // tipo
            stmt.setString(17,"N"); //cancelada
            stmt.setString(18,"55"); //motinutnfe
            stmt.setString(19,"S"); //nfe
            stmt.execute();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public int existeNfEntrada (String nf){
        Connection conn = ConnectionBD.getConexaoMySQL();
        String sql = "select count(documento) from nf where documento = ? and tipo = 'E' group by documento ";
        int n = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"'" +  nf + "'");
            ResultSet rs = stmt.executeQuery();


            while (rs.next()){
              n++;

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return n;
    }






}
