import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bilheteria {
    private ArrayList<Venda> repVendas;
    private Map<String, Pessoa> repPessoas;
    private Map<String, Evento> repEventos;
    private double caixa;

    // gets
    public double getCaixa() {
        return caixa;
    }

    public Map<String, Evento> getRepEventos() {
        return repEventos;
    }

    public Map<String, Pessoa> getRepPessoas() {
        return repPessoas;
    }

    public List<Venda> getRepVendas() {
        return repVendas;
    }

    Bilheteria() {
        this.repVendas = new ArrayList();
        this.repEventos = new TreeMap<>();
        this.repPessoas = new TreeMap<>();
        this.caixa = 0;
    }

    public void vender(String cliente, String evento, String setor) throws Exception {
        if (!this.repEventos.containsKey(evento))
            throw new Exception("Não existe este evento pow");

        if (!this.repEventos.get(evento).getRepSetores().containsKey(setor))
            throw new Exception("Este setor não existe");

        if (!this.repPessoas.containsKey(cliente))
            throw new Exception("Esta pessoa não existe aqui");

        for (Venda venda : repVendas)
            if (venda.getCliente().getNome().equalsIgnoreCase(cliente))
                throw new Exception("Você já está em um show!");

        this.repVendas.add(new Venda(repPessoas.get(cliente), repEventos.get(evento),
                repEventos.get(evento).getRepSetores().get(setor)));

        this.repEventos.get(evento).getRepSetores().get(setor).vender();

        this.caixa += this.repEventos.get(evento).getRepSetores().get(setor).getPreco();
    }

    public String showCaixa() {
        return "R$ " + caixa;
    }

    public String showVendas() {
        StringBuilder exit = new StringBuilder();
        for (Venda vendas : repVendas) {
            exit.append("[ ").append(vendas).append(" ]").append("\n");
        }
        return exit.toString();
    }

    public String showPessoas() {
        StringBuilder exit = new StringBuilder();
        for (Map.Entry<String, Pessoa> pessoas : repPessoas.entrySet()) {
            exit.append("[ ").append(pessoas.getValue()).append(" ]").append("\n");
        }
        return exit.toString();
    }

    public String showEventos() {
        StringBuilder saida = new StringBuilder();
        for (Map.Entry<String, Evento> eventos : repEventos.entrySet()) {
            saida.append(eventos.getValue()).append("\n");
        }
        return saida.toString();
    }

    public void addPessoa(String nome, boolean meia) throws Exception {
        if (this.repPessoas.containsKey(nome))
            throw new Exception("Essa pessoa ja está aqui man!!");

        repPessoas.put(nome, new Pessoa(nome, meia));
    }

    public void addEvento(String idEvento) throws Exception {
        if (this.repEventos.containsKey(idEvento))
            throw new Exception("Este evento já existe cara!!");

        this.repEventos.put(idEvento, new Evento(idEvento));
    }

    public void addSetor(String idEvento, String idSetor, Double preco, int capacidade) throws Exception {
        if (this.repEventos.get(idEvento).getRepSetores().containsKey(idSetor))
            throw new Exception("Setor ja existe cara");

        this.repEventos.get(idEvento).addSetor(new Setor(idSetor, preco, capacidade));
    }
}
