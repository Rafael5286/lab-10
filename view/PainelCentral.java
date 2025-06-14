package view;

import model.*;

public class PainelCentral implements AssentoListener {

    @Override
    public void statusAssentoAlterado(AssentoEvent event) {
        System.out.println("Painel Central (Notificação Recebida):");
        String cor;
        switch (event.getNovoStatus()) {
            case DISPONIVEL -> cor = "Verde";
            case RESERVADO -> cor = "Amarelo";
            case INDISPONIVEL -> cor = "Vermelho";
            default -> cor = "Sem cor";
        }
        System.out.printf("Assento %02d: Atualizado para a cor %s%n", event.getNumeroAssento(), cor);
        System.out.println("----------");
    }
}