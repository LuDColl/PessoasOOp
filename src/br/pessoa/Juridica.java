package br.pessoa;

public class Juridica extends Pessoa {

    public Juridica(String nome, String cnpj) {
        super(nome, cnpj);
    }

    public String getTipoPessoa(){
        return "pessoa jurídica";
    }

}
