
public class Cinematografia {
	public int tamanho;
    public Usuario assentos[]= new Usuario[tamanho];
    public String programa[] = new String[tamanho];



    public void status(){
        System.out.println("\n");
        for(int i = 0; i<tamanho;i++){
            if (programa[i]==null){
                programa[i] = "-   ";
            }
        }
        for(String y: programa){
            System.out.print(y);    
        }
        System.out.println("\n");    
    }
    
    public void reservar(String nome, String identificacao, int assento){
        boolean saida = false;
        
        String identificacao2 = identificacao;
		for(int i=0;i<programa.length;i++){
            if(assentos[i]!=null && assentos[i].equals(identificacao2)){
                saida=true;
            }
        }
        if (assentos[assento-1]==null && saida==false){
            programa[assento-1]= nome+"   ";
            assentos[assento-1] = new Usuario(nome,identificacao2,assento);
            System.out.println("\n"+"Assento reservado!");
        }else if(saida==true){
            System.out.println("\n"+": Identificação já existente");
        }else{
            System.out.println("\n"+" Assento já está reservado");
        }
    }
    
    public void anular(String id){
        boolean saida = false;
        String help = null;
        for (int i = 0; i < assentos.length;i++){
            Object identificacao = null;
			if(assentos[i]!=null && assentos[i].equals(identificacao)){
                help = assentos[i].nome();
                assentos[i]=null;
                programa[i]="-   ";
                saida = true;
                
            }
        }
        if (saida==false){
            System.out.println("\n"+" Identificação não localizado");
        }else{
            System.out.println("\n"+"Reserva de "+help+" cancelada");
        }
    }
    
    public boolean fazerReservas(){
        boolean z = false;
        for (Usuario assento : assentos) {
            if (assento != null) {
                z=true;
            }
        }
        return z;
    }
    
    
    public boolean Lotada(){
        boolean x = false;
        int cont = 0;
        for (Usuario assento : assentos) {
            if (assento != null) {
                cont++;
            }
        }
        if(cont==tamanho){
            x=true;
        }
        return x;
    }

  
    public void Tamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void Assentos(Usuario[] assentos) {
        this.assentos = assentos;
    }

   
    public void Programa(String[] programa) {
        this.programa = programa;
    }

	
		
	}



