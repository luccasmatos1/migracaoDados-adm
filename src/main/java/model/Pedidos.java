package model;

public class Pedidos {

        private Integer pedido;
        private String local;
        private String tabela;
        private Integer itens;
        private Double subtotal;
        private Double desconto;
        private Double total;
        private String cliente;
        private String vendedor;
        private String parcelas;
        private String prazo;
        private String intervalo;
        private String vencto;
        private String liberacao;
        private String empresa;
        private String digitado;
        private String tipo;
        private String liberado;
        private String formapgto;
        private String hrLiberacao;
        private String dataDigitacao;
        private String nf;
        private String cancelado;




    public Pedidos(Integer pedido, String local, String tabela, Integer itens,Double subtotal, Double desconto, Double total, String cliente, String vendedor, String parcelas, String prazo, String intervalo, String vencto, String liberacao, String empresa, String digitado, String tipo, String liberado, String formapgto, String hrLiberacao,String dataDigitacao,String nf,String cancelado) {
        this.pedido = pedido;
        this.local = local;
        this.tabela = tabela;
        this.itens = itens;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.total = total;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.parcelas = parcelas;
        this.prazo = prazo;
        this.intervalo = intervalo;
        this.vencto = vencto;
        this.liberacao = liberacao;
        this.empresa = empresa;
        this.digitado = digitado;
        this.tipo = tipo;
        this.liberado = liberado;
        this.formapgto = formapgto;
        this.hrLiberacao = hrLiberacao;
        this.dataDigitacao = dataDigitacao;
        this.nf = nf;
        this.cancelado = cancelado;
    }

    public String getCancelado() {
        return cancelado;
    }

    public String getNf() {
        return nf;
    }

    public Integer getPedido() {
        return pedido;
    }



    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public String getVencto() {
        return vencto;
    }

    public void setVencto(String vencto) {
        this.vencto = vencto;
    }

    public String getLiberacao() {
        return liberacao;
    }

    public void setLiberacao(String liberacao) {
        this.liberacao = liberacao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDigitado() {
        return digitado;
    }

    public void setDigitado(String digitado) {
        this.digitado = digitado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLiberado() {
        return liberado;
    }

    public void setLiberado(String liberado) {
        this.liberado = liberado;
    }

    public String getFormapgto() {
        return formapgto;
    }

    public void setFormapgto(String formapgto) {
        this.formapgto = formapgto;
    }

    public String getHrLiberacao() {
        return hrLiberacao;
    }

    public void setHrLiberacao(String hrLiberacao) {
        this.hrLiberacao = hrLiberacao;
    }

    public String getDataDigitacao() {
        return dataDigitacao;
    }

    public Integer getItens() {
        return itens;
    }
}
