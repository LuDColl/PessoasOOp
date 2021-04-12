package br.pessoa;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import br.validacao.ValidacaoDocumento;

public class Cadastro {
    ArrayList<Pessoa> cadastro;
    ValidacaoDocumento validacao;

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

    public void imprimirCadastro() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        validacao = new ValidacaoDocumento();
        System.out.println("Cadastros");
        System.out.println();
        for (Pessoa pessoa : cadastro) {
            System.out.println("Nome da " + pessoa.getTipoPessoa() + ": " + pessoa.getNome());
            System.out
                    .println((pessoa.getTipoPessoa() == "pessoa física" ? "CPF: " : "CNPJ: ") + pessoa.getDocumento());
            System.out.println((pessoa.getTipoPessoa() == "pessoa física" ? "CPF válido: " : "CNPJ válido: ")
                    + (pessoa.getTipoPessoa() == "pessoa física"
                            ? (validacao.ehCpf(pessoa.getDocumento()) ? "Válido" : "Inválido")
                            : (validacao.ehCnpj(pessoa.getDocumento()) ? "Válido" : "Inválido")));
            System.out.println();
        }
    }

}
