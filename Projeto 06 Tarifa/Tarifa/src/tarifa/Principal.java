package tarifa;

public class Principal {

	public static void main(String[] args) {
		Onibus transporte = new Onibus(5, 7);

        //Inserir destino viagem
        transporte.altPass(0, "Fortaleza", 6, 17.50f);
         

        //Remover destino
        transporte.limpar(1);

        //pagar
        transporte.pagar(5f);
        

        //Vender passagem
        transporte.vender(1);
        
        
        //Troco recebido
        transporte.Troco();

        System.out.println(transporte);

    }
}


