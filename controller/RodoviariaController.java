package controller;

import model.Source;
public class RodoviariaController {

    private final Source onibusModel;

    public RodoviariaController(Source model) {
        this.onibusModel = model;
    }

    public void solicitarReserva(int numeroAssento) {
        System.out.printf("[CONTROLLER]: Recebida solicitação para RESERVAR o assento %d. Repassando para o Model...\n", numeroAssento);
        onibusModel.reservarAssento(numeroAssento);
    }
    public void solicitarCompra(int numeroAssento) {
        System.out.printf("[CONTROLLER]: Recebida solicitação para COMPRAR o assento %d. Repassando para o Model...\n", numeroAssento);
        onibusModel.indisponibilizarAssento(numeroAssento);
    }
}