package agendaBusca;
import java.util.Scanner;



public class Agenda {private Scanner aux;
private listaContatos aux2; 

public Agenda() {
	aux = new Scanner(System.in);
	aux2 = new listaContatos();
}

public static void main(String args[]) {

	System.out.println(" AGENDA UFC");
	
	
	Agenda agenda = new Agenda();
	
	agenda.menuPrincipal();
}

public void menuPrincipal() {
	System.out.println("\n");	
	System.out.println(" Selecione uma das opcoes: \n ");
	System.out.println(" 1 - Cadastrar Contato ");
	System.out.println(" 2 - Buscar Contato");
	System.out.println(" 3 - Sair");
	
	int opcao = aux.nextInt();
	
	switch(opcao) {
	case 1: 
		menuCadastrarPessoa();
		break;
		
	case 2: 
		menuBuscarContato();
		break;
		
	case 3: 
		System.out.println("Até breve... \n \n"); 
		System.exit(0);
		break;
	
	default: 
		System.out.println("\n \nOpcao invalida! Tente novamente. \n"); 
		menuPrincipal();
	}
	
}

private void menuCadastrarPessoa() {
	System.out.println("Informe o nome: ");
	String nome = aux.next();
	System.out.println("Informe o telefone: ");
	String tel = aux.next();
	
	try {
		aux2.cadastrarContato(new Pessoa(nome, tel));
		System.out.println("Contato adicionado com sucesso");
	}
	catch(Exception e) {
		System.out.println("Erro na inclusao do Contato");
		System.out.println(e.getMessage());
	}
	menuPrincipal();
}

private void menuBuscarContato() {
	System.out.println("Informe o nome do contato: ");
	String nome = aux.next();
	
	Pessoa pessoa = aux2.buscarContato(nome);
	if(pessoa == null){
		System.out.println("Contato nao encontrada.");
	}
	else {
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Tel.:" + pessoa.getTel());
	}
	System.out.println("Pressione qualquer tecla para voltar");
	aux.nextLine();
	menuPrincipal();
}
}
	


