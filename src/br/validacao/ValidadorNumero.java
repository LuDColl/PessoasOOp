package br.validacao;

public class ValidadorNumero extends Validador {

    public ValidadorNumero(String numero) {
        super(numero);
    }

    @Override
    public boolean isValido() {
        try {
            Long.parseLong(parametro);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
