/**
 * TipoAtaque.java
 * Enum que define los diferentes tipos de ataque que un personaje puede usar.
 * Incluye KI, FISICO, ESPECIAL (como Transformación), CURA y DEFENSA.
 */

package com.example.telekofinalbattle.logic;

public enum TipoAtaque {
    KI,        // Ataques de energía
    FISICO,    // Ataques cuerpo a cuerpo
    ESPECIAL,  // Habilidades únicas (Transformaciones, cargas de Ki)
    CURA,      // Habilidades de recuperación de vida
    DEFENSA    // Habilidades de guardia o defensa
}
