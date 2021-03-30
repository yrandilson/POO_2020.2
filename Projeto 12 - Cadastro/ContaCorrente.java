public class ContaCorrente extends Conta implements AtualizMensal {
    private float tarifaMensal;

    public ContaCorrente(String idCliente) {
        super(idCliente, "CC");
        this.tarifaMensal = 20;
    }

    @Override
    public void atualiazacaoMensal() {
        this.saldo -= this.tarifaMensal;

    }

}
