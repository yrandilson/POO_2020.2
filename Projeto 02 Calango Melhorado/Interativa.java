import java.util.Scanner;

public class Interativa {
    public static void main(String[] args) {
        Calango c = new Calango(4, 10, 4);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("A execução so para quando o calango morrer");
            System.out.println(
                    "O calango tem as seguintes formas de interação:\n'regenerar'\n'comer, junto com a quantidade'\n'andar'\n'acidentar'\n");
            String op = scanner.nextLine();
            String[] brok = op.split(" ");
            try {
                if (brok[0].equals("regenerar"))
                    c.regenerar();

                else if (brok[0].equals("comer"))
                    c.comer(Integer.parseInt(brok[1]));

                else if (brok[0].equals("andar"))
                    c.andar();
                else if (brok[0].equals("acidentar"))
                    c.acidentar();

                if (c.nPatas == 0) {
                    System.out.println("Calango morreu sem pata o pobre");
                    break;
                }
                System.out.println("\nDeadlango: " + c + "\n");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Erro nos index");
            } catch (Exception z) {
                System.out.println(z);
            }
        }
    }
}
