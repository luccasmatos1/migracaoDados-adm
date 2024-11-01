package model;

public class NfeModel {

    private Integer nfId ;
    private String documento;
    private String favorecido;
    private String vlrContabil;
    private String nfeChave;
    private String nfceProtocolo;
    private String nfeStatus;
    private String emissao;
    private String recepcao;
    private String baseCauculo;
    private String vIcms;
    private String vProd;


    public NfeModel(Integer nfId, String documento, String favorecido, String vlrContabil, String nfeChave, String nfceProtocolo, String nfeStatus, String emissao, String recepcao,String baseCauculo,String vIcms,String vProd) {
        this.nfId = nfId;
        this.documento = documento;
        this.favorecido = favorecido;
        this.vlrContabil = vlrContabil;
        this.nfeChave = nfeChave;
        this.nfceProtocolo = nfceProtocolo;
        this.nfeStatus = nfeStatus;
        this.emissao = emissao;
        this.recepcao = recepcao;
        this.baseCauculo = baseCauculo;
        this.vIcms = vIcms;
        this.vProd = vProd;
    }

    public String getBaseCauculo() {
        return baseCauculo;
    }

    public String getvIcms() {
        return vIcms;
    }

    public String getvProd() {
        return vProd;
    }

    public Integer getNfId() {
        return nfId;
    }

    public String getDocumento() {
        return documento;
    }

    public String getFavorecido() {
        return favorecido;
    }

    public String getVlrContabil() {
        return vlrContabil;
    }

    public String getNfeChave() {
        return nfeChave;
    }

    public String getNfceProtocolo() {
        return nfceProtocolo;
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
}
