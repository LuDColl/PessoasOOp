package br.conversao;

public abstract class Conversor {
    private String parametro;

    public Conversor(String parametro) {
        this.parametro = parametro;
    }

    public abstract String converter();
    public abstract int converter();
    public abstract double converter();
    public abstract float converter();
}
