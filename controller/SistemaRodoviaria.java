package controller;

import model.*;
import view.*;

public class SistemaRodoviaria {

    public static void main(String[] args) {
        Onibus onibus = new Onibus(3); 

        PainelCentral painel = new PainelCentral();
        Quiosque q1 = new Quiosque("A");
        Quiosque q2 = new Quiosque("B");

        onibus.adicionarObserver(painel);
        onibus.adicionarObserver(q1);
        onibus.adicionarObserver(q2);

        onibus.reservarAssento(2);
        onibus.indisponibilizarAssento(3);
    }
}
