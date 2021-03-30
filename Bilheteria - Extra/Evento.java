import java.util.Map;
import java.util.TreeMap;

public class Evento {
    private String nome;
    private Map<String, Setor> repSetores;

    // gets
    public String getNome() {
        return nome;
    }

    public Map<String, Setor> getRepSetores() {
        return repSetores;
    }

    public void addSetor(Setor setor) throws Exception {
        if (this.repSetores.containsKey(setor.getNome()))
            throw new Exception("Este setor ja esta aqui");

        this.repSetores.put(setor.getNome(), setor);
    }

    Evento(String nome) {
        this.nome = nome;
        this.repSetores = new TreeMap<>();

    }

    public String toString() {
        StringBuilder exit = new StringBuilder();
        exit.append(nome).append("\n");
        for (Map.Entry<String, Setor> setores : this.repSetores.entrySet())
            exit.append(setores.getValue()).append("\n");

        return exit.toString();
    }
}
