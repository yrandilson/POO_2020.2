import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Digite o quanto quer de resistencia!");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        TrocaTiro t = new TrocaTiro(i);

        while (true) {
            System.out.println(
                    "Digite 'Tiro', e o nome da arma\nDigite 'mostrar' para mostrar o debito\nDigite 'Armas', para voce ver as armas e suas letalidades\nA execução acaba quando você morrer\n");
            String escolha = scan.nextLine();
            String[] brok = escolha.split(" ");
            try {
                if (t.dead == true) {
                    System.out.println("Vamos encerrar, você morreu");
                    break;
                }
                if (brok[0].equalsIgnoreCase("tiro")) {
                    if (brok[1].equalsIgnoreCase(Armas.AK47.toString())) {
                        t.tiro(Armas.AK47);
                    } else if (brok[1].equalsIgnoreCase(Armas.ESCOPETA.toString())) {
                        t.tiro(Armas.ESCOPETA);
                    } else if (brok[1].equalsIgnoreCase(Armas.FACA.toString())) {
                        t.tiro(Armas.FACA);
                    } else if (brok[1].equalsIgnoreCase(Armas.PISTOLA.toString())) {
                        t.tiro(Armas.PISTOLA);
                    } else if (brok[1].equalsIgnoreCase(Armas.PUNHAL.toString())) {
                        t.tiro(Armas.PUNHAL);
                    } else if (brok[1].equalsIgnoreCase(Armas.RIFLE.toString())) {
                        t.tiro(Armas.RIFLE);
                    }
                    System.out.println("Vida: " + t.life + "\n");
                } else if (brok[0].equalsIgnoreCase("Armas")) {
                    t.mostrar();
                } else if (brok[0].equalsIgnoreCase("mostrar")) {
                    System.out.println(t + "\n");
                } else
                    System.out.println("Digite uma opção valida");
                System.out.println("\n");
            } catch (IndexOutOfBoundsException z) {
                System.out.println("Erro de index em");
            } catch (Exception y) {
                System.out.println(y.toString());
            }
        }
    }
}
