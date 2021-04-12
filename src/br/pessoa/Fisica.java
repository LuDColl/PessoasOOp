package br.pessoa;

public class Fisica extends Pessoa {

    public Fisica(String nome, String cpf) {
        super(nome, cpf);
    }

    public String getTipoPessoa(){
        return "pessoa física";
    }

}
