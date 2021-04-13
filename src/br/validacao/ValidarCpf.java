package br.validacao;

import java.util.ArrayList;

import br.conversao.StringToArrayList;

public class ValidarCpf extends Validar {

    public ValidarCpf(String documento) {
        super(documento);
    }

    @Override
    public boolean isValido() {
        boolean isNumero = new ValidarNumero(parametro).isValido();
        boolean isTamanho = new ValidarTamanho(parametro, 11).isValido();
        ArrayList<Integer> listaNumero = new StringToArrayList(parametro).toArrayInt();
        boolean isDigito1 = formulaCpf(listaNumero, 10) == listaNumero.get(9);
        boolean isDigito2 = formulaCpf(listaNumero, 11) == listaNumero.get(10);
        if (isNumero && isTamanho && isDigito1 && isDigito2) {
            return true;
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
