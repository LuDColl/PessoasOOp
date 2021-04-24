import java.util.Scanner;

import br.pessoa.Cadastro;

public class Menu {
    private Cadastro cadastro;
    private Scanner entrada;
    private boolean continuar;

    public Menu() {
        this.cadastro = new Cadastro();
        this.entrada = new Scanner(System.in);
        this.continuar = true;
        execucao();
    }

    private void execucao() {
        while (continuar)

        {
            System.out.println("Quer adicionar uma pessoa física ou juridica ao cadastro?");
            System.out.println("respostas: 'fisica', 'juridica' e 'nenhuma'");
            String pessoa = entrada.next();
            String nome, documento;
            switch (pessoa) {
            case "nenhuma":
                continuar = false;
                break;
            case "fisica":
                System.out.println("Digite o nome da pessoa:");
                nome = entrada.next();
                System.out.println("Digite o CPF da pessoa:");
                documento = entrada.next();
                cadastro.addPessoaFisica(nome, documento);
                break;
            case "juridica":
                System.out.println("Digite o nome da pessoa:");
                nome = entrada.next();
                System.out.println("Digite o CNPJ da pessoa:");
                documento = entrada.next();
                cadastro.addPessoaJuridica(nome, documento);
                break;

            default:
                System.out.println("Resposta inválida!");
                break;
            }

        }
        cadastro.imprimirCadastro();
        entrada.close();
    }

}
