package service;

import dao.GruposDao;
import dao.PedidosDao;
import model.Grupos;
import model.Pedidos;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.CaminhoArquivo;
import utils.NodeListUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class PedidosService {


    PedidosDao pedidosDao = new PedidosDao();
    public PedidosService() {
    }
    DecimalFormat df = new DecimalFormat("#.##");

    public void inserirPedidos() throws Exception {



        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.PEDIDOS,"movimentacao");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);


            String pedido = element.getElementsByTagName("movi_codigo").item(0).getTextContent();
            String tabela = element.getElementsByTagName("movi_tabela_preco").item(0).getTextContent();

            switch (tabela){
                case "223":
                    tabela = "2";
                    break;
                case "224":
                    tabela = "3";
                default:
                    tabela = "1";
                    break;
            }

            Integer itens = buscarQtdItens(pedido);

            Double subTotal = buscarSubTotal(pedido);
            String desconto = element.getElementsByTagName("movi_desconto").item(0).getTextContent();
            String vTotal = element.getElementsByTagName("movi_valor").item(0).getTextContent();
            String cliente = element.getElementsByTagName("movi_cliente").item(0).getTextContent();
            String vendedor = buscarVendedor(pedido);            //verificar a possibilidade de colocar comisao aqui
            String parcelas = element.getElementsByTagName("movi_qtdepgto").item(0).getTextContent();
            String vencto = element.getElementsByTagName("movi_cobranca").item(0).getTextContent();
            String nf = element.getElementsByTagName("movi_nfe_numero").item(0).getTextContent();


            if ((nf.isEmpty() && !buscarNF().contains(nf)) || nf.equals("0")){
                nf = "P" + pedido;
            }


            String empresa = "1";
            String digitado = "MIGRACAO";
            String movTipo = element.getElementsByTagName("movi_natop").item(0).getTextContent();

            switch (movTipo) {
                case "SAIDA BONIFICADA":
                    movTipo = "SB";
                break;
                case  "SAIDA POR DEVOLUCAO":
                    movTipo = "SD";
                    break;
                case "SAIDA POR COMODATO":
                    movTipo = "SC";
                    break;

                default:
                    movTipo = "SV";
                    break;
            }
            String liberacao = element.getElementsByTagName("movi_data_saida").item(0).getTextContent();
            String sts = element.getElementsByTagName("movi_tipo").item(0).getTextContent();
            String cancelado = sts.equals("CANCELADO") ? "S" : "N";
            String hrLiberacao = null;
            if (!liberacao.isEmpty()){
               hrLiberacao = liberacao.substring(12,16);
            }
            String dataDigitacao = element.getElementsByTagName("movi_datahora").item(0).getTextContent().split(" ")[0];
            String dataLiberacao = !liberacao.isEmpty() ? liberacao.split(" ")[0] : null;
            String liberado = digitado;

            if (liberacao.isEmpty() || cancelado.equals("S")){
                nf = null;
                liberado = null;
                dataLiberacao = null;
                hrLiberacao = null;

            }

            String formaPgto = element.getElementsByTagName("movi_datahora").item(0).getTextContent();

            switch (formaPgto){
                case "0":
                    formaPgto = "OU";
                    break;
                case "2":
                    formaPgto = "FD";
                    break;
                case "4":
                    formaPgto = "BL";
                    break;
                case "69":
                    formaPgto = "TF";
                    break;
                case "70":
                    formaPgto= "TF";
                    break;
                case "10530":
                    formaPgto = "PX";
                    break;
                case "10532":
                    formaPgto = "DP";
                    break;
                case "5":
                    formaPgto = "CC";
                    break;
                default:
                    formaPgto = "AV";


            }


            pedidosDao.inserirPedidos(new Pedidos(
                    Integer.valueOf(pedido),
                    "1", // LOCAL
                    tabela,
                    itens,
                    subTotal,
                    Double.valueOf(df.format(Double.valueOf(desconto.replace(",","."))).replace(",",".")),
                    Double.valueOf(vTotal.replace(",",".")),
                    cliente,
                    vendedor,
                    parcelas,
                    "0",
                    "0",
                    vencto,
                    dataLiberacao,
                    "1",
                    digitado,
                    movTipo,
                    liberado,
                    "AV",
                    hrLiberacao,
                    dataDigitacao,
                    nf,
                    cancelado

            ));






        }

        System.out.println("EXECUTADO!");


    }



    public  Integer  buscarQtdItens (String pedido) throws Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.MOV_PEDIDOS,"movimentacao_detalhes");

        int count = 0;
        for (int i = 0; i < nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(i);
            if (pedido.equals(element.getElementsByTagName("movi_codigo").item(0).getTextContent())){
            count ++;
            }

        }

        return count;
    }


    public  Double  buscarSubTotal (String pedido) throws Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.MOV_PEDIDOS,"movimentacao_detalhes");

        Double sub = 0.00;
        for (int i = 0; i < nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(i);
            if (pedido.equals(element.getElementsByTagName("movi_codigo").item(0).getTextContent())){
                sub += Double.valueOf(element.getElementsByTagName("movi_valor").item(0).getTextContent().replace(",",".")) * Double.valueOf(element.getElementsByTagName("movi_qtde").item(0).getTextContent().replace(",","."));
            }

        }

        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(sub).replace(",","."));
    }


    public String buscarVendedor (String pedido) throws Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.PEDIDOS_VENDEDORES,"cts_pag_funcionarios");

        String vendedor = null;
        while (vendedor ==null) {
            for (int i = 0; i < nodeList.getLength(); i++){
                Element element = (Element) nodeList.item(i);
                if (pedido.equals(element.getElementsByTagName("cts_identificacao").item(0).getTextContent())){
                    String v = element.getElementsByTagName("cts_funcionario").item(0).getTextContent();

                    vendedor = v;
                }
            }

            if (vendedor == null) {
                vendedor = "99";
            }
        }


        return vendedor;
    }


    public List<String> buscarNF () throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.NOTAS_FISCAIS,"fiscal_nfe");

        List<String> numNf = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(0);
                numNf.add(element.getElementsByTagName("nf_nNF").item(0).getTextContent());


        }

        return numNf;

    }


    public String buscarXmlAssinada(String codNfe) throws Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.PEDIDOS,"movimentacao");


        String xmlAssinada = null;
            for (int i = 0; i < nodeList.getLength(); i++){
                Element element = (Element) nodeList.item(i);
                if (codNfe.equals(element.getElementsByTagName("movi_nfe_numero").item(0).getTextContent())){
                    xmlAssinada = element.getElementsByTagName("movi_nfe_xml").item(0).getTextContent();


                }
            }


            return xmlAssinada;
        }



}
