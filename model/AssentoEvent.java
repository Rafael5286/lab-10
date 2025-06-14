package model;

import java.util.EventObject;

public class AssentoEvent extends EventObject {

    private final int numeroAssento;
    private final AssentoStatus novoStatus;


    public AssentoEvent(Object source, int numeroAssento, AssentoStatus novoStatus) {
        super(source); 
        this.numeroAssento = numeroAssento;
        this.novoStatus = novoStatus;
    }

    public int getNumeroAssento() {
        return numeroAssento;
    }

    public AssentoStatus getNovoStatus() {
        return novoStatus;
    }
}