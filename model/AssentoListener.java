package model;

import java.util.EventListener;

public interface AssentoListener extends EventListener {
    void statusAssentoAlterado(AssentoEvent event);
}