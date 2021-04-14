package br.conversao;

import java.util.ArrayList;

public class StringToArrayList extends ToArrayList {

    public StringToArrayList(String texto) {
        super(texto);
    }

    @Override
    public ArrayList<Character> toArrayChar() {
        listaCaractere = new ArrayList<>();
        for (char caractere : texto.toCharArray()) {
            listaCaractere.add(caractere);
        }
        return listaCaractere;
    }

    @Override
    public ArrayList<Integer> toArrayInt() {
        listaInteiro = new ArrayList<>();
        for (char caractere : texto.toCharArray()) {
            listaInteiro.add(Character.getNumericValue(caractere));
        }
        return listaInteiro;
    }
    
}
