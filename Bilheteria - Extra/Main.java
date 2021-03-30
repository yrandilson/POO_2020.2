import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Bilheteria controller = new Bilheteria();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Digite os seguintes comandos: \n'Vender', String dos: Cliente - evento - setor\n");
            System.out.println("'ShowCaixa', para mostrar o debito\n");
            System.out.println("'showVendas', para mostrar todas as vendas até o momento\n");
            System.out.println("'showPessoas', para mostrar as pessoas aqui neste evento\n");
            System.out.println("'showEventos', para mostrar os eventos\n");
            System.out.println("'addPessoa', nome - meia(inteira ou meia)\n");
            System.out.println("'addEvento', nome do evento\n");
            System.out.println("'addSetor', idEvento - idSetor - preco - capacidade\n");
            System.out.println("'Sair'\n");

            String opcao = scan.nextLine();
            String brok[] = opcao.split(" ");

            try {
                if (brok[0].equalsIgnoreCase("sair"))
                    break;

                else if (brok[0].equalsIgnoreCase("Vender"))
                    controller.vender(brok[1], brok[2], brok[3]);

                else if (brok[0].equalsIgnoreCase("ShowCaixa"))
                    System.out.println(controller.showCaixa());

                else if (brok[0].equalsIgnoreCase("showVendas"))
                    System.out.println(controller.showVendas());

                else if (brok[0].equalsIgnoreCase("showPessoas"))
                    System.out.println(controller.showPessoas());

                else if (brok[0].equalsIgnoreCase("showEventos"))
                    System.out.println(controller.showEventos());

                else if (brok[0].equalsIgnoreCase("AddEvento"))
                    controller.addEvento(brok[1]);

                else if (brok[0].equalsIgnoreCase("AddSetor"))
                    controller.addSetor(brok[1], brok[2], Double.parseDouble(brok[3]), Integer.parseInt(brok[4]));

                else if (brok[0].equalsIgnoreCase("addPessoa")) {
                    if (brok[2].equalsIgnoreCase("Meia"))
                        controller.addPessoa(brok[1], true);
                    else
                        controller.addPessoa(brok[1], false);
                } else
                    System.out.println("Digite um comando valido!");
            } catch (IndexOutOfBoundsException y) {
                System.out.println("Erro nos index pow");
            } catch (Exception z) {
                System.out.println(z.toString());
            }
        }
    }
}
