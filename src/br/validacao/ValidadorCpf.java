package br.validacao;

import java.util.ArrayList;

import br.conversao.StringToArrayList;

public class ValidadorCpf extends Validador {

    public ValidadorCpf(String documento) {
        super(documento);
    }

    @Override
    public boolean isValido() {
        boolean isNumero = new ValidadorNumero(parametro).isValido();
        boolean isTamanho = new ValidadorTamanho(parametro, 11).isValido();
        ArrayList<Integer> listaNumero;
        boolean isDigito1;
        boolean isDigito2;

        if (isNumero && isTamanho) {
            listaNumero = new StringToArrayList(parametro).toArrayInt();
            isDigito1 = formulaCpf(listaNumero, 10) == listaNumero.get(9);
            isDigito2 = formulaCpf(listaNumero, 11) == listaNumero.get(10);
            if (isDigito1 && isDigito2) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private int formulaCpf(ArrayList<Integer> listaNumero, int multiplicador) {
        int soma = 0;
        for (int numero : listaNumero) {
            soma += numero * multiplicador;
            if (multiplicador == 2) {
                break;
            }
            multiplicador--;
        }
        soma *= 10;
        return soma %= 11;
    }

}
