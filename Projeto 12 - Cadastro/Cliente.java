import java.util.ArrayList;

public class Cliente {
    protected String id;
    protected ArrayList<Conta> contas;

    public Cliente(String id) {
        this.id = id;
        this.contas = new ArrayList<>();
    }

    // gets
    public ArrayList<Conta> getContas() {
        return contas;
    }

    public String getId() {
        return id;
    }

}
