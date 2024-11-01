package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class NodeListUtil {


    public static NodeList buscarArquivoAndTagName (String arquivo, String tagName) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(arquivo);
        NodeList elementsByTagName = document.getElementsByTagName(tagName);
        NodeList nodeList = elementsByTagName.item(0).getChildNodes();

        return nodeList;
    }

//    public static Element buscarCampo(NodeList nodeList, String tagName, int pos){
//        Element element = (Element) nodeList.item(pos);
//        element.getElementsByTagName(tagName).item(0).getTextContent();
//        return element;
//
//    }



}
