package service;

import dao.ProdutosDao;
import model.Produtos;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.CaminhoArquivo;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



public class ProdutosService {

    public ProdutosService() {
    }

    ProdutosDao produtosDao;
    public void produtosXML() throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(CaminhoArquivo.PRODUTOS);

        System.out.println(CaminhoArquivo.PRODUTOS);
        NodeList tagNameProdutos = document.getElementsByTagName("cad_produtos_");
        NodeList produtos = tagNameProdutos.item(0).getChildNodes();

        for (int i = 0; i < produtos.getLength(); i++) {
            Element element = (Element) produtos.item(i);

            String codigoStr = element.getElementsByTagName("produto_codigo").item(0).getTextContent();
            String nomeStr = element.getElementsByTagName("produto_descricao").item(0).getTextContent();
            String codBarraStr = element.getElementsByTagName("produto_ean13").item(0).getTextContent();
            String grupo = element.getElementsByTagName("produto_grupo").item(0).getTextContent();
            String grupoStr = grupo.length() > 1 ? "01" + grupo : "010" + grupo;
            String undInt = bucarUnidadeProduto(codigoStr);
            String undExt = undInt;
            String fornecedorStr = buscarProdutoFornecedor(codigoStr);
            String compraStr = element.getElementsByTagName("produto_custo_produto").item(0).getTextContent();
            String custoStr = element.getElementsByTagName("produto_custo").item(0).getTextContent();
//            List<String> str = adicionarTabPreco(codigoStr);

            Double unit1 = adicionarTabPreco(codigoStr,"1");
            Double unit2 = adicionarTabPreco(codigoStr,"223");
            Double unit3 = adicionarTabPreco(codigoStr,"224");
            Double vlr1 = unit1;
            Double vlr2 = unit2;
            Double vlr3 = unit3;

            String ativo = "A";
            String cadasttroStr = element.getElementsByTagName("data_add").item(0).getTextContent().split(" ")[0];
            String ncmStr = buscarNcm(codigoStr);
            String origoem = "0";

            Produtos prod = new Produtos(Integer.valueOf(codigoStr),nomeStr,codBarraStr,grupoStr,"1",undInt,undExt,fornecedorStr,Double.valueOf(compraStr.replace(",",".")),Double.valueOf(custoStr.replace(",",".")),unit1,unit2,unit3,vlr1,vlr2,vlr3,ativo,cadasttroStr,ncmStr,origoem);

            ProdutosDao produtosDao1 = new ProdutosDao();
            produtosDao1.inserirProdutos(prod);


        }

        System.out.println("EXECUTADO!");

    }

    public String buscarNcm(String produto) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document arquiveProdutosNcm = builder.parse(CaminhoArquivo.PRODUTOS_NCM);
        NodeList tagNameProdutosNcm = arquiveProdutosNcm.getElementsByTagName("cad_produtos_fiscal");
        NodeList produtosNcm = tagNameProdutosNcm.item(0).getChildNodes();

        String ncm = null;

        while (ncm == null){

            for (int i = 0; i < produtosNcm.getLength(); i++) {
                Element element = (Element) produtosNcm.item(i);

                if (produto.equals(element.getElementsByTagName("produto_codigo").item(0).getTextContent())){
                    ncm = element.getElementsByTagName("prod_NCM").item(0).getTextContent();
                }
            }

        }

        return ncm;
    }


    public String bucarUnidadeProduto(String produto) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document arquivo = builder.parse(CaminhoArquivo.PRODUTOS_UNIDADE);
        NodeList tagName = arquivo.getElementsByTagName("cad_produtos_ecf");
        NodeList list = tagName.item(0).getChildNodes();

        String und = null;

        while (und == null){

            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);

                if (produto.equals(element.getElementsByTagName("produto_codigo").item(0).getTextContent())){
                    und = element.getElementsByTagName("produto_medida").item(0).getTextContent();
                }
            }

            if (und == null)
                und = "UND";
        }

        return und;
    }




    public String buscarProdutoFornecedor(String produto) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document arquivo = builder.parse(CaminhoArquivo.PRODUTOS_FORNECEDOR);
        NodeList tagName = arquivo.getElementsByTagName("cad_produtos_fornecedores");
        NodeList list = tagName.item(0).getChildNodes();

        String forn = null;

        while (forn == null){

            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);

                if (produto.equals(element.getElementsByTagName("produto_codigo").item(0).getTextContent())){
                    forn = element.getElementsByTagName("produto_fornecedor").item(0).getTextContent();
                }
            }

            if (forn == null)
                forn = "1";


        }

        return forn;
    }


    public Double adicionarTabPreco(String produto,String tabPreco) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document arquivo = builder.parse(CaminhoArquivo.PRODUTOS_TAB_PRECO);
        NodeList tagName = arquivo.getElementsByTagName("cad_produtos_tabelas_valores");
        NodeList list = tagName.item(0).getChildNodes();
        Double valor = null;

            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);
                if (produto.equals(element.getElementsByTagName("produto_codigo").item(0).getTextContent()) && tabPreco.equals(element.getElementsByTagName("tabela_codigo").item(0).getTextContent())){
                    String vlrStr = element.getElementsByTagName("produto_total").item(0).getTextContent();
                    valor = Double.valueOf(vlrStr.replace(",","."));
                }

            }

        return valor == null ? 0.00 : valor;
    }






}
