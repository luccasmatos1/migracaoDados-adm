package service;

import dao.MovEstoqueDao;
import dao.MovPedidoDao;
import model.MovEstoque;
import model.MovPedido;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.CaminhoArquivo;
import utils.NodeListUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import  java.lang.System;


public class MovEstoqueService {


    MovEstoqueDao mvp = new MovEstoqueDao();


    public MovEstoqueService() {
    }


    public void inserirMovEstoque(){


     List<MovEstoque> mv = mvp.listarProdutosPedLiberado();
     mvp.inserirMovEstoque(mv);


    }


    public void inserirMovEstoqueEntrada()throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.MOVESTOQUE,"movimentacao_estoques");


        List<MovEstoque> mv = new ArrayList<>();
        for (var i = 0; i < nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(i);
            if (element.getElementsByTagName("estoque_tipomvto").item(0).getTextContent().equals("ENC")){

                String nf = element.getElementsByTagName("estoque_nf").item(0).getTextContent();
                //String favorecido = element.getElementsByTagName("estoque_nf").item(0).getTextContent();
                String produto = element.getElementsByTagName("produto_codigo").item(0).getTextContent();
                String data = element.getElementsByTagName("data_add").item(0).getTextContent().split(" ")[0];
                String tipo = "EC";

                String qtd = element.getElementsByTagName("estoque_qtde").item(0).getTextContent();
                String unit = element.getElementsByTagName("estoque_valor_un").item(0).getTextContent();
                String total = element.getElementsByTagName("estoque_valor_to").item(0).getTextContent();
                String empresa = "1";
                String vendedor = " ";
                String localizado = "S";



                MovEstoque movEstoque = new MovEstoque(nf,"9999",produto,data,tipo,"SEM",qtd,unit,total,empresa,vendedor,localizado);
                mv.add(movEstoque);
                mvp.inserirMovEstoque(mv);
            }


        }

        System.out.println("EXECUTADO!");


    }




}
