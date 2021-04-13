package br.validacao;

public class ValidarNumero extends Validar {

    @Override
    public boolean isValido(String numero) {
        try {
            Long.parseLong(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
