package service;

import dao.DocPagarDao;
import dao.NFeDao;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.CaminhoArquivo;
import utils.FormatarDecimal;
import utils.NodeListUtil;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.DecimalFormat;

public class DocPagarService {

    NFeDao nFeDao = new NFeDao();
    DocPagarDao docPagarDao = new DocPagarDao();

    public  DocPagarService(){

    }
    public void inserirDocPagar() throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.DOC_PAGAR,"cts_pag_lancamentos");


        for (int i = 0 ; i < nodeList.getLength() ; i++){
            Element element = (Element) nodeList.item(i);
                String nfe = element.getElementsByTagName("pag_nf").item(0).getTextContent();

                String fornecedor = element.getElementsByTagName("pag_fornecedor").item(0).getTextContent();
                String pgtoTipo = element.getElementsByTagName("pag_tipopgto").item(0).getTextContent();
                String doc = nfe;
                String p = element.getElementsByTagName("pag_total_parcela").item(0).getTextContent().split("/")[0];

                if (!p.isEmpty() && p.charAt(0) == '0'){
                    doc = doc + "/" + p.charAt(1);
                } else if (!p.isEmpty() && p.charAt(0) != '0') {
                    doc = doc + "/" + p;
                }

                switch (pgtoTipo){
                    case "0":
                        pgtoTipo = "OU";
                        break;
                    case "2":
                        pgtoTipo = "FD";
                        break;
                    case "4":
                        pgtoTipo = "BL";

                }

                String emissao = element.getElementsByTagName("pag_datadoc").item(0).getTextContent();
                if (emissao.isEmpty()){
                    emissao = null;
                }
                String vencto = element.getElementsByTagName("pag_datavenc").item(0).getTextContent();
                if (vencto.isEmpty()){
                    vencto = null;
                }
                String v = element.getElementsByTagName("pag_parcela").item(0).getTextContent();

                Double valor = FormatarDecimal.FormatarDecimal(v);

                String obs = element.getElementsByTagName("pag_observacoes").item(0).getTextContent();
                if (obs.length() > 50){
                    obs = obs.substring(0,50);
                }
                String operador = "ROSE";

                String dataOperacao = null;
                String horaOperacao = null;
                if (!element.getElementsByTagName("data_add").item(0).getTextContent().isEmpty()){
                    dataOperacao = element.getElementsByTagName("data_add").item(0).getTextContent().split(" ")[0];
                    horaOperacao = element.getElementsByTagName("data_add").item(0).getTextContent().split(" ")[1];

                }

                String nf = "";

                if (nFeDao.existeNfEntrada(nfe) != 0){
                    nf = nfe;
                }

                String dataPgto = "";
                dataPgto =  buscarDataPgto(element.getElementsByTagName("pag_lancamento").item(0).getTextContent());

                Double vlrPago = FormatarDecimal.FormatarDecimal(buscarVlrPgto(element.getElementsByTagName("pag_lancamento").item(0).getTextContent())) ;
                System.out.println(dataPgto);
                docPagarDao.inserirDocPagar(fornecedor,pgtoTipo,doc,emissao,vencto,valor,obs,dataPgto,vlrPago,operador,dataOperacao,horaOperacao,nf);



            }

        System.out.println("EXECUTADO!");

    }



    public String buscarDataPgto (String pagLancamento) throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.DOC_PAGAR_BAIXA,"cts_pag_baixas");

        String data = "";
        for (int i= 0; i < nodeList.getLength() ; i++){
            Element element = (Element) nodeList.item(i);
            if (pagLancamento.equals(element.getElementsByTagName("pag_lancamento").item(0).getTextContent())){
                data = element.getElementsByTagName("pag_datapgto").item(0).getTextContent().split(" ")[0];
            }
        }

        if (data.isEmpty()){
            data = null;
        }


        return data;
    }



    public String buscarVlrPgto (String pagLancamento) throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.DOC_PAGAR_BAIXA,"cts_pag_baixas");

        String vlrPgto = "";
        for (var i= 0; i < nodeList.getLength() ; i++){
            Element element = (Element) nodeList.item(i);
            if (pagLancamento.equals(element.getElementsByTagName("pag_lancamento").item(0).getTextContent())){
                vlrPgto = element.getElementsByTagName("pag_valorpgto").item(0).getTextContent().split(" ")[0];
            }
        }




        return vlrPgto;
    }


}
