package tarifa;

import java.util.ArrayList;

public class Onibus {
	float saldo;
    float valorRecebidoCliente;
    
    ArrayList<Passagem> tarifa;
	Onibus(int numTarifas, int maxPessoas){
        this.saldo = 0;
        this.valorRecebidoCliente = 0;
        this.tarifa = new ArrayList<>();
        int numPessoas = 0;
		for(int i=0; i < numPessoas; i++)
            this.tarifa.add(new Passagem("-", 0, 0));
    }

    void Troco(){
        System.out.println("Você recebeu: " + valorRecebidoCliente + " R$");
        saldo = 0;
    }

    void vender(int index){
        if(valorRecebidoCliente > 0){
            float valorPassagem = tarifa.get(index).valorPassagem;
            saldo = saldo + valorPassagem;
             valorRecebidoCliente = valorRecebidoCliente - valorPassagem;
            tarifa.get(index).quantidadePassagem -= 1;
            
            if(valorRecebidoCliente < 0)
            	valorRecebidoCliente = 0;
            
            if(tarifa.get(index).quantidadePassagem < 0)
                tarifa.get(index).quantidadePassagem = 0;
        }else
            System.out.println("Saldo insuficiente");
    }

    void pagar(float dinheiro){
    	valorRecebidoCliente += dinheiro; 
    }

    void limpar(int index){
        if(index >= 0 && index < tarifa.size()){
            tarifa.remove(index);
            tarifa.add(index, new Passagem("-", 0, 0));
       }
    }

    void altPass(int index, String passagem, int quantidade, float preco){
        if(index >= 0 && index < tarifa.size())
            tarifa.set(index, new Passagem(passagem, quantidade, preco)); 
    }

    public String toString(){
        String exit = "Saldo: " + valorRecebidoCliente + "\n";
        int i = 0;
        for(Passagem tarifa : tarifa){
            exit +=  i + " [" + tarifa.nomePassageiro + " : " + tarifa.quantidadePassagem + " X : " + tarifa.valorPassagem + " R$]\n";
            i++;
        }
        return exit;
    
		
	}

}
