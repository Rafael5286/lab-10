package model;

import java.util.*;

public class Onibus {
    private List<Assento> assentos;
    private List<Observer> observadores;

    public Onibus(int quantidadeAssentos) {
        assentos = new ArrayList<>();
        for (int i = 1; i <= quantidadeAssentos; i++) {
            assentos.add(new Assento(i));
        }
        observadores = new ArrayList<>();
    }

    public void adicionarObserver(Observer o) {
        observadores.add(o);
    }

    public void removerObserver(Observer o) {
        observadores.remove(o);
    }

    private void notificarObservers() {
        for (Observer o : observadores) {
            o.atualizar(assentos);
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
                notificarObservers();
                break;
            }
        }
    }

    public List<Assento> getAssentos() {
        return Collections.unmodifiableList(assentos);
    }
}
