package contato;
import java.util.Scanner;
import java.util.ArrayList;
public class Interativa {

	public static void main(String[] args) {
		int op;
		boolean controle = false;
		Scanner aux = new Scanner(System.in);
		ArrayList<Contatos> lista = new ArrayList<>();
		
		do {
			System.out.println("Menu - \n1 - Cadastrar contato \n2 - Exibir contatos");
			System.out.println("3 - Remover contato \n4 - Sair");
			op=aux.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("");
				Contatos contato = new Contatos();
				lista.add(contato);
				System.out.println("Contato cadastrado com sucesso. \n");
				break;
			
			case 2:
				int tamanhoLista = lista.size();
				if(tamanhoLista>0) {
					System.out.println("Total de contatos cadastrados: "+tamanhoLista);
					for(int i = 0; i<tamanhoLista; i++) {
						lista.get(i).imprime();
						System.out.println("");
					}
				}else
					System.out.println("Não há contatos cadastrados.\n");
				break;
				
			case 3:
				System.out.println("\nQual o nome do contato a ser removido?");
				aux.nextLine();
				String nome = aux.nextLine();
				controle = false;
				for(int i=0; i<lista.size(); i++) {
					if(nome.equals(lista.get(i).nome)) {
					lista.remove(i);
					controle=true;
				}
			}
		
				
		
				if(controle) {
					System.out.println("Contato removido com sucesso.\n");
				}else
					System.out.println("Esse contato não está na base de dados. \n");
				break;
			
			case 4:
				System.out.println("Até breve.\n");
				break;
				
			default:
				System.out.println("Opção inválida. ");
					
		}
				
		}while(op!=4);

	}
}
