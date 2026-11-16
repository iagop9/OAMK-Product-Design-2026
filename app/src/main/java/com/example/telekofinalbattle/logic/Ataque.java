/**
 * Ataque.java
 * Clase que representa un movimiento o habilidad que un Personaje puede ejecutar.
 */

package com.example.telekofinalbattle.logic;

public class Ataque {
    private String nombre;
    private TipoAtaque tipo;
    private int poderBase;  // Daño base, curación, o bonificación de defensa/multiplicador
    private int costoKi;    // Cuánto Ki consume el ataque

    public Ataque(String nombre, TipoAtaque tipo, int poderBase, int costoKi) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.poderBase = poderBase;
        this.costoKi = costoKi;
    }

    // --- Getters ---
    public String getNombre() {
        return nombre;
    }

    public TipoAtaque getTipo() {
        return tipo;
    }

    public int getPoderBase() {
        return poderBase;
    }

    public int getCostoKi() {
        return costoKi;
    }

    /**
     * Devuelve una descripción simple del ataque para el menú.
     */
    @Override
    public String toString() {
        // Manejamos la acción de cambio (Sustitución) primero
        if (nombre.equals("Sustitución")) {
            return String.format("%s (Acción)", nombre);
        }

        // --- CORRECCIÓN: Switch compatible con Java 11 (Sintaxis clásica) ---
        String descripcion = "";
        switch (tipo) {
            case KI:
                descripcion = "Daño Ki";
                break;
            case FISICO:
                descripcion = "Daño Físico";
                break;
            case ESPECIAL:
                if (nombre.contains("Transformación") || nombre.contains("Despertar")) {
                    descripcion = "Potenciación Permanente";
                } else {
                    descripcion = "Efecto Especial";
                }
                break;
            case CURA:
                descripcion = "Curación";
                break;
            case DEFENSA:
                descripcion = "Aumenta la Defensa este turno";
                break;
            default:
                descripcion = "Habilidad";
                break;
        }
        // -------------------------------------------------------------------

        // Lógica de retorno basada en el tipo (Reconstruida para mantener la info)
        if (tipo == TipoAtaque.DEFENSA) {
            return String.format("%s (%s +%d)", nombre, descripcion, poderBase);
        } else if (tipo == TipoAtaque.ESPECIAL && descripcion.equals("Potenciación Permanente")) {
            return String.format("%s (%s +%d%%)", nombre, descripcion, poderBase);
        } else {
            return String.format("%s (%s: %d) [Coste: %d Ki]", nombre, descripcion, poderBase, costoKi);
        }
    }
}
