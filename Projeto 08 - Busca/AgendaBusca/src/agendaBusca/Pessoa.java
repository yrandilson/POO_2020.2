package agendaBusca;

public class Pessoa {
	protected String nome;
	protected String tel;
	
	public Pessoa(String nome, String tel) {
		this.nome = nome;
		this.tel = tel;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTel() {
		return tel;
	}
}


