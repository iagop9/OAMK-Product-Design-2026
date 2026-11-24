// Archivo: Transicion.java
package com.example.telekofinalbattle.logic;

import java.io.Serializable;
import java.util.Vector;

/**
 * Transicion.java
 * Clase que almacena una experiencia de aprendizaje (S, A, R, S').
 */


public class Transicion implements Serializable { 
    private static final long serialVersionUID = 1L; 

    public final Vector<Double> estadoAntes;
    public final int accion;
    public final double recompensa;
    public final Vector<Double> estadoDespues;

    public Transicion(Vector<Double> sAntes, int a, double r, Vector<Double> sDespues) {
        this.estadoAntes = sAntes;
        this.accion = a;
        this.recompensa = r;
        this.estadoDespues = sDespues;
    }
}
