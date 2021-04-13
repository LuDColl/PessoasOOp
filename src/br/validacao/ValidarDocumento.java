package br.validacao;

public class ValidarDocumento extends Validar {

    private int tamanho;

    public ValidarDocumento(String documento, int tamanho) {
        super(documento);
        this.tamanho = tamanho;
    }

    @Override
    public boolean isValido() {
        boolean isTamanho = new ValidarTamanho(parametro, tamanho).isValido();
        boolean isConversivel = new ValidarNumero(parametro).isValido();
        if (isTamanho && isConversivel) {
            ArrayList<Integer> listaNumero = stringParaArrayInt(documento);
            Method validar = this.getClass().getDeclaredMethod(nomeMetodo, new Class[] { ArrayList.class });
            return ((boolean) validar.invoke(this, listaNumero));
        } else {
            return false;
        }
    }

}
