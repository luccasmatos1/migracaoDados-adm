package service;

import dao.DocPagarDao;
import dao.DocPagarDao;
import dao.NFeDao;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.CaminhoArquivo;
import utils.FormatarDecimal;
import utils.NodeListUtil;

public class DocReceberService {

    NFeDao nFeDao = new NFeDao();
    DocPagarDao docPagarDao = new DocPagarDao();

    public DocReceberService(){

    }
    public void inserirDocReceber() throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.DOC_RECEBER,"cts_rec_lancamentos");

        for (int i = 0 ; i < nodeList.getLength() ; i++){
            Element element = (Element) nodeList.item(i);
                String nfe = element.getElementsByTagName("rec_nf").item(0).getTextContent();

                String fornecedor = element.getElementsByTagName("rec_cliente").item(0).getTextContent();
                String pgtoTipo = element.getElementsByTagName("rec_tipopgto").item(0).getTextContent();
                if (!pgtoTipo.equals("0") && !pgtoTipo.equals("2") && !pgtoTipo.equals("4")){
                    System.out.println(pgtoTipo);

                }
                String doc = nfe;
                String p = element.getElementsByTagName("rec_total_parcela").item(0).getTextContent().split("/")[0];

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
                        break;
                    case "69":
                        pgtoTipo = "TF";
                        break;
                    case "70":
                        pgtoTipo= "TF";
                        break;
                    case "10530":
                        pgtoTipo = "PX";
                        break;
                    case "10532":
                        pgtoTipo = "DP";
                        break;
                    case "5":
                        pgtoTipo = "CC";
                        break;


                }

                String emissao = element.getElementsByTagName("rec_datadoc").item(0).getTextContent();
                if (emissao.isEmpty()){
                    emissao = null;
                }
                String vencto = element.getElementsByTagName("rec_datavenc").item(0).getTextContent();
                if (vencto.isEmpty()){
                    vencto = null;
                }
                String v = element.getElementsByTagName("rec_parcela").item(0).getTextContent();

                Double valor = FormatarDecimal.FormatarDecimal(v);

                String obs = element.getElementsByTagName("rec_observacoes").item(0).getTextContent();
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
                dataPgto =  buscarDataPgto(element.getElementsByTagName("rec_lancamento").item(0).getTextContent());

                Double vlrreco = FormatarDecimal.FormatarDecimal(buscarVlrPgto(element.getElementsByTagName("rec_lancamento").item(0).getTextContent())) ;
                docPagarDao.inserirDocReceber(fornecedor,pgtoTipo,doc,emissao,vencto,valor,obs,dataPgto,vlrreco,operador,nf);



            }

        System.out.println("EXECUTADO!");

    }



    public String buscarDataPgto (String recLancamento) throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.DOC_RECEBER_BAIXA,"cts_rec_baixas");

        String data = "";
        for (int i= 0; i < nodeList.getLength() ; i++){
            Element element = (Element) nodeList.item(i);
            if (recLancamento.equals(element.getElementsByTagName("rec_lancamento").item(0).getTextContent())){
                data = element.getElementsByTagName("rec_datapgto").item(0).getTextContent().split(" ")[0];
            }
        }

        if (data.isEmpty()){
            data = null;
        }


        return data;
    }



    public String buscarVlrPgto (String recLancamento) throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.DOC_RECEBER_BAIXA,"cts_rec_baixas");

        String vlrPgto = "";
        for (var i= 0; i < nodeList.getLength() ; i++){
            Element element = (Element) nodeList.item(i);
            if (recLancamento.equals(element.getElementsByTagName("rec_lancamento").item(0).getTextContent())){
                vlrPgto = element.getElementsByTagName("rec_valorpgto").item(0).getTextContent().split(" ")[0];
            }
        }




        return vlrPgto;
    }


}
