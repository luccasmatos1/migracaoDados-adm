package model;

public class MovEstoque {

    String documento;
    String favorecido;
    String produto;
    String data;
    String tipoMov;
    String und;
    String qtd;
    String vlrUnit;
    String vlrTotal;
    String empresa;
    String vendedor;
    String localizado;


    public MovEstoque(){

    }

    public MovEstoque(String documento, String favorecido, String produto, String data, String tipoMov, String und, String qtd, String vlrUnit, String vlrTotal, String empresa, String vendedor, String localizado) {
        this.documento = documento;
        this.favorecido = favorecido;
        this.produto = produto;
        this.data = data;
        this.tipoMov = tipoMov;
        this.und = und;
        this.qtd = qtd;
        this.vlrUnit = vlrUnit;
        this.vlrTotal = vlrTotal;
        this.empresa = empresa;
        this.vendedor = vendedor;
        this.localizado = localizado;
    }




    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public String getUnd() {
        return und;
    }

    public void setUnd(String und) {
        this.und = und;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public String getVlrUnit() {
        return vlrUnit;
    }

    public void setVlrUnit(String vlrUnit) {
        this.vlrUnit = vlrUnit;
    }

    public String getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(String vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getLocalizado() {
        return localizado;
    }

    public void setLocalizado(String localizado) {
        this.localizado = localizado;
    }
}
