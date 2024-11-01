package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BuscarCidadeAndEstado  {




    public static String retornaCidade(String codigo) throws Exception {
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.CIDADES,"prm_cidades");

        String nomeCidade = null;


        for (int i = 0; i < nodeList.getLength() && nomeCidade == null; i++) {
            Element element = (Element) nodeList.item(i);
            String nome = element.getElementsByTagName("cidade_nome").item(0).getTextContent();
            if (codigo.equals(element.getElementsByTagName("cidade_codigo").item(0).getTextContent())){
                nomeCidade = nome;
            }
        }

        return nomeCidade;
    }

    public static String retornaEstado(String codigo) throws Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.ESTADOS,"prm_estados");

        String siglaEstado = null;

        for (int i = 0; i < nodeList.getLength() && siglaEstado == null; i++) {
            Element element = (Element) nodeList.item(i);
            String uf = element.getElementsByTagName("estado_nome").item(0).getTextContent();
            if (codigo.equals(element.getElementsByTagName("estado_codigo").item(0).getTextContent())){
                siglaEstado = uf;
            }
        }

        return siglaEstado;
    }


    public static String retornaCodigoMunicipio(String codigo) throws Exception {
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.CIDADES,"prm_cidades");

        String codMunicipio = null;


        for (int i = 0; i < nodeList.getLength() && codMunicipio == null; i++) {
            Element element = (Element) nodeList.item(i);
            String codIbge = element.getElementsByTagName("cidade_ibge").item(0).getTextContent();
            if (codigo.equals(element.getElementsByTagName("cidade_codigo").item(0).getTextContent())){
                codMunicipio = codIbge;
            }
        }

        return codMunicipio;
    }

}
