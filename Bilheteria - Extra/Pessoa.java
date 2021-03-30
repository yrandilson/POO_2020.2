public class Pessoa {
    private String nome;
    private boolean meia;

    // get
    public String getNome() {
        return nome;
    }

    public boolean getMeia() {
        return meia;
    }

    Pessoa(String nome, boolean pagaMeia) {
        this.nome = nome;
        this.meia = pagaMeia;
    }

    public String toString() {
        StringBuilder exit = new StringBuilder();
        exit.append("[").append(nome).append(", ");
        if (this.meia) {
            exit.append("SIM]");
            return exit.toString();
        }
        exit.append("NÃO]");
        return exit.toString();
    }
}
