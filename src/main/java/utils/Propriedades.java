package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Propriedades {


    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./dados.properties.txt");

        props.load(file);
        return props;

    }


    public static String lerCaminhoArquivoMigracao()  {


        String caminhoArquivo = "";

        try(BufferedReader buffRead = new BufferedReader(new FileReader("./dados.properties.txt"));
        ){
            List<String> linha = new ArrayList<>();

            String li = "";
            while (li != null) {
                linha.add(buffRead.readLine());
                li = buffRead.readLine();

            }
            buffRead.close();


            for (String l : linha){
                if (l.length() >= 15 && l.substring(0,15).equals("caminho_arquivo")){
                    caminhoArquivo = l.split("=")[1].trim();

                }
            }

        } catch (IOException e) {
            System.out.println("ARQUIVO NAO ENCONTRADO");
        }






        return caminhoArquivo.replace("\\","\\\\");

    }



}
