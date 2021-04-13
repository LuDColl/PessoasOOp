package br.validacao;

public abstract class Validar implements Validacao{

    public Validar() {
        super();
    }
    
    protected abstract boolean isValido(String argumento);
    
}
