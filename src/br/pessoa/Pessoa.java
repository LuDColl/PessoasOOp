package br.pessoa;

public abstract class Pessoa {
    private String nome;
    private String documento;

    protected Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTipoPessoa() {
        return "Pessoa";
    }

}
