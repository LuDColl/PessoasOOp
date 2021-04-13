package br.pessoa;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import br.validacao.Validacao;

public class Cadastro {
    ArrayList<Pessoa> cadastro;

    public Cadastro() {
        cadastro = new ArrayList<>();
    }

    private void addPessoa(Pessoa objPessoa) {
        Pessoa pessoa = objPessoa;
        cadastro.add(pessoa);
    }

    public void addPessoaFisica(String nome, String documento) {
        addPessoa(new Fisica(nome, documento));
    }

    public void addPessoaJuridica(String nome, String documento) {
        addPessoa(new Juridica(nome, documento));
    }

    public void imprimirCadastro(){
        System.out.println("Cadastros");
        System.out.println();
        boolean isFisica;
        boolean isJuridica;
        for (Pessoa pessoa : cadastro) {
            isFisica = pessoa.getClass().getName() == "Fisica";
            isJuridica = pessoa.getClass().getName() == "Juridica";
            if (isFisica) {
                
            } else if (isJuridica) {
                
            }
            System.out.println();
        }
    }

}
