package pessoas;

public class Juridica extends Pessoa {
    private String cnpj;

    public Juridica(String nome, String cnpj) {
        super(nome);
        this.setCnpj(cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
