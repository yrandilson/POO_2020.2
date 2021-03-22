import java.util.Random;

public class TrocaTiro {
    int debito;
    int life;
    boolean dead = false;
    Random random = new Random();

    TrocaTiro(int life) {
        this.life = life;
    }

    void tiro(Armas arma) throws Exception {

        int i = random.nextInt(3);

        if (i == 1) {
            throw new Exception("Cara, errou o tiro em");

        }

        if (dead == true)
            throw new Exception("Tu já ta morto man kkk");

        estamorto();
        this.debito += arma.getPreco();
        this.life -= arma.getLetalidade();
        System.out.println("Acertou o tiro de" + arma.toString() + " já ta sangrando em kkk");

        if (this.life - 10 <= 0)
            System.out.println("Macho tu já ta sangrando muito em");

    }

    void estamorto() {
        if (this.life <= 0) {
            this.dead = true;
            this.life = 0;
            System.out.println("morreu");
            return;
        }
        System.out.println("Ainda nao morreu, pode levar tiro ai!");
    }

    void mostrar() {
        System.out.println("Nome: " + Armas.AK47.toString() + " Letalidade: " + Armas.AK47.getLetalidade());
        System.out.println("Nome: " + Armas.ESCOPETA.toString() + " Letalidade: " + Armas.ESCOPETA.getLetalidade());
        System.out.println("Nome: " + Armas.FACA.toString() + " Letalidade: " + Armas.FACA.getLetalidade());
        System.out.println("Nome: " + Armas.PISTOLA + " Letalidade: " + Armas.PISTOLA.getLetalidade());
        System.out.println("Nome: " + Armas.PUNHAL + " Letalidade: " + Armas.PUNHAL.getLetalidade());
        System.out.println("Nome: " + Armas.RIFLE + " Letalidade: " + Armas.RIFLE.getLetalidade());
    }

    public String toString() {
        return "Débito: " + debito;
    }
}
