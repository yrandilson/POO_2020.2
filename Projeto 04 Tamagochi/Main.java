import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Pet tam = new Pet(20, 10, 15);
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Digite shower, para dar banho");
            System.out.println("Digite play");
            System.out.println("Digite sleep");
            System.out.println("Digite eat");
            System.out.println("Digite end");
            String escolha = scan.nextLine();

            try {
                if (escolha.equalsIgnoreCase("end")) {
                    System.out.println("Encerrando");
                    System.out.println(tam);
                    break;
                }

                else if (escolha.equalsIgnoreCase("shower")) {
                    tam.shower();
                    System.out.println(tam);
                } else if (escolha.equalsIgnoreCase("play")) {
                    tam.play();
                    System.out.println(tam);
                } else if (escolha.equalsIgnoreCase("sleep")) {
                    tam.sleep();
                    System.out.println(tam);
                } else if (escolha.equalsIgnoreCase("eat")) {
                    tam.eat();
                    System.out.println(tam);
                }
                System.out.println("\n");
            } catch (IndexOutOfBoundsException y) {
                System.out.println("\n#Erro de index\n");
            } catch (Exception z) {
                System.out.println(z.toString());
            }

        }
        scan.close();
    }
}
