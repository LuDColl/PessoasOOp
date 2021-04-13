package br.validacao;

public class ValidarTamanho extends Validar {

    private int tamanho;

    public ValidarTamanho(String parametro, int tamanho) {
        super(parametro);
        this.tamanho = tamanho;
    }

    @Override
    public boolean isValido() {
        return parametro.length() == tamanho;
    }

}
