package model;

public class Assento {
    private final int numero;
    private AssentoStatus status;

    public Assento(int numero) {
        this.numero = numero;
        this.status = AssentoStatus.DISPONIVEL;
    }

    public int getNumero() {
        return numero;
    }

    public AssentoStatus getStatus() {
        return status;
    }

    public void setStatus(AssentoStatus status) {
        this.status = status;
    }
}