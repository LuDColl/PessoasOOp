import java.util.ArrayList;

import pessoas.Pessoa;

public class Cadastro {
    ArrayList<Pessoa> cadastros;

    public Cadastro(String nome, String documento) {
        cadastros = new ArrayList<Pessoa>();
        setPessoa(nome);
    }

    public void setPessoa(String nome) {
        cadastros.add(new Pessoa(nome));
    }
}
