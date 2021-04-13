package br.conversao;

import java.util.ArrayList;

public class StringToArrayList extends ToArrayList {

    public StringToArrayList(String texto) {
        super(texto);
    }

    @Override
    public ArrayList<String> toArrayString() {
        return null;
    }

    @Override
    public ArrayList<Integer> toArrayInt() {
        listaInteiro = new ArrayList<>();
        for (char caractere : texto.toCharArray()) {
            listaInteiro.add(Character.getNumericValue(caractere));
        }
        return listaInteiro;
    }

    @Override
    public ArrayList<Float> toArrayFloat() {
        return null;
    }

    @Override
    public ArrayList<Double> toArrayDouble() {
        return null;
    }
    
}
