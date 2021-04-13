package br.validacao;

public class ValidarCpf extends Validar {

    @Override
    public boolean isValido(String cpf) {
        if (new ValidarNumero().isValido(cpf)) {
            return false;
        };
        return false;
    }

}
