package model;

public class MovPedido {


    private String venda;
    private String seq ;
    private String prod ;
    private String und ;
    private Double qtd ;
    private Double unit ;
    private Double descv;
    private Double total;
    private String nomeProduto;
    private String local;
    private String tabela;

    public MovPedido(String venda, String seq, String prod, String und, Double qtd, Double unit, Double descv, Double total, String nomeProduto, String local, String tabela) {
        this.venda = venda;
        this.seq = seq;
        this.prod = prod;
        this.und = und;
        this.qtd = qtd;
        this.unit = unit;
        this.descv = descv;
        this.total = total;
        this.nomeProduto = nomeProduto;
        this.local = local;
        this.tabela = tabela;
    }


    public String getVenda() {
        return venda;
    }

    public String getSeq() {
        return seq;
    }

    public String getProd() {
        return prod;
    }

    public String getUnd() {
        return und;
    }

    public Double getQtd() {
        return qtd;
    }

    public Double getUnit() {
        return unit;
    }

    public Double getDescv() {
        return descv;
    }

    public Double getTotal() {
        return total;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getLocal() {
        return local;
    }

    public String getTabela() {
        return tabela;
    }
}
