import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
    private Map<String, Contact> contacts;

    public void addContact(String name, ArrayList<Fone> fones) throws Exception {
        if (fones.isEmpty())
            throw new NullPointerException("Digite algum fone brow");

        for (Fone fone : fones) {
            if (!Fone.validate(fone.getNumber()))
                fones.remove(fones.indexOf(fone));
        }

        if (this.contacts.containsKey(name)) {
            this.contacts.get(name).addFones(fones);
            return;
        }
        this.contacts.put(name, new Contact(name));
        this.contacts.get(name).addFones(fones);
    }

    public boolean rmContact(String name) {
        if (this.contacts.get(name) == null)
            throw new NullPointerException("Não existe este contato");

        if (this.contacts.containsKey(name)) {
            this.contacts.remove(name);
            return true;
        }
        return false;

    }

    public List<Contact> search(String pattern) {
        List<Contact> patternn = new ArrayList<>();

        for (Map.Entry<String, Contact> contato : this.contacts.entrySet()) {
            boolean solver = false;
            if (contato.getKey().contains(pattern))
                solver = true;
            for (Fone fone : contato.getValue().getFones()) {
                if (fone.getLabel().contains(pattern) || fone.getNumber().contains(pattern))
                    solver = true;
            }

            if (solver) {
                patternn.add(contato.getValue());
            }
        }

        return patternn;
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public Map<String, Contact> getContact(String name) {
        Map<String, Contact> aux = new TreeMap<>();
        if (!contacts.containsKey(name))
            throw new NullPointerException("Não existe em");

        aux.put(name, contacts.get(name));

        return aux;
    }

    public void bookmark(String name) {
        if (!contacts.containsKey(name)) {
            throw new NullPointerException("Contato não existe, é null point");
        }
        if (contacts.containsKey(name)) {
            this.contacts.get(name).setStarred(true);
        }
    }

    public void unbookmark(String name) {
        if (!contacts.containsKey(name)) {
            throw new NullPointerException("Contato não existe, é null viu");
        }
        if (contacts.containsKey(name)) {
            this.contacts.get(name).setStarred(false);
        }
    }

    public Map<String, Contact> setBookMark() {
        Map<String, Contact> aux = new TreeMap<>();
        for (Map.Entry<String, Contact> contact : this.contacts.entrySet()) {
            if (contact.getValue().isStarred()) {
                aux.put(contact.getKey(), contact.getValue());
            }
        }
        return aux;
    }

    public Agenda() {
        this.contacts = new TreeMap<>();
    }

    public String toString() {
        StringBuilder exit = new StringBuilder();

        for (Map.Entry<String, Contact> contact : contacts.entrySet()) {
            if (contact.getValue().isStarred())
                exit.append("@ ").append(contact);
            else
                exit.append("- ").append(contact);

            exit.append("\n");
        }
        return exit.toString();
    }
}
