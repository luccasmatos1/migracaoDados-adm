package application;


import connection.ConnectionBD;
import dao.TruncateTables;
import service.*;
import utils.CaminhoArquivo;
import utils.Propriedades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class app {
    public static void main(String[] args) throws Exception {


        TruncateTables trunc = new TruncateTables();
        DocReceberService docReceberService = new DocReceberService();
        DocPagarService docPagarService = new DocPagarService();
        ProdutosService produtosService = new ProdutosService();
        GruposService gruposServic = new GruposService();
        ClientesService clientesService = new ClientesService();
        FornecedoresService fornecedoresService = new FornecedoresService();
        PedidosService pedidosService = new PedidosService();
        MovPedidoService movPedidoService = new MovPedidoService();
        NfeService nfeService = new NfeService();
        MovEstoqueService movEstoqueService = new MovEstoqueService();


        System.out.println("---INICIANDO APLICAÇÃO---");

        System.out.println("\nTESTANDO CONEXÃO COM O BANCO...");

        Connection conn = ConnectionBD.getConexaoMySQL();

        if (conn != null){
            System.out.println("CONEXÃO REALIZADA COM SUCESSO");
        } else {
            System.out.println("ERRO NA CONEXÃO");
        }
        conn.close();

        System.out.println("\nVERIFICANDO DIRETORIO DOS ARQUIVOS XMLs");

        if (!Propriedades.lerCaminhoArquivoMigracao().isEmpty()){
            System.out.println("DIRETORIO LOCALIZADO!");
        }


        System.out.println("\n ---PREPARANDO PARA INICIAR A MIGRAÇÃO---");

        System.out.println("TRUNCANDO TABELAS QUE SERÃO MIGRADAS");
        trunc.TruncarTabelas();

        System.out.println("\nMIGRANDO PRODUTOS, AGUARDE...");
        produtosService.produtosXML();

        System.out.println("\nMIGRANDO GRUPOS, AGUARDE...");
        gruposServic.gruposXML();

        System.out.println("\nMIGRANDO FORNECEDORES, AGUARDE...");
        fornecedoresService.salvarFornecedores();

        System.out.println("\nMIGRANDO CLIENTES, AGUARDE...");
        clientesService.inserirClientes();

        System.out.println("\nMIGRANDO PEDIDOS, AGUARDE...");
        pedidosService.inserirPedidos();

        System.out.println("\nMIGRANDO MOVPEDIDO, AGUARDE...");
        movPedidoService.inserirItensPedido();

        System.out.println("\nMIGRANDO NF, AGUARDE...");
        nfeService.inserirNfEntrada();
        nfeService.inserirNfeSaida();

        System.out.println("\nMIGRANDO MOVESTOQUE, AGUARDE...");
        movEstoqueService.inserirMovEstoque();
        movEstoqueService.inserirMovEstoqueEntrada();

        System.out.println("\nMIGRANDO DOC PAGAR, AGUARDE...");
        docPagarService.inserirDocPagar();

        System.out.println("\nMIGRANDO DOC RECEBER, AGUARDE...");
        docReceberService.inserirDocReceber();


        System.out.println("\n\nMIGRAÇÃO FINALIZADA COM SUCESSO!");


        System.out.println(CaminhoArquivo.nomeArquivo("_cad_produtos"));




    }



}