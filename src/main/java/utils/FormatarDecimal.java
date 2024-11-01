package utils;

import java.text.DecimalFormat;

public class FormatarDecimal {


    public static  Double FormatarDecimal (String vlr){
        DecimalFormat df = new DecimalFormat("#.##");

        if (vlr.isEmpty()){
            vlr = "0.00";
        }

        Double valorDouble =  Double.valueOf(df.format(Double.valueOf(vlr)).replace(",","."));

        if (valorDouble == 0.00){
            valorDouble = null;
        }

        return valorDouble;
    }
}
