package agendaBusca;

public class listaContatos {
	private static final int MAX = 100;
	private int numeroContatos; 
	
	private Pessoa contatos[];
	
	public listaContatos() {
		numeroContatos = 0;
		contatos = new Pessoa[MAX];	
	}
	
	public void cadastrarContato(Pessoa pessoa) throws Exception {
		if(numeroContatos < MAX) {
			contatos[numeroContatos++] = pessoa;
		}
		else {
			throw new Exception("Numero maximo de contatos permitido");
		}
	}
	
	public Pessoa buscarContato(String nome) {
		for(int i = 0; i < numeroContatos; i++) {
			if(nome.equals(contatos[i].getNome())) {
				return contatos[i];
			}
		}
		
		for(Pessoa p : contatos) {
			if(p != null && nome.equals(p.getNome())) {
				return p;
			}
		}
		
		return null;
	}
	
	public int quantidadeDeContatos() {
		return numeroContatos;
	}
	
	
}



