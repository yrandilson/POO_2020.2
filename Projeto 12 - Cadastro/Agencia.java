import java.util.ArrayList;

public class Agencia {
    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    public Agencia() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    private Cliente getClient(String idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(idCliente))
                return cliente;

        }
        return null;
    }

    public void addCliente(String idCliente) throws Exception {
        if (this.getClient(idCliente) != null) {
            throw new Exception("Cliente já Tá aqui man");
        }

        Cliente cliente = new Cliente(idCliente);
        ContaCorrente contaCorrente = new ContaCorrente(idCliente);
        ContaPoupanca contaPoupanca = new ContaPoupanca(idCliente);

        cliente.getContas().add(contaCorrente);
        cliente.getContas().add(contaPoupanca);

        this.clientes.add(cliente);
        this.contas.add(contaCorrente);
        this.contas.add(contaPoupanca);
    }

    private Conta getConta(int idConta) {
        for (Conta conta : contas) {
            if (conta.id == idConta) {
                return conta;
            }
        }
        return null;
    }

    public void sacar(int idConta, float value) throws Exception {
        Conta contaAux = this.getConta(idConta);

        if (contaAux == null)
            throw new Exception("Esta conta nao existe pow");

        contaAux.sacar(value);
    }

    public void depositar(int idConta, float value) throws Exception {
        Conta contaAuxx = this.getConta(idConta);

        if (contaAuxx == null)
            throw new Exception("Esta conta nao existe pow");

        contaAuxx.depositar(value);
    }

    public void transferir(int idContaEnvia, int idContaRecebe, float value) throws Exception {
        Conta contaEnvia = this.getConta(idContaEnvia);
        Conta contaRecebe = this.getConta(idContaRecebe);

        if (contaEnvia == null)
            throw new Exception("Está conta não existe, a que envia o dinheiro");

        if (contaRecebe == null)
            throw new Exception("Esta conta que recebe nao existe");

        contaEnvia.transferir(contaRecebe, value);
    }

    public void update() {
        for (Conta contass : this.contas) {
            if (contass instanceof ContaCorrente) {
                ContaCorrente contaCorrente = (ContaCorrente) contass;
                contaCorrente.atualiazacaoMensal();
            } else {
                ContaPoupanca contaPoupanca = (ContaPoupanca) contass;
                contaPoupanca.atualiazacaoMensal();
            }

        }
    }

    public String toString() {
        StringBuilder exit = new StringBuilder();

        for (Conta conta : contas)
            exit.append(conta).append("\n");

        return exit.toString();

    }

}
