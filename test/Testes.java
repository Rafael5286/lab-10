package test;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testes {

    private Source onibus;
    private List<AssentoEvent> notificacoesRecebidas;

    @BeforeEach
    void setUp() {
        onibus = new Source(3);
        notificacoesRecebidas = new ArrayList<>();

        AssentoListener listenerDeTeste = evento -> notificacoesRecebidas.add(evento);
        onibus.addAssentoListener(listenerDeTeste);
    }

    @Test
    void testReservaAssentoDisparaNotificacao() {
        onibus.reservarAssento(1);

        assertEquals(1, notificacoesRecebidas.size(), "Deveria ter recebido uma notificação.");
    }

    @Test
    void testIndisponibilizarAssentoDisparaEventoComDadosCorretos() {
        onibus.indisponibilizarAssento(2);

        assertEquals(1, notificacoesRecebidas.size());
        AssentoEvent evento = notificacoesRecebidas.get(0);

        assertEquals(2, evento.getNumeroAssento(), "O número do assento no evento está incorreto.");
        assertEquals(AssentoStatus.INDISPONIVEL, evento.getNovoStatus(), "O status no evento está incorreto.");
        assertInstanceOf(Source.class, evento.getSource(), "A origem do evento deveria ser a classe Source.");
    }

    @Test
    void testNaoNotificaSeAssentoNaoExistir() {
        onibus.reservarAssento(999); 
        assertTrue(notificacoesRecebidas.isEmpty(), "Não deveria notificar se o assento não existe.");
    }

    @Test
    void testMultiplasNotificacoes() {
        onibus.reservarAssento(1);
        onibus.indisponibilizarAssento(3);

        assertEquals(2, notificacoesRecebidas.size(), "Deveria ter recebido duas notificações.");

        AssentoEvent primeiroEvento = notificacoesRecebidas.get(0);
        assertEquals(1, primeiroEvento.getNumeroAssento());
        assertEquals(AssentoStatus.RESERVADO, primeiroEvento.getNovoStatus());

        AssentoEvent segundoEvento = notificacoesRecebidas.get(1);
        assertEquals(3, segundoEvento.getNumeroAssento());
        assertEquals(AssentoStatus.INDISPONIVEL, segundoEvento.getNovoStatus());
    }
}