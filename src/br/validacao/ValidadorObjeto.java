package br.validacao;

public class ValidadorObjeto extends Validador {
    Object objeto;

    public ValidadorObjeto(Object objeto, String parametro) {
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
