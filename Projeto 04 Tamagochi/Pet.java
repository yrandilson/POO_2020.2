public class Pet {
    private int energyMax;
    private int hungryMax;
    private int cleanMax;
    private int energy;
    private int hungry;
    private int clean;
    private int diamonds;
    private int age;
    private boolean alive;

    // Sets
    // Sets
    // Sets
    public void setClean(int clean) {
        this.clean = clean;

        if (this.clean > this.cleanMax) {
            this.clean = this.cleanMax;
        }
        if (this.clean < 0) {
            this.alive = false;
            this.clean = 0;
            System.out.println("\nTu fez o pobre morrer man!!\n");
        }
    }

    public void setEnergy(int energy) {
        this.energy = energy;

        if (this.energy > this.energyMax)
            this.energy = this.energyMax;

        if (this.energy < 0) {
            this.alive = false;
            this.energy = 0;
            System.out.println("\n Matou o pobre de cansaço!\n");
        }
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;

        if (this.hungry > this.hungryMax)
            this.hungry = this.hungryMax;

        if (this.hungry < 0) {
            this.alive = false;
            this.hungry = 0;
            System.out.println("Tu matou o coitado mannn, de fome ainda");
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    // AllGets
    // AllGets
    // AllGets
    // AllGets
    // AllGets
    public int getAge() {
        return age;
    }

    public int getClean() {
        return clean;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public int getEnergy() {
        return energy;
    }

    public int getEnergyMax() {
        return energyMax;
    }

    public int getHungry() {
        return hungry;
    }

    public int getHungryMax() {
        return hungryMax;
    }

    public Pet(int enerMax, int hunMax, int cleMax) {
        this.energyMax = enerMax;
        this.cleanMax = cleMax;
        this.hungryMax = hunMax;

        this.energy = this.energyMax;
        this.clean = this.cleanMax;
        this.hungry = this.hungryMax;
    }

    public void play() throws Exception {
        if (!this.alive)
            throw new Exception("\nO pet ta morto man, não da pra brincar com ele\n");

        this.setEnergy(getEnergy() - 3);
        this.setAge(getAge() - 1);
        this.setClean(getClean() - 2);
        this.setDiamonds(getDiamonds() + 2);
        this.setAge(getAge() + 1);
        System.out.println("\nTamagochi esta muito feliz por brincar!!\n");
    }

    public void shower() throws Exception {
        if (!this.alive)
            throw new Exception("\nO pet ta morto man, toamar banho\n");

        this.setEnergy(getEnergy() - 2);
        this.setAge(getAge() - 1);
        this.setClean(getCleanMax());
        this.setAge(getAge() + 2);
        System.out.println("\nTamagochi tomou banho e ta dois niveis mais velhos ate kkk\n");
    }

    public void eat() throws Exception {
        if (!this.alive)
            throw new Exception("\nO pet ta morto man, não da pra botar pra comer\n");

        this.setEnergy(getEnergy() - 1);
        this.setAge(getAge() + 4);
        this.setClean(getClean() - 2);
        this.setAge(getAge() + 2);
        this.setDiamonds(getDiamonds() - 1);
        System.out.println("\nTamagochi comeu!!\n");
    }

    public void sleep() throws Exception {
        if (!this.alive)
            throw new Exception("\nO pet ta morto man, dormir\n");

        if (this.energy < this.energyMax) {
            this.setEnergy(this.energyMax);
            this.setAge(getAge() + this.energyMax - this.energy);
            return;

        }
        System.out.println("\nPete sem fome man\n");
    }

    public String toString() {
        return "Energy: " + energy + "/" + energyMax + ", Hungry: " + hungry + "/" + hungryMax + ", Clean:" + clean
                + "/" + cleanMax + ", Diamonds: " + diamonds + ", Age: " + age;
    }
}
