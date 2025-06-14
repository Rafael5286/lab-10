package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Source {
    private final List<Assento> assentos;
    private final List<AssentoListener> listeners;

    public Source(int quantidadeAssentos) {
        assentos = new ArrayList<>();
        for (int i = 1; i <= quantidadeAssentos; i++) {
            assentos.add(new Assento(i));
        }
        listeners = new ArrayList<>();
    }


    public synchronized void addAssentoListener(AssentoListener lis) {
        listeners.add(lis);
    }


    public synchronized void removeAssentoListener(AssentoListener lis) {
        listeners.remove(lis);
    }

    private void disparaStatusAssentoAlterado(int numeroAssento, AssentoStatus novoStatus) {
        AssentoEvent event = new AssentoEvent(this, numeroAssento, novoStatus);
        for (AssentoListener listener : listeners) {
            listener.statusAssentoAlterado(event);
        }
    }

    public void reservarAssento(int numero) {
        alterarStatus(numero, AssentoStatus.RESERVADO);
    }

    public void indisponibilizarAssento(int numero) {
        alterarStatus(numero, AssentoStatus.INDISPONIVEL);
    }

    private void alterarStatus(int numero, AssentoStatus status) {
        for (Assento a : assentos) {
            if (a.getNumero() == numero) {
                a.setStatus(status);
                disparaStatusAssentoAlterado(a.getNumero(), a.getStatus());
                break;
            }
        }
    }

    public List<Assento> getAssentos() {
        return Collections.unmodifiableList(assentos);
    }
}