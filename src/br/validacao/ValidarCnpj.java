package br.validacao;

import java.util.ArrayList;
import java.util.Collections;

import br.conversao.StringToArrayList;

public class ValidarCnpj extends Validar {

    public ValidarCnpj(String documento) {
        super(documento);
    }

    @Override
    public boolean isValido() {
        boolean isNumero = new ValidarNumero(parametro).isValido();
        boolean isTamanho = new ValidarTamanho(parametro, 11).isValido();
        ArrayList<Integer> listaNumero = new StringToArrayList(parametro).toArrayInt();
        Collections.reverse(listaNumero);
        boolean isDigito1 = formulaCnpj(listaNumero, 1) == listaNumero.get(2);
        boolean isDigito2 = formulaCnpj(listaNumero, 0) == listaNumero.get(1);
        if (isNumero && isTamanho && isDigito1 && isDigito2) {
            return true;
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
