package br.validacao;

public class ValidarCpf extends Validar {

    public ValidarCpf(String documento) {
        super(documento);
    }

    @Override
    public boolean isValido() {
        if (new ValidarNumero(parametro).isValido()) {
            return false;
        };
        return false;
    }

}
