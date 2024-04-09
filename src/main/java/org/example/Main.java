package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----------------------");
        List<Klient> Klient = ophen_klient.getKlientData("SELECT * FROM klient");
        System.out.println(Klient);
        System.out.println("-----------------------");

        Klient klient = new Klient(1,"mr.bin",123);

        System.out.println(ophen_klient.saveKlient(klient));
        System.out.println("-----------------------");

        System.out.println(Klient);
        System.out.println("-----------------------");

    }
}