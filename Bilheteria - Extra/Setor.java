public class Setor {
    private String nome;
    private double preco;
    private int qtd;
    private int capacidade;

    // Gets
    // Gets
    public int getCapacidade() {
        return capacidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void vender() throws Exception {
        if (this.qtd > this.capacidade)
            throw new Exception("Já foi atingido o maximo em cara!!");

        this.qtd++;
    }

    Setor(String nome, double preço, int capacidade) {
        this.nome = nome;
        this.preco = preço;
        this.capacidade = capacidade;
    }

    public void meia() {
        this.preco = preco / 2;
    }

    public String toString() {
        StringBuilder exit = new StringBuilder();
        exit.append("-[").append(nome).append(":").append(preco).append(":").append(qtd).append("/").append(capacidade)
                .append("]");
        return exit.toString();
    }
}