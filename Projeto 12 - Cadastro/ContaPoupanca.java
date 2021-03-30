public class ContaPoupanca extends Conta implements AtualizMensal {
    private double rendimento;

    public ContaPoupanca(String idCliente) {
        super(idCliente, "CP");
        this.rendimento = 1.01;
    }

    @Override
    public void atualiazacaoMensal() {
        this.saldo *= this.rendimento;

    }
}
