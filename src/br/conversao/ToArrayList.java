package br.conversao;

import java.util.ArrayList;

public abstract class ToArrayList {
    protected String texto;
    protected ArrayList<Character> listaCaractere;
    protected ArrayList<Integer> listaInteiro;
    

    public ToArrayList(String texto) {
        this.texto = texto;
    }

    public abstract ArrayList<Character> toArrayChar();

    public abstract ArrayList<Integer> toArrayInt();

}
