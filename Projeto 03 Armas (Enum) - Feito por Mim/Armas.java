public enum Armas {
    PISTOLA(50, 5), FACA(5, 2), PUNHAL(10, 3), RIFLE(80, 5), AK47(65, 6), ESCOPETA(40, 7);

    private int preco;
    private int letalidade;

    public int getPreco() {
        return preco;
    }

    public int getLetalidade() {
        return letalidade;
    }

    Armas(int preco, int let) {
        this.preco = preco;
        this.letalidade = let;
    }
}