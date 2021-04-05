public class Validacao {
    private String documento;

    public Validacao(String documento) {
        setDocumento(documento);
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean cpfValido() {
        boolean tamanhoCpf = getDocumento().length() == 11;
        boolean primeiroDigito = digitoCpfValido(getDocumento().getBytes(), (byte) 10);
        boolean segundoDigito = digitoCpfValido(getDocumento().getBytes(), (byte) 11);
        if (tamanhoCpf && primeiroDigito && segundoDigito) {
            return true;
        } else {
            return false;
        }

    }

    private boolean digitoCpfValido(byte[] cpf, byte indice) {
        byte digito = 0;
        for (byte contador = indice; contador >= 2; contador--) {
            digito += cpf[Math.abs(contador - indice)] * contador;
        }
        digito *= 10;
        return cpf[indice] == (digito % 11);
    }

    public boolean cnpjValido() {
        boolean tamanhoCnpj = getDocumento().length() == 11;
        boolean primeiroDigito = digitoCnpjValido(getDocumento().getBytes(), (byte) 12);
        boolean segundoDigito = digitoCnpjValido(getDocumento().getBytes(), (byte) 13);
        if (tamanhoCnpj && primeiroDigito && segundoDigito) {
            return true;
        } else {
            return false;
        }
    }

    private boolean digitoCnpjValido(byte[] cnpj, byte indice) {
        byte digito = 0;
        final byte INDICE = indice;
        for (byte contador = 2; contador < indice; contador++) {
            if (contador == 10) {
                contador = 2;
            }
            indice--;
            digito += cnpj[indice] * contador;
        }
        digito *= 10;
        return cnpj[INDICE] == (digito % 11);
    }

}
