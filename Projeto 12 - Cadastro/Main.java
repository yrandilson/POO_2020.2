import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Agencia controller = new Agencia();

        while (true) {
            System.out.println("Digite: \n 'addCliente' - nome do Cliente \n 'Sacar' - index da conta - valor(float)");
            System.out.println(
                    " 'Depositar' - index da conta - valor(float) \n 'Transferir' - index da conta que envia - index Recebe - value(float)");
            System.out.println(
                    " 'update', para efetuar as atualizações do banco\n 'show', para ver tudo\n 'sair', para sair");
            String opcao = scan.nextLine();
            String[] brok = opcao.split(" ");

            try {
                if (brok[0].equalsIgnoreCase("sair"))
                    break;

                else if (brok[0].equalsIgnoreCase("show"))
                    System.out.println(controller);

                else if (brok[0].equalsIgnoreCase("addCliente"))
                    controller.addCliente(brok[1]);

                else if (brok[0].equalsIgnoreCase("Sacar"))
                    controller.sacar(Integer.parseInt(brok[1]), Float.parseFloat(brok[2]));

                else if (brok[0].equalsIgnoreCase("Depositar"))
                    controller.depositar(Integer.parseInt(brok[1]), Float.parseFloat(brok[2]));

                else if (brok[0].equalsIgnoreCase("Transferir"))
                    controller.transferir(Integer.parseInt(brok[1]), Integer.parseInt(brok[2]),
                            Float.parseFloat(brok[3]));

                else if (brok[0].equalsIgnoreCase("update"))
                    controller.update();

                else
                    System.out.println("Option not found");

            } catch (IndexOutOfBoundsException y) {
                System.out.println("Erro nos index brow");
            } catch (Exception z) {
                System.out.println(z.toString());
            }
        }
        scan.close();
    }
}
