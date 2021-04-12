package br;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class ValidacaoDocumento {

    public boolean ehCpf(String documento) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        return ehDocumento(documento, 11, "validarCpf");
    }

    public boolean ehCnpj(String documento) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        return ehDocumento(documento, 14, "validarCnpj");
    }

    private boolean ehDocumento(String documento, int tamanho, String nomeMetodo) throws NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean ehTamanho = documento.length() == tamanho;
        if (ehTamanho && ehConversivel(documento)) {
            ArrayList<Integer> listaNumero = stringParaArrayInt(documento);
            Method validar = this.getClass().getDeclaredMethod(nomeMetodo, new Class[] { ArrayList.class });
            return ((boolean) validar.invoke(this, listaNumero));
        } else {
            return false;
        }
    }

    private boolean ehConversivel(String documento) {

        try {
            Long.parseLong(documento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private ArrayList<Integer> stringParaArrayInt(String string) {
        ArrayList<Integer> numero = new ArrayList<>();
        for (char caractere : string.toCharArray()) {
            numero.add(Character.getNumericValue(caractere));
        }
        return numero;
    };

    private boolean validarCpf(ArrayList<Integer> listaNumero) {
        boolean digito1valido = formulaCpf(listaNumero, 10) == listaNumero.get(9);
        boolean digito2valido = formulaCpf(listaNumero, 11) == listaNumero.get(10);
        if (digito1valido && digito2valido) {
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

    private boolean validarCnpj(ArrayList<Integer> listaNumero) {
        Collections.reverse(listaNumero);
        boolean digito1valido = listaNumero.get(1) == formulaCnpj(listaNumero, 2);
        boolean digito2valido = listaNumero.get(0) == formulaCnpj(listaNumero, 1);
        if (digito1valido && digito2valido) {
            return true;
        } else {
            return false;
        }
    }

    // 98209036000184
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