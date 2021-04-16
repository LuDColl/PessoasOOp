package br.validacao;

public class ValidadorTamanho extends Validador {

    private int tamanho;

    public ValidadorTamanho(String parametro, int tamanho) {
        super(parametro);
        this.tamanho = tamanho;
    }

    @Override
    public boolean isValido() {
        return parametro.length() == tamanho;
    }

}
