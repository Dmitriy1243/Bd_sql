package org.example;

public class Klient {
    private int ID;
    private String Name;
    private int Balans;

    @Override
    public String toString() {
        return "Klient{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Balans=" + Balans +
                '}';
    }
    public Klient() {
    }

    public Klient(int ID, String name, int balans) {
            this.ID = ID;
            this.Name = name;
            this.Balans = balans;
        }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBalans() {
        return Balans;
    }

    public void setBalans(int balans) {
        Balans = balans;
    }




}
