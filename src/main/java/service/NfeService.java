package service;

import dao.MovPedidoDao;
import dao.NFeDao;
import model.MovPedido;
import model.NfeModel;
import model.NfeSaida;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.CaminhoArquivo;
import utils.NodeListUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class NfeService {


    ClientesService clientesService = new ClientesService();
    PedidosService pedidosService = new PedidosService();
    NFeDao nFeDao = new NFeDao();


//    MovPedidoDao mvp = new MovPedidoDao();
    public NfeService() {
    }
    DecimalFormat df = new DecimalFormat("#.##");

    public void inserirNfEntrada() throws Exception {

        System.out.println("PERAPARANDO PARA INICIAR A MIGRAÇÃO DAS NFE DE ENTRADA...");


        System.out.println("LENDO ARQUIVO DE MIGRACAO...");
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.NOTAS_FISCAIS_ENTRADA,"movimentacaoc");

        System.out.println("ARQUIVO LIDO COM SUCESSO...");

        System.out.println("PERAPARANDO PARA INICIAR A MIGRAÇÃO DAS NFE DE ENTRADA...");
        System.out.println("EXECUTANDO...");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            String idNfe = element.getElementsByTagName("movi_codigo").item(0).getTextContent();
            if (verificarTabelaMovEntrada().contains(idNfe)){
                Integer nfId = Integer.valueOf(idNfe);
                String documento = element.getElementsByTagName("pag_nf").item(0).getTextContent(); //documento
                String favorecido = element.getElementsByTagName("movi_fornecedor").item(0).getTextContent();
                String nfeChave = element.getElementsByTagName("movi_nfe_chave").item(0).getTextContent();
                String nfceProtocolo = element.getElementsByTagName("movi_nfe_protocolo").item(0).getTextContent();
                String nfeStatus = element.getElementsByTagName("movi_nfe_status").item(0).getTextContent();
                String emissao = element.getElementsByTagName("movi_dtoperacao").item(0).getTextContent().split(" ")[0];
                String recepcao = element.getElementsByTagName("data_add").item(0).getTextContent().split(" ")[0];
                String baseCalculo = element.getElementsByTagName("movi_base_icms").item(0).getTextContent().replace(",",".");
                String vlrIcms = element.getElementsByTagName("movi_valor_icms").item(0).getTextContent().replace(",",".");
                String vlrContabil = element.getElementsByTagName("movi_vlrtotal").item(0).getTextContent().replace(",",".");
                String totalProdutos = vlrContabil;
                NfeModel nfeModel = new NfeModel(nfId,documento,favorecido,vlrContabil,nfeChave,nfceProtocolo,nfeStatus,emissao,recepcao,baseCalculo,vlrIcms,totalProdutos);
                nFeDao.inserirNfsEntrada(nfeModel);

            }



        }


    }


    public void inserirNfeSaida() throws Exception {

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.NOTAS_FISCAIS_SAIDA,"fiscal_nfe");


        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
                String documento = element.getElementsByTagName("nf_nNF").item(0).getTextContent(); //documento

                String destCnpj = element.getElementsByTagName("dest_CNPJ").item(0).getTextContent();
                String destCpf = element.getElementsByTagName("dest_CPF").item(0).getTextContent();
                String favorecido = clientesService.buscarClientePorCpfOrCnpj(destCnpj,destCpf);
                String serie = element.getElementsByTagName("nf_serie").item(0).getTextContent();
                String ambiente = element.getElementsByTagName("nf_tpAmb").item(0).getTextContent();
                String nfeChave = element.getElementsByTagName("nf_chNFe").item(0).getTextContent();
                String nfceProtocolo = element.getElementsByTagName("nf_nProt").item(0).getTextContent();
                String nfeRecibo = element.getElementsByTagName("nf_nRec").item(0).getTextContent();
                String nfeStatus = element.getElementsByTagName("nf_cStat").item(0).getTextContent();
                String emissao = element.getElementsByTagName("nf_dEmi").item(0).getTextContent();
                String baseCalculo = element.getElementsByTagName("ICMSTot_vNF").item(0).getTextContent().replace(",",".");
                String vlrContabil = element.getElementsByTagName("cobr_fat_vLiq").item(0).getTextContent().replace(",",".");
                String totalProdutos = element.getElementsByTagName("cobr_fat_vOrig").item(0).getTextContent().replace(",",".");
                String xmlAssinada = pedidosService.buscarXmlAssinada(documento);
                NfeSaida nfeModel = new NfeSaida(documento,favorecido,serie,ambiente,nfeChave,nfceProtocolo,nfeRecibo,nfeStatus,emissao,emissao,baseCalculo,vlrContabil,totalProdutos,xmlAssinada);

                nFeDao.inserirNfSaida(nfeModel);



        }


        System.out.println("EXECUTADO!");

    }



    public List<String> verificarTabelaMovEntrada () throws Exception{
       NodeList nodeList =  NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.MOVIMENTO_ENTRADA,"movimentacaoc_detalhes");

       List<String> idNfList = new ArrayList<>();
       for (int i = 0 ; i < nodeList.getLength(); i++){
           Element element = (Element) nodeList.item(i);
           idNfList.add(element.getElementsByTagName("movi_codigo").item(0).getTextContent());

        }


       return idNfList;


    }






}
