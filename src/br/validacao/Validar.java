package br.validacao;

public abstract class Validar implements Validacao{
    String parametro;

    public Validar(String parametro) {
        super();
        this.parametro = parametro;
    }
    
    public abstract boolean isValido();
    
}
