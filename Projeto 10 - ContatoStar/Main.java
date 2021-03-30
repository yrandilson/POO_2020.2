import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Agenda ag = new Agenda();
        AgendaPlus agPlus = new AgendaPlus();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Digite 'exit'\n'AddContact' - 'name' - 'list of contacts' ex: tim:4455 oi:8248");
            System.out
                    .println("'bookmark' - 'name'\n'unbookmark' - 'name'\n'RmContact'-'name'\n'ShowContact' - 'name'");
            System.out.println("'GetBookmark' - 'name'\n'RmFone' - 'name' - 'index'\n'show'");
            String opcao = scan.nextLine();
            String[] brok = opcao.split(" ");
            try {
                if (brok[0].equalsIgnoreCase("exit"))
                    break;

                else if (brok[0].equalsIgnoreCase("addContact")) {
                    ArrayList<Fone> fones = new ArrayList<>();
                    // for para percorrer toda lista fones digitadas, lembrando que começa de 2
                    // porque o brok[1] já é a key de contato
                    for (int i = 2; i < brok.length; i++) {
                        // quebrei de novo em : e o index 0 significa o da esqueda do : e o [1]
                        // significa o da direita, no caso tim:455
                        String label = brok[i].split(":")[0];
                        String number = brok[i].split(":")[1];
                        fones.add(new Fone(label, number));
                    }
                    agPlus.addContact(brok[1], fones);
                }

                else if (brok[0].equalsIgnoreCase("bookmark"))
                    agPlus.bookmark(brok[1]);

                else if (brok[0].equalsIgnoreCase("unbookmark"))
                    agPlus.unbookmark(brok[1]);

                else if (brok[0].equalsIgnoreCase("RmContact"))
                    agPlus.rmContact(brok[1]);

                else if (brok[0].equalsIgnoreCase("showContact"))
                    System.out.println(ag.getContact(brok[1]));

                else if (brok[0].equalsIgnoreCase("getbookmark"))
                    System.out.println(agPlus.setBookMark().values());

                else if (brok[0].equalsIgnoreCase("RmFone"))
                    agPlus.getContact(brok[1]).get(brok[1]).rmFone(Integer.parseInt(brok[2]));

                else if (brok[0].equalsIgnoreCase("show"))
                    System.out.println(agPlus);

                else
                    System.out.println("Digite uma opção valida");
            } catch (NullPointerException z) {
                System.out.println(z.toString());
            } catch (IndexOutOfBoundsException z) {
                System.out.println("Erro nos index ai");
            } catch (Exception y) {
                System.out.println(y.toString());
            }
        }
    }
}
