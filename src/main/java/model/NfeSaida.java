package model;

public class NfeSaida {


    private String documento;
    private String favorecido;
    private String serie;
    private String ambiente;
    private String nfeChave ;
    private String nfceProtocolo;
    private String nfeRecibo;
    private String nfeStatus;
    private String emissao;
    private String recepcao;
    private String baseCalculo;
    private String vlrContabil;
    private String totalProdutos;
    private String xmlAssinada;


    public NfeSaida(String documento, String favorecido, String serie, String ambiente, String nfeChave, String nfceProtocolo, String nfeRecibo, String nfeStatus, String emissao, String recepcao, String baseCalculo, String vlrContabil, String totalProdutos, String xmlAssinada) {
        this.documento = documento;
        this.favorecido = favorecido;
        this.serie = serie;
        this.ambiente = ambiente;
        this.nfeChave = nfeChave;
        this.nfceProtocolo = nfceProtocolo;
        this.nfeRecibo = nfeRecibo;
        this.nfeStatus = nfeStatus;
        this.emissao = emissao;
        this.recepcao = recepcao;
        this.baseCalculo = baseCalculo;
        this.vlrContabil = vlrContabil;
        this.totalProdutos = totalProdutos;
        this.xmlAssinada = xmlAssinada;
    }

    public String getDocumento() {
        return documento;
    }

    public String getFavorecido() {
        return favorecido;
    }

    public String getSerie() {
        return serie;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public String getNfeChave() {
        return nfeChave;
    }

    public String getNfceProtocolo() {
        return nfceProtocolo;
    }

    public String getNfeRecibo() {
        return nfeRecibo;
    }

    public String getNfeStatus() {
        return nfeStatus;
    }

    public String getEmissao() {
        return emissao;
    }

    public String getRecepcao() {
        return recepcao;
    }

    public String getBaseCalculo() {
        return baseCalculo;
    }


    public String getVlrContabil() {
        return vlrContabil;
    }

    public String getTotalProdutos() {
        return totalProdutos;
    }

    public String getXmlAssinada() {
        return xmlAssinada;
    }
}
