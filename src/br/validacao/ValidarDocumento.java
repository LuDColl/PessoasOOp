package br.validacao;

public class ValidarDocumento extends Validar{

    @Override
    public boolean isValido(String argumento) {
        if (ehTamanho && ehConversivel(documento)) {
            ArrayList<Integer> listaNumero = stringParaArrayInt(documento);
            Method validar = this.getClass().getDeclaredMethod(nomeMetodo, new Class[] { ArrayList.class });
            return ((boolean) validar.invoke(this, listaNumero));
        } else {
            return false;
        }
    }
    
}
