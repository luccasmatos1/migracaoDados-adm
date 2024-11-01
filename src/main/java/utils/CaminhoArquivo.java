package utils;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CaminhoArquivo  {

    public CaminhoArquivo() throws IOException {
    }




    static String diretorio;

    static {

            diretorio = Propriedades.lerCaminhoArquivoMigracao();

    }

    public static String PRODUTOS = nomeArquivo("_cad_produtos_").replace("\\","\\\\");
    public static String PRODUTOS_NCM ;
    public static String PRODUTOS_UNIDADE;
    public static String PRODUTOS_FORNECEDOR;
    public static String PRODUTOS_TAB_PRECO ;

    public static String GRUPOS;

    public static String FORNECEDORES ;
    public static String FORNECEDORES_TELEFONE;
    public static String FORNECEDORES_EMAIL;
    public static String CLIENTES;
    public static String CLIENTES_EMAIL;
    public static String CLIENTES_TELEFONE;


    public static String PEDIDOS = diretorio;
    public static String MOV_PEDIDOS =diretorio ;
    public static String PEDIDOS_VENDEDORES;
    public static String NOTAS_FISCAIS;

    public static String NOTAS_FISCAIS_ENTRADA;
    public static String MOVIMENTO_ENTRADA;
    public static String NOTAS_FISCAIS_SAIDA;




    public static String CIDADES;
    public static String ESTADOS;

    public static String DOC_PAGAR;
    public static String DOC_RECEBER;
    public static String DOC_PAGAR_BAIXA;
    public static String DOC_RECEBER_BAIXA;
    public static String MOVESTOQUE;


    public static String nomeArquivo(String nome) {
        String arquivo = "";

        File file = new File(diretorio);
        File afile[] = file.listFiles();
        List<File> files = new ArrayList<>();


        for (File f : file.listFiles()){
            files.add(f);
        }

        for (int i = 0; i< files.size() ; i++){
            if (String.valueOf(files.get(i)).contains(nome)){
                arquivo = String.valueOf(files.get(i));
            }



        }


        return arquivo;

    }







}
