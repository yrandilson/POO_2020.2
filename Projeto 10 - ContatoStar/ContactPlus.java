import java.util.ArrayList;

public class ContactPlus extends Contact {
    private boolean starred;

    public ContactPlus(String id) {
        super(id);
        this.starred = false;
    }

    // Caso digite um array de fones
    public ContactPlus(String id, ArrayList<Fone> fones) {
        super(id, fones);
        this.starred = false;
    }

    // sets
    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    // gets
    @Override
    public ArrayList<Fone> getFones() {
        return super.getFones();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public boolean starred() {
        return starred;
    }

}
