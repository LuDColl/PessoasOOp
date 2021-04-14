package br.validacao;

public class ValidarObjeto extends Validar {
    Object objeto;

    public ValidarObjeto(Object objeto, String parametro) {
        super(parametro);
        this.objeto = objeto;
    }

    @Override
    public boolean isValido() {
        if (parametro == objeto.getClass().getName()) {
            return true;
        } else {
            return false;
        }
    }

}
