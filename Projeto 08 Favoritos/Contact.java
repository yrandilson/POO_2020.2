import java.util.ArrayList;

public class Contact {
    private String name;
    private ArrayList<Fone> fones;
    private boolean starred;

    // Getters
    public ArrayList<Fone> getFones() {
        return fones;
    }

    public String getName() {
        return name;
    }

    public boolean isStarred() {
        return starred;
    }

    public Contact(String name) {
        this.name = name;
        this.fones = new ArrayList<>();
        this.starred = false;
    }

    // Para add um so fone
    public void addFone(String label, String number) throws Exception {
        if (!Fone.validate(number))
            throw new Exception("Number errado brow");

        this.fones.add(new Fone(label, number));
    }

    // Para add Varios de uma so vez
    public void addFones(ArrayList<Fone> fones) throws Exception {
        for (Fone fone : fones) {
            addFone(fone.getLabel(), fone.getNumber());
        }
    }

    public boolean rmFone(int index) {
        if (index < 0 || index > this.fones.size())
            throw new IndexOutOfBoundsException("Index errado brow");

        this.fones.remove(index);
        return true;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public String toString() {
        StringBuilder exit = new StringBuilder();
        for (int i = 0; i < this.fones.size(); i++) {
            exit.append("[").append(i).append(":").append(fones.get(i).getLabel()).append(":")
                    .append(fones.get(i).getNumber()).append("]");
        }
        return exit.toString();
    }
}
