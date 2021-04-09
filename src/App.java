import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada;
        while (true) {
            entrada = new Scanner(System.in);
            System.out.println("Digite os dados da pessoa:");
            String digitos = entrada.next();
            entrada.close();
        }
    }
}
