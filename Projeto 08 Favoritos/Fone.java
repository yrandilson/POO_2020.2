public class Fone {
    private String label;
    private String number;

    public static boolean validate(String number) {
        String validate = "0123456789()-";
        for (int i = 0; i < number.length(); i++) {
            if (validate.indexOf(number.charAt(i)) == -1)
                return false;
        }
        return true;
    }

    public Fone(String label, String number) throws Exception {
        if (!validate(number))
            throw new Exception("Number is invalid");

        this.label = label;
        this.number = number;
    }

    public Fone(String serial) throws Exception {
        String brok[] = serial.split(":");

        if (!validate(brok[1]))
            throw new Exception("Número ai e invalido man");

        this.label = brok[0];
        this.number = brok[1];
    }

    // Geters
    // Geters
    // Geters
    public String getLabel() {
        return label;
    }

    public String getNumber() {
        return number;
    }

    // toString
    public String toString() {
        StringBuilder exit = new StringBuilder();
        exit.append(label).append(":").append(number);
        return exit.toString();
    }
}