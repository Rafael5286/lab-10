package view;

import model.*;

public class Quiosque implements AssentoListener {

    private final String id;

    public Quiosque(String id) {
        this.id = id;
    }

    @Override
    public void statusAssentoAlterado(AssentoEvent event) {
        System.out.println("Quiosque " + id + " (Notificação Recebida):");
        System.out.printf("Listagem atualizada -> Assento %02d - %s%n",
                event.getNumeroAssento(),
                event.getNovoStatus());
        System.out.println("----------");
    }
}