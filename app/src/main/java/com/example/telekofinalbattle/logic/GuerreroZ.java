package com.example.telekofinalbattle.logic;

import java.util.Arrays;
import java.util.List;

/**
 * GuerreroZ.java
 * Implementación concreta de la clase Personaje. Contiene métodos 
 * estáticos para crear los 10 luchadores disponibles en el juego.
 */
public class GuerreroZ extends Personaje {

    public GuerreroZ(String nombre, int vida, int ki, int atqFisico, int atqKi, int def, int vel, List<Ataque> movimientos) {
        super(nombre, vida, ki, atqFisico, atqKi, def, vel, movimientos);
    }

    // --- MÉTODOS DE CREACIÓN DE GUERREROS Z (JUGABLES) ---

    public static GuerreroZ crearGoku() {
        List<Ataque> gokuMovimientos = Arrays.asList(
            new Ataque("Kamehameha", TipoAtaque.KI, 60, 20),         
            new Ataque("Patada del Dragón", TipoAtaque.FISICO, 40, 0), 
            new Ataque("Cargar Ki", TipoAtaque.ESPECIAL, 20, 0),     
            new Ataque("Transformación SSJ", TipoAtaque.ESPECIAL, 100, 50) // +100% Atq/Ki
        );
        return new GuerreroZ("Goku", 300, 100, 45, 45, 30, 90, gokuMovimientos);
    }

    public static GuerreroZ crearVegeta() {
        List<Ataque> vegetaMovimientos = Arrays.asList(
            new Ataque("Final Flash", TipoAtaque.KI, 75, 40),
            new Ataque("Big Bang Attack", TipoAtaque.KI, 55, 20), 
            new Ataque("Puñetazo", TipoAtaque.FISICO, 45, 0),
            new Ataque("Cargar Ki", TipoAtaque.ESPECIAL, 20, 0)
        );
        // Alto Ki, Baja Defensa, Rápido
        return new GuerreroZ("Vegeta", 270, 100, 40, 50, 25, 95, vegetaMovimientos);
    }

    public static GuerreroZ crearPiccolo() {
        List<Ataque> piccoloMovimientos = Arrays.asList(
            new Ataque("Rayo Makankosappo", TipoAtaque.KI, 80, 50),
            new Ataque("Explosión", TipoAtaque.KI, 40, 10),
            new Ataque("Bloqueo", TipoAtaque.DEFENSA, 60, 0), // Mayor defensa
            new Ataque("Regeneración", TipoAtaque.CURA, 40, 15)
        );
        // Defensivo, Curación
        return new GuerreroZ("Piccolo", 320, 100, 30, 40, 40, 70, piccoloMovimientos);
    }

    public static GuerreroZ crearGohan() {
        List<Ataque> gohanMovimientos = Arrays.asList(
            new Ataque("Masenko", TipoAtaque.KI, 50, 15),
            new Ataque("Patada Ascendente", TipoAtaque.FISICO, 45, 0),
            new Ataque("Despertar", TipoAtaque.ESPECIAL, 120, 60), // Mayor bono que SSJ, más costo
            new Ataque("Defensa Total", TipoAtaque.DEFENSA, 40, 0)
        );
        // Potencial, pero empieza bajo
        return new GuerreroZ("Gohan (Teen)", 250, 100, 35, 35, 20, 80, gohanMovimientos);
    }

    public static GuerreroZ crearKrilin() {
        List<Ataque> krilinMovimientos = Arrays.asList(
            new Ataque("Kienzan (Disco Destructor)", TipoAtaque.KI, 65, 30),
            new Ataque("Golpe", TipoAtaque.FISICO, 30, 0),
            new Ataque("Curar", TipoAtaque.CURA, 30, 10),
            new Ataque("Defensa Total", TipoAtaque.DEFENSA, 40, 0)
        );
        // Soporte, Curación
        return new GuerreroZ("Krilin", 220, 80, 25, 35, 20, 85, krilinMovimientos);
    }
    
    public static GuerreroZ crearTrunks() {
        List<Ataque> trunksMovimientos = Arrays.asList(
            new Ataque("Burning Attack", TipoAtaque.KI, 60, 25),
            new Ataque("Ataque de Espada", TipoAtaque.FISICO, 50, 0),
            new Ataque("Cargar Ki", TipoAtaque.ESPECIAL, 20, 0),
            new Ataque("Defensa Total", TipoAtaque.DEFENSA, 45, 0)
        );
        // Equilibrio ofensivo, buen ataque físico
        return new GuerreroZ("Trunks (Future)", 280, 100, 50, 40, 30, 85, trunksMovimientos);
    }

    public static GuerreroZ crearYamcha() {
        List<Ataque> yamchaMovimientos = Arrays.asList(
            new Ataque("Sokidan (Lobo)", TipoAtaque.KI, 70, 40),
            new Ataque("Puñetazo", TipoAtaque.FISICO, 35, 0),
            new Ataque("Defensa Total", TipoAtaque.DEFENSA, 30, 0),
            new Ataque("Cargar Ki", TipoAtaque.ESPECIAL, 20, 0)
        );
        // Débil, pero con un buen ataque Ki
        return new GuerreroZ("Yamcha", 200, 100, 30, 35, 15, 75, yamchaMovimientos);
    }

    // --- MÉTODOS DE CREACIÓN DE ADVERSARIOS (IA) ---

    public static GuerreroZ crearFreezer() {
        List<Ataque> freezerMovimientos = Arrays.asList(
            new Ataque("Death Beam", TipoAtaque.KI, 55, 15),
            new Ataque("Cola", TipoAtaque.FISICO, 40, 0),
            new Ataque("Defensa Total", TipoAtaque.DEFENSA, 30, 0),
            new Ataque("Cargar Ki", TipoAtaque.ESPECIAL, 20, 0) 
        );
        // Stats base (fuerte desde el inicio)
        return new GuerreroZ("Freezer", 280, 100, 35, 55, 25, 85, freezerMovimientos);
    }

    public static GuerreroZ crearCell() {
        List<Ataque> cellMovimientos = Arrays.asList(
            new Ataque("Kamehameha Perfecto", TipoAtaque.KI, 70, 30),
            new Ataque("Patada", TipoAtaque.FISICO, 40, 0),
            new Ataque("Cargar Ki", TipoAtaque.ESPECIAL, 20, 0),
            new Ataque("Absorber Energía", TipoAtaque.CURA, 50, 10) // Curación y bajo costo
        );
        // Alto HP y stats equilibrados
        return new GuerreroZ("Cell (Perfecto)", 350, 100, 40, 40, 35, 75, cellMovimientos);
    }

    public static GuerreroZ crearBroly() {
        List<Ataque> brolyMovimientos = Arrays.asList(
            new Ataque("Ráfaga de Energía", TipoAtaque.KI, 50, 15),
            new Ataque("Puñetazo L.S.S.J.", TipoAtaque.FISICO, 60, 0),
            new Ataque("Furia Saiyan", TipoAtaque.ESPECIAL, 150, 80), // Transformación/Potenciación
            new Ataque("Defensa Total", TipoAtaque.DEFENSA, 40, 0)
        );
        // Alto ataque físico, mucha vida
        return new GuerreroZ("Broly (Legendario)", 400, 100, 55, 30, 35, 60, brolyMovimientos);
    }
}
