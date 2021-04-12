package br.validacao;

public class Convercao {
    

    public boolean ehConversivel(String documento) {
        try {
            Long.parseLong(documento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
