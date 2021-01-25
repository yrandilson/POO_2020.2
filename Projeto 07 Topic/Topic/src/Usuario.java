
public class Usuario {
	public String nome;
    public String rg;
    public String identificacao;
    public int assento;


public Usuario(String nome, String identificacao, int assento) {
    this.nome = nome;
    this.identificacao = identificacao;
    this.assento = assento;
}




public void Nome(String nome) {
    this.nome = nome;
}


public void RG(String rg) {
    this.rg = rg;
}



public void Identificao(String id, String identificacao) {
    this.identificacao = identificacao;
}



public void Assento(int assento) {
    this.assento = assento;
}


public String toString(){
    String x = nome;
    return x;
}

public String nome() {
	
	return null;
}    
}