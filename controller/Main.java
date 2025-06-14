package controller;

import model.Source;
import view.PainelCentral;
import view.Quiosque;

public class Main {

    public static void main(String[] args) {
        Source onibus = new Source(3);

        PainelCentral painel = new PainelCentral();
        Quiosque q1 = new Quiosque("A");
        
        onibus.addAssentoListener(painel);
        onibus.addAssentoListener(q1);

        RodoviariaController controller = new RodoviariaController(onibus);

        System.out.println("\n--- Ação 1: Cliente solicita a reserva do assento 2 ---");
        controller.solicitarReserva(2);
        
        System.out.println("\n--- Ação 2: Cliente solicita a compra do assento 3 ---");
        controller.solicitarCompra(3);
    }
}