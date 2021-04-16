package br.validacao;

public abstract class Validador implements Validacao{
    String parametro;

    public Validador(String parametro) {
        super();
        this.parametro = parametro;
    }
    
    public abstract boolean isValido();
    
}
