package com.example.telekofinalbattle.logic;

import java.util.List;

public class IAHeuristica {

    public static Ataque seleccionarAtaque(Personaje ia, Personaje jugador) {
        List<Ataque> movimientos = ia.getMovimientos();

        Ataque mejorAtaque = null;
        int maxPoder = -1;

        // Seleccionar el ataque más potente disponible
        for (Ataque a : movimientos) {
            if ((a.getTipo() == TipoAtaque.KI ||
                 a.getTipo() == TipoAtaque.FISICO)
                    && ia.getKiActual() >= a.getCostoKi()) {

                if (a.getPoderBase() > maxPoder) {
                    maxPoder = a.getPoderBase();
                    mejorAtaque = a;
                }
            }
        }

        // Si no hay ataques disponibles, usar el primero
        if (mejorAtaque == null) {
            return movimientos.get(0);
        }

        return mejorAtaque;
    }
}
