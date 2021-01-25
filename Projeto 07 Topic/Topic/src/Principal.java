import java.util.Scanner;

public class Principal {

	public static Scanner ir = new Scanner(System.in);
    public static void main(String args[]){
        
        Cinematografia c = new Cinematografia();
        
        String ajuda = "\n"+
                      "Programa: exibe os assentos disponíveis \n"+
                      "reservar: reserva um assento: nome, Ientifcação e numeração do assento \n"+
                      "exit: Encerra o sistema de reserva do cinema\n"+
                      "====================================================================";
        
        System.out.print("Informe o número de assentos a ser reservado: ");
        int tamanho = ir.nextInt();
        c.Tamanho(tamanho);
        c.Assentos(new Usuario[tamanho]);
        c.Programa(new String[tamanho]);
        ir.nextLine();
        System.out.println("Cinematografia Começando!");
        
        
        while (true){
            
            System.out.println("\n"+
            "Escolha:  \n"+
            "(Digite ajuda para mais opções)");
            String instrucao = ir.nextLine();
            if (instrucao.equals("exit")){
                break;
            }
            switch (instrucao){
                case "ajuda":
				
				System.out.println(ajuda);
                    break;
                case "programa":
                    c.status();
                    break;
                case "reservar":
                    if(!c.Lotada()){
                        System.out.print("Informe o nome: ");
                        String nome = ir.nextLine();
                        System.out.print("Informe a identificação: ");
                        String identificacao = ir.nextLine();
                        System.out.print("Informe o assento: ");
                        int assento = ir.nextInt();
                        ir.nextLine();
                        
                        if (assento<=0||assento>tamanho){
                            System.out.println("\n"+"Assento não existe.");
                        }else{
                            c.reservar(nome, identificacao, assento);
                        }
                    }else{
                        System.out.println("\n"+"Sem reservas, a cinematografia está Lotada.");
                    }
                    break;
                case "cancelar":
                    if(!c.fazerReservas()){
                        System.out.println("\n"+"Não há ninguém na cinematografia");
                    }else{
                        System.out.print("Informe a identificação: ");
                        String codigo = ir.nextLine();
                        c.anular(codigo);
                    }
                    break;
                default:
                    System.out.print("Tente novamente");
                    break;   
            }
        }
    }       
}