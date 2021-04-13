package br.conversao;

import java.util.ArrayList;

public abstract class ToArrayList {
    protected String texto;
    private int inteiro;
    private float fracao;
    private double racional;
    protected ArrayList<String> listaTexto;
    protected ArrayList<Integer> listaInteiro;
    protected ArrayList<Float> listaFracao;
    protected ArrayList<Double> listaRacional;
    

    public ToArrayList(String texto) {
        this.texto = texto;
    }

    public ToArrayList(int inteiro) {
        this.inteiro = inteiro;
    }

    public ToArrayList(float fracao) {
        this.fracao = fracao;
    }

    public ToArrayList(Double racional) {
        this.racional = racional;
    }

    public abstract ArrayList<String> toArrayString();

    public abstract ArrayList<Integer> toArrayInt();

    public abstract ArrayList<Float> toArrayFloat();

    public abstract ArrayList<Double> toArrayDouble();

}
