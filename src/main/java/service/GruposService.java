package service;

import dao.GruposDao;
import dao.ProdutosDao;
import model.Grupos;
import model.Produtos;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.CaminhoArquivo;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class GruposService {

    public GruposService() {
    }

    public void gruposXML() throws Exception {

        GruposDao gruposDao = new GruposDao();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(CaminhoArquivo.GRUPOS);

        NodeList tagNameProdutos = document.getElementsByTagName("cad_produtos_grupos");
        NodeList produtos = tagNameProdutos.item(0).getChildNodes();

        gruposDao.inserirGrupoPrincipal();



        for (int i = 0; i < produtos.getLength(); i++) {
            Element element = (Element) produtos.item(i);

            String codigoStr = element.getElementsByTagName("produto_grupo_codigo").item(0).getTextContent();
            String codGrupo = codigoStr.length() == 1 ? "010" + codigoStr : "01" + codigoStr;
            String nomeStr = element.getElementsByTagName("produto_grupo_descricao").item(0).getTextContent();
            gruposDao.inserirGrupos(new Grupos(codGrupo,nomeStr));


        }

        System.out.println("EXECUTADO!");

    }







}
