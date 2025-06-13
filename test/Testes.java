package test;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Testes {

    private Onibus onibus;
    private List<List<Assento>> notificacoesRecebidas;

    @BeforeEach
    void setUp() {
        onibus = new Onibus(3);
        notificacoesRecebidas = new ArrayList<>();

        model.Observer observerDeTeste = assentos -> {
            // Clonando a lista para não alterar
            List<Assento> copia = new ArrayList<>();
            for (Assento a : assentos) {
                Assento clone = new Assento(a.getNumero());
                clone.setStatus(a.getStatus());
                copia.add(clone);
            }
            notificacoesRecebidas.add(copia);
        };
        onibus.adicionarObserver(observerDeTeste);
    }

    @Test
    void testReservaAssentoDisparaNotificacao() {
        onibus.reservarAssento(1);

        assertEquals(1, notificacoesRecebidas.size());
        Assento assento = notificacoesRecebidas.get(0).get(0);
        assertEquals(AssentoStatus.RESERVADO, assento.getStatus());
    }

    @Test
    void testIndisponibilizarAssentoAtualizaStatusCorretamente() {
        onibus.indisponibilizarAssento(2);

        assertEquals(1, notificacoesRecebidas.size());
        Assento assento = notificacoesRecebidas.get(0).get(1);
        assertEquals(AssentoStatus.INDISPONIVEL, assento.getStatus());
    }

    @Test
    void testNaoNotificaSeAssentoNaoExistir() {
        onibus.reservarAssento(999);
        assertEquals(0, notificacoesRecebidas.size());
    }

    @Test
    void testGetAssentosRetornaListaImutavel() {
        List<Assento> assentos = onibus.getAssentos();
        assertThrows(UnsupportedOperationException.class, () -> assentos.add(new Assento(4)));
    }
}
