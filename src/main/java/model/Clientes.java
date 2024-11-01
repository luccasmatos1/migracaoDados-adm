package model;

public class Clientes {

        private Integer codigo;
        private String tipo;
        private String cnpj;
        private String ie;
        private String cpf;
        private String nome;
        private String endereco;
        private String bairro;
        private String cidade;
        private String cep;
        private String fone1;
        private String fone2;
        private String codMunicipio;
        private String indIEDest;
        private String numero;
        private String ativo;
        private String fantasia;
        private String estado;
        private String email;
        private String telefone1;
        private String telefone2;
        private String consumidorFinal;
    public Clientes(Integer codigo, String tipo, String cnpj, String ie, String cpf, String nome, String endereco, String bairro, String cidade, String cep, String fone1, String fone2, String codMunicipio, String indIEDest, String numero, String ativo, String fantasia, String estado, String email,String telefone1,String telefone2,String consumidorFinal) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.cnpj = cnpj;
        this.ie = ie;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.fone1 = fone1;
        this.fone2 = fone2;
        this.codMunicipio = codMunicipio;
        this.indIEDest = indIEDest;
        this.numero = numero;
        this.ativo = ativo;
        this.fantasia = fantasia;
        this.estado = estado;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.consumidorFinal = consumidorFinal;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getIndIEDest() {
        return indIEDest;
    }

    public void setIndIEDest(String indIEDest) {
        this.indIEDest = indIEDest;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getConsumidorFinal() {
        return consumidorFinal;
    }

    public void setConsumidorFinal(String consumidorFinal) {
        this.consumidorFinal = consumidorFinal;
    }
}
