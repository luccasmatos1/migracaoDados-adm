package service;

import dao.MovPedidoDao;
import dao.PedidosDao;
import model.MovPedido;
import model.Pedidos;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.CaminhoArquivo;
import utils.NodeListUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class MovPedidoService {


    MovPedidoDao mvp = new MovPedidoDao();
    public MovPedidoService() {
    }
    DecimalFormat df = new DecimalFormat("#.##");

    public void inserirItensPedido() throws Exception {



        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.MOV_PEDIDOS,"movimentacao_detalhes");


        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            if (element.getElementsByTagName("movi_tipo").item(0).getTextContent().equals("P")){

                String venda = element.getElementsByTagName("movi_codigo").item(0).getTextContent();
                String seq = element.getElementsByTagName("movi_sequencia").item(0).getTextContent();
                String prod = element.getElementsByTagName("movi_item").item(0).getTextContent();
                String und = buscarUndProduto(prod);
                String qtd = element.getElementsByTagName("movi_qtde").item(0).getTextContent().replace(",",".");
                String unit = element.getElementsByTagName("movi_valor").item(0).getTextContent().replace(",",".");
                String descv = element.getElementsByTagName("movi_desconto").item(0).getTextContent().replace(",",".");
                String total = element.getElementsByTagName("movi_total").item(0).getTextContent().replace(",",".");
                String nomeProd = buscarNomeProduto(prod);
                String local = "1";
                String tabela = "1";

                mvp.inserirMovPedido(new MovPedido(venda,
                        seq,
                        prod,
                        und,
                        Double.valueOf(df.format(Double.valueOf(qtd)).replace(",",".")),
                        Double.valueOf(df.format(Double.valueOf(unit)).replace(",",".")),
                        Double.valueOf(df.format(Double.valueOf(descv)).replace(",",".")),
                        Double.valueOf(df.format(Double.valueOf(total)).replace(",",".")),
                        nomeProd,
                        local,
                        tabela)
                );

            }





        }

        System.out.println("EXECUTADO!");

    }



    public  String buscarNomeProduto (String codProduto) throws Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.PRODUTOS,"cad_produtos");

        String nome = null;

        for (int i = 0; i < nodeList.getLength() && nome == null ; i++){
            Element element = (Element) nodeList.item(i);
            if (codProduto.equals(element.getElementsByTagName("produto_codigo").item(0).getTextContent())){
            nome = element.getElementsByTagName("produto_descricao").item(0).getTextContent();
            }

        }

        return nome;
    }



    public  String buscarUndProduto (String codProduto) throws Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.PRODUTOS_UNIDADE,"cad_produtos_ecf");

        String nome = null;

        while (nome == null){
            for (int i = 0; i < nodeList.getLength()  ; i++){
                Element element = (Element) nodeList.item(i);
                if (codProduto.equals(element.getElementsByTagName("produto_codigo").item(0).getTextContent())){
                    nome = element.getElementsByTagName("produto_medida").item(0).getTextContent();
                }

            }

            if (nome == null) {
                nome = "UND";
            }
        }



        return nome;
    }





}
