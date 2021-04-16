package br.pessoa;

import java.util.ArrayList;

import br.validacao.ValidadorCnpj;
import br.validacao.ValidadorCpf;
import br.validacao.ValidadorObjeto;

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
            isFisica = new ValidadorObjeto(pessoa, "br.pessoa.Fisica").isValido();
            isJuridica = new ValidadorObjeto(pessoa, "br.pessoa.Juridica").isValido();
            String documento = "Documento: ";
            String validacao = "Ideterminado.";
            if (isFisica) {
                documento = "Cpf: ";
                validacao = new ValidadorCpf(pessoa.getDocumento()).isValido() ? "Válido" : "Inválido";
            } else if (isJuridica) {
                documento = "Cnpj: ";
                validacao = new ValidadorCnpj(pessoa.getDocumento()).isValido() ? "Válido" : "Inválido";
            }
            System.out.println(documento + pessoa.getDocumento());
            System.out.println("Estado: " + validacao);
            System.out.println();
        }
    }

}
