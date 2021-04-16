package br.validacao;

import java.util.ArrayList;
import java.util.Collections;

import br.conversao.StringToArrayList;

public class ValidadorCnpj extends Validador {

    public ValidadorCnpj(String documento) {
        super(documento);
    }

    @Override
    public boolean isValido() {
        boolean isNumero = new ValidadorNumero(parametro).isValido();
        boolean isTamanho = new ValidadorTamanho(parametro, 14).isValido();
        ArrayList<Integer> listaNumero;
        boolean isDigito1;
        boolean isDigito2;
        if (isNumero && isTamanho) {
            listaNumero = new StringToArrayList(parametro).toArrayInt();
            Collections.reverse(listaNumero);
            isDigito1 = formulaCnpj(listaNumero, 2) == listaNumero.get(1);
            isDigito2 = formulaCnpj(listaNumero, 1) == listaNumero.get(0);
            if (isDigito1 && isDigito2) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private int formulaCnpj(ArrayList<Integer> listaNumero, int indiceInicial) {
        short soma = 0;
        byte multiplicador = 2;
        for (int indice = indiceInicial; indice < 14; indice++) {
            soma += listaNumero.get(indice) * multiplicador;
            if (multiplicador == 9) {
                multiplicador = 2;
                continue;
            }
            multiplicador++;
        }
        soma %= 11;
        if (soma == 0 || soma == 1) {
            return 0;
        } else {
            return 11 - soma;
        }
    }

}
