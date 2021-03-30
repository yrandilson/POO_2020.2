import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class AgendaPlus extends Agenda {
    private Map<String, ContactPlus> boookmarks;

    @Override
    public boolean rmContact(String name) throws Exception {
        super.rmContact(name);
        if (!this.boookmarks.containsKey(name))
            throw new Exception("Contato favorito não existe");

        else {
            this.boookmarks.remove(name);
            return true;
        }
    }

    public void bookmark(String name) {
        if (!this.getContacts().containsKey(name))
            throw new NullPointerException("Contato ja existe ai man");

        ContactPlus contactPlus = new ContactPlus(name, getContacts().get(name).getFones());
        this.boookmarks.put(name, contactPlus);
        this.boookmarks.get(name).setStarred(true);

    }

    public void unbookmark(String name) {
        if (!boookmarks.containsKey(name)) {
            throw new NullPointerException("Contato não existe, é null viu");
        }
        for (Map.Entry<String, ContactPlus> con : boookmarks.entrySet()) {
            if (con.getKey().equalsIgnoreCase(name)) {
                this.boookmarks.remove(name);
            }
        }

    }

    public Map<String, ContactPlus> setBookMark() {
        Map<String, ContactPlus> aux = new TreeMap<>();
        for (Map.Entry<String, ContactPlus> contact : this.boookmarks.entrySet()) {
            if (contact.getValue().starred()) {
                aux.put(contact.getKey(), contact.getValue());
            }
        }
        return aux;
    }

    public AgendaPlus() {
        super();
        this.boookmarks = new TreeMap<>();
    }

    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        for (Map.Entry<String, Contact> cont : getContacts().entrySet()) {
            if (this.boookmarks.containsKey(cont.getKey())) {
                exit.append("@ ").append(cont).append("\n");
                continue;
            }
            exit.append("- ").append(cont).append("\n");
        }
        return exit.toString();
    }
}