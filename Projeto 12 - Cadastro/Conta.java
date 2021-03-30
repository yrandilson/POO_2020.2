public class Conta {
    protected int id;
    protected float saldo;
    protected String idCliente;
    protected String type;
    protected static int idConta = 0;

    public Conta(String idCliente, String idType) {
        this.idCliente = idCliente;
        this.type = idType;
        this.id = Conta.idConta++;

    }

    public void sacar(float value) throws Exception {
        if (value > this.saldo)
            throw new Exception("Tu quer sacar dinheiro demais mah");

        if (value <= 0)
            throw new Exception("Coloque algum valor sacavel");

        this.saldo -= value;
    }

    public void depositar(float value) throws Exception {
        if (value <= 0)
            throw new Exception("Macho, não tem como sacar um valor menor que zero em");

        this.saldo += value;
    }

    public void transferir(Conta other, float value) throws Exception {
        if (value > this.saldo)
            throw new Exception("Tu nem tem esse dinheiro todo man");

        this.saldo -= value;
        other.depositar(value);
    }

    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();

        exit.append(id).append(":").append(idCliente).append(":").append(saldo).append(":").append(type);

        return exit.toString();
    }
}