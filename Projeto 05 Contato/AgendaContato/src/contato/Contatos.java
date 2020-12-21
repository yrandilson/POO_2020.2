package contato;

import java.util.Scanner;

public class Contatos {
	String nome;
	int contato;
	Scanner aux = new Scanner(System.in);
	
	Contatos(){
		System.out.println("Nome do contato: ");
		nome = aux.nextLine();
		System.out.println("Contato: ");
		contato = aux.nextInt();
	}
	void imprime() {
		System.out.println("Nome: "+nome);
		System.out.println("Contato: "+contato);
	}
}
