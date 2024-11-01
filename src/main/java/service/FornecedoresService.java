package service;

import dao.FornecedoresDao;
import dao.GruposDao;
import model.Fornecedores;
import model.Grupos;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.BuscarCidadeAndEstado;
import utils.CaminhoArquivo;
import utils.NodeListUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class FornecedoresService {

    public FornecedoresService() {
    }

    public void salvarFornecedores() throws Exception {

        GruposDao gruposDao = new GruposDao();

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.FORNECEDORES,"cad_fornecedores");


        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String codigoStr = element.getElementsByTagName("fornecedor_codigo").item(0).getTextContent();
            String tipoStr = element.getElementsByTagName("fornecedor_pessoa").item(0).getTextContent();
            String cpfAndCnpj = element.getElementsByTagName("fornecedor_cnpf").item(0).getTextContent();
            String cnpj = cpfAndCnpj.length() == 14 ? cpfAndCnpj : null;
            String ie = element.getElementsByTagName("fornecedor_rgie").item(0).getTextContent();
            String cpf = cnpj == null ? cpfAndCnpj : null;
            String nome = element.getElementsByTagName("fornecedor_nome").item(0).getTextContent();
            String endereco = element.getElementsByTagName("fornecedor_endereco").item(0).getTextContent();
            String bairro = element.getElementsByTagName("fornecedor_bairro").item(0).getTextContent();
            String cidade = BuscarCidadeAndEstado.retornaCidade(element.getElementsByTagName("fornecedor_cidade").item(0).getTextContent());
            String cep = element.getElementsByTagName("fornecedor_cep").item(0).getTextContent();
            String tel1 = retornaTelefone(codigoStr,1);
            String tel2 = retornaTelefone(codigoStr,2);
            String codMunicipio = BuscarCidadeAndEstado.retornaCodigoMunicipio(element.getElementsByTagName("fornecedor_cidade").item(0).getTextContent());
            String indIeDest = ie == null || ie.isEmpty() ? "9" : "1";
            String n = element.getElementsByTagName("fornecedor_numero").item(0).getTextContent();
            String numero = n == null || n.isEmpty() ? "S/N" : n;
            String a = element.getElementsByTagName("fornecedor_status").item(0).getTextContent();
            String ativo = a.equals("1") ? "S" : "N";
            String fantasia = element.getElementsByTagName("fornecedor_fantasia").item(0).getTextContent();
            String uf = BuscarCidadeAndEstado.retornaEstado(element.getElementsByTagName("fornecedor_estado").item(0).getTextContent());
            String email = retornaEmail(codigoStr);

            FornecedoresDao fornecedoresDao = new FornecedoresDao();
            fornecedoresDao.inserirFornecedores(new Fornecedores(Integer.valueOf(codigoStr),tipoStr,cnpj,ie,cpf,nome,endereco,bairro,cidade,cep,tel1,tel2,codMunicipio,indIeDest,numero,ativo,fantasia,uf,email));
        }

        System.out.println("EXECUTADO!");

    }


    public String retornaEmail(String codFornecedor) throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.FORNECEDORES_EMAIL,"cad_fornecedores_emails");

        String email = null;
        for (int i = 0; i<nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(i);

            if (codFornecedor.equals(element.getElementsByTagName("fornecedor_codigo").item(0).getTextContent())){
                email = element.getElementsByTagName("email_endereco").item(0).getTextContent();
            }

        }

        return email;
    }

    public String retornaTelefone(String codFonecedor, int posicao) throws Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.FORNECEDORES_TELEFONE,"cad_fornecedores_telefones");

        String tel = null;
        int count = 0;
        for (int i = 0; i< nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(i);
            if(codFonecedor.equals(element.getElementsByTagName("fornecedor_codigo").item(0).getTextContent())){
               count ++;
                if (count == posicao){
                    tel = element.getElementsByTagName("telefone_numero").item(0).getTextContent();

                }
            }


        }

        return tel;
    }







}
