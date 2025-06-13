package view;

import model.*;

import java.util.List;

public class Quiosque implements Observer {

    private final String id;

    public Quiosque(String id) {
        this.id = id;
    }

    @Override
    public void atualizar(List<Assento> assentos) {
        System.out.println("Quiosque " + id + ":");
        for (Assento a : assentos) {
            System.out.printf("Assento %02d - %s%n", a.getNumero(), a.getStatus());
        }
        System.out.println("----------");
    }
}
