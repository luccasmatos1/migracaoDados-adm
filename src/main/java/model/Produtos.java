package model;

public class Produtos {


    private Integer codigo;
    private String nome;
    private String codbarra;
    private String grupo;
    private String qtdemb;
    private String undint;
    private String undext;
    private String fornecedor;
    private Double compra;
    private Double custo;
    private Double unit1;
    private Double unit2;
    private Double unit3;
    private Double vlr1;
    private Double vlr2;
    private Double vlr3;
    private String ativo;
    private String cadastro;
    private String ncm;
    private String origem;

    public Produtos() {
    }

    public Produtos(Integer codigo,
                    String nome,
                    String codbarra,
                    String grupo,
                    String qtdemb,
                    String undint,
                    String undext,
                    String fornecedor,
                    Double compra,
                    Double custo,
                    Double unit1,
                    Double unit2,
                    Double unit3,
                    Double vlr1,
                    Double vlr2,
                    Double vlr3,
                    String ativo,
                    String cadastro,
                    String ncm,
                    String origem) {
        this.codigo = codigo;
        this.nome = nome;
        this.codbarra = codbarra;
        this.grupo = grupo;
        this.qtdemb = qtdemb;
        this.undint = undint;
        this.undext = undext;
        this.fornecedor = fornecedor;
        this.compra = compra;
        this.custo = custo;
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.unit3 = unit3;
        this.vlr1 = vlr1;
        this.vlr2 = vlr2;
        this.vlr3 = vlr3;
        this.ativo = ativo;
        this.cadastro = cadastro;
        this.ncm = ncm;
        this.origem = origem;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodbarra() {
        return codbarra;
    }

    public void setCodbarra(String codbarra) {
        this.codbarra = codbarra;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getQtdemb() {
        return qtdemb;
    }

    public void setQtdemb(String qtdemb) {
        this.qtdemb = qtdemb;
    }

    public String getUndint() {
        return undint;
    }

    public void setUndint(String undint) {
        this.undint = undint;
    }

    public String getUndext() {
        return undext;
    }

    public void setUndext(String undext) {
        this.undext = undext;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getCompra() {
        return compra;
    }

    public void setCompra(Double compra) {
        this.compra = compra;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Double getUnit1() {
        return unit1;
    }

    public void setUnit1(Double unit1) {
        this.unit1 = unit1;
    }

    public Double getUnit2() {
        return unit2;
    }

    public void setUnit2(Double unit2) {
        this.unit2 = unit2;
    }

    public Double getUnit3() {
        return unit3;
    }

    public void setUnit3(Double unit3) {
        this.unit3 = unit3;
    }

    public Double getVlr1() {
        return vlr1;
    }

    public void setVlr1(Double vlr1) {
        this.vlr1 = vlr1;
    }

    public Double getVlr2() {
        return vlr2;
    }

    public void setVlr2(Double vlr2) {
        this.vlr2 = vlr2;
    }

    public Double getVlr3() {
        return vlr3;
    }

    public void setVlr3(Double vlr3) {
        this.vlr3 = vlr3;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}

