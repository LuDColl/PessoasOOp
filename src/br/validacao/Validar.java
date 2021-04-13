package br.validacao;

public abstract class Validar{

    public Validar() {
        super();
    }
    
    protected abstract boolean isValido(String argumento);
    
}
