package br.validacao;

public class ValidarNumero extends Validar {

    public ValidarNumero(String numero) {
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
