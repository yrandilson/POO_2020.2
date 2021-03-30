public class Venda {
    private Pessoa cliente;
    private Evento evento;
    private Setor setor;
    private double valor;

    // Gets
    public Pessoa getCliente() {
        return cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public Setor getSetor() {
        return setor;
    }

    public double getValor() {
        return valor;
    }

    Venda(Pessoa cliente, Evento evento, Setor setor) {
        this.cliente = cliente;
        this.evento = evento;
        this.setor = setor;

        if (this.cliente.getMeia())
            this.setor.meia();
    }

    public String toString() {
        StringBuilder exit = new StringBuilder();
        exit.append("[").append(cliente.getNome()).append(", ").append(evento.getNome()).append(", ")
                .append(setor.getNome()).append(", ").append(setor.getPreco());

        return exit.toString();
    }
}
