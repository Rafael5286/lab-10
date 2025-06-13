package view;

import model.*;

import java.util.List;

public class PainelCentral implements Observer {

    @Override
    public void atualizar(List<Assento> assentos) {
        System.out.println("Painel Central:");
        for (Assento a : assentos) {
            String cor;
            switch (a.getStatus()) {
                case DISPONIVEL -> cor = "Verde";
                case RESERVADO -> cor = "Amarelo";
                case INDISPONIVEL -> cor = "Vermelho";
                default -> cor = "Sem cor";
            }
            System.out.printf("Assento %02d: %s%n", a.getNumero(), cor);
        }
        System.out.println("----------");
    }
}
