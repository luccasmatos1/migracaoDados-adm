package service;

import dao.ClientesDao;
import model.Clientes;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.BuscarCidadeAndEstado;
import utils.CaminhoArquivo;
import utils.NodeListUtil;


public class ClientesService {

    public ClientesService() {
    }

    public void inserirClientes() throws Exception {

        ClientesDao clientesDao = new ClientesDao();

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.CLIENTES,"cad_clientes");


        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String codigoStr = element.getElementsByTagName("cliente_codigo").item(0).getTextContent();
            String tipoStr = element.getElementsByTagName("cliente_pessoa").item(0).getTextContent();
            String cpfAndCnpj = element.getElementsByTagName("cliente_cnpf").item(0).getTextContent();
            String cnpj = cpfAndCnpj.length() == 14 ? cpfAndCnpj : null;
            String ie = element.getElementsByTagName("cliente_rgie").item(0).getTextContent();
            String cpf = cnpj == null ? cpfAndCnpj : null;
            String nome = element.getElementsByTagName("cliente_nome").item(0).getTextContent();
            String endereco = element.getElementsByTagName("cliente_endereco").item(0).getTextContent();
            String bairro = element.getElementsByTagName("cliente_bairro").item(0).getTextContent();
            String cidade = BuscarCidadeAndEstado.retornaCidade(element.getElementsByTagName("cliente_cidade").item(0).getTextContent());
            String cep = element.getElementsByTagName("cliente_cep").item(0).getTextContent();
            String tel1 = retornaTelefone(codigoStr,1);
            String tel2 = retornaTelefone(codigoStr,2);
            String codMunicipio = BuscarCidadeAndEstado.retornaCodigoMunicipio(element.getElementsByTagName("cliente_cidade").item(0).getTextContent());
            String indIeDest = ie == null || ie.isEmpty() ? "9" : "1";
            String n = element.getElementsByTagName("cliente_numero").item(0).getTextContent();
            String numero = n == null || n.isEmpty() ? "S/N" : n;
            String a = element.getElementsByTagName("cliente_status").item(0).getTextContent();
            String ativo = a.equals("1") ? "S" : "N";
            String fantasia = element.getElementsByTagName("cliente_fantasia").item(0).getTextContent();
            String uf = BuscarCidadeAndEstado.retornaEstado(element.getElementsByTagName("cliente_estado").item(0).getTextContent());
            String email = retornaEmail(codigoStr);
            String consFinal = !indIeDest.equals("9") ? "N" : "S";

            clientesDao.inserirClientes(new Clientes(Integer.valueOf(codigoStr),tipoStr,cnpj,ie,cpf,nome,endereco,bairro,cidade,cep,tel1,tel2,codMunicipio,indIeDest,numero,ativo,fantasia,uf,email,tel1,tel2,consFinal));
        }

        System.out.println("EXECUTADO!");

    }


    public String retornaEmail(String codCliente) throws Exception{

        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.CLIENTES_EMAIL,"cad_clientes_emails");

        String email = null;
        for (int i = 0; i<nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(i);

            if (codCliente.equals(element.getElementsByTagName("cliente_codigo").item(0).getTextContent())){
                email = element.getElementsByTagName("email_endereco").item(0).getTextContent();
            }

        }

        return email;
    }

    public String retornaTelefone(String codCliente, int posicao) throws Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.CLIENTES_TELEFONE,"cad_clientes_telefones");

        String tel = null;
        int count = 0;
        for (int i = 0; i< nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(i);
            if(codCliente.equals(element.getElementsByTagName("cliente_codigo").item(0).getTextContent())){
               count ++;
                if (count == posicao){
                    tel = element.getElementsByTagName("telefone_numero").item(0).getTextContent();

                }
            }


        }

        return tel;
    }


    public String buscarClientePorCpfOrCnpj(String cnpj,String cpf) throws  Exception{
        NodeList nodeList = NodeListUtil.buscarArquivoAndTagName(CaminhoArquivo.CLIENTES,"cad_clientes");


        String clienteCodigo = null;
        for (int i= 0; i < nodeList.getLength();i++){
            Element element = (Element) nodeList.item(i);
            if (cnpj.equals(element.getElementsByTagName("cliente_cnpf").item(0).getTextContent()) || cpf.equals(element.getElementsByTagName("cliente_cnpf").item(0).getTextContent())){
                clienteCodigo = element.getElementsByTagName("cliente_codigo").item(0).getTextContent();
            }

        }



        return  clienteCodigo;

    }







}
