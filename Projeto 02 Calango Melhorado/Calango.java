public class Calango {
    public int bucho;
    public int maxBucho;
    public int nPatas;

    Calango(int buc, int maxBuc, int nPatas) {
        this.bucho = buc;
        this.maxBucho = maxBuc;
        this.nPatas = nPatas;
    }

    public void andar() throws Exception {
        if (this.nPatas < 2)
            throw new Exception("Impossivel de andar por conta do numero de patas");

        if (this.bucho > 0) {
            this.bucho -= 1;
            System.out.println("Consegui andar e perdi um alimento da barriga!!!");
            return;
        }

        throw new Exception("Cara, o calango ta com fome emmm!!");

    }

    public void comer(int quantidade) throws Exception {
        if (this.bucho + quantidade > this.maxBucho) {
            this.bucho = this.maxBucho;
            throw new Exception("Calango comeu até ficar cheio demaiss, comida passou do maximo do bucho");
        } else
            this.bucho += quantidade;

        System.out.println("bom demais emmm");
    }

    public void acidentar() throws Exception {
        if (this.nPatas == 0) {
            throw new Exception("Rapaz o coitado ja ta sem perna, morreu tentando correr");

        }
        this.nPatas -= 1;

    }

    public void regenerar() throws Exception {
        if (this.nPatas == 4)
            throw new Exception("Rapaz ja tenho pata demais");

        else if (this.bucho > 0) {
            this.nPatas += 1;
            System.out.println("Regenerado uma pataa!!");
            this.bucho -= 1;
            return;
        }
        throw new Exception("Cara eu to sem energia para ");
    }

    public String toString() {
        return "Bucho: " + bucho + " / " + maxBucho + "/ Patas " + nPatas;
    }
}