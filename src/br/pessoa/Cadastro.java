package br.pessoa;

import java.util.ArrayList;

import br.validacao.ValidarCnpj;
import br.validacao.ValidarCpf;
import br.validacao.ValidarObjeto;

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
            System.out.println("Nome: " + pessoa.getNome());
            isFisica = new ValidarObjeto(pessoa, "br.pessoa.Fisica").isValido();
            isJuridica = new ValidarObjeto(pessoa, "br.pessoa.Juridica").isValido();
            String documento = "Documento: ";
            String validacao = "Ideterminado.";
            if (isFisica) {
                documento = "Cpf: ";
                validacao = new ValidarCpf(pessoa.getDocumento()).isValido() ? "Válido" : "Inválido";
            } else if (isJuridica) {
                documento = "Cnpj: ";
                validacao = new ValidarCnpj(pessoa.getDocumento()).isValido() ? "Válido" : "Inválido";
            }
            System.out.println(documento + pessoa.getDocumento());
            System.out.println("Estado: " + validacao);
            System.out.println();
        }
    }

}
