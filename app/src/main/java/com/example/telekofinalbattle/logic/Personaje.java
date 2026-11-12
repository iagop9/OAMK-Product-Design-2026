package com.example.telekofinalbattle.logic;

import java.util.List;

/**
 * Personaje.java
 * Clase abstracta para todos los luchadores. 
 * Adaptado para exponer el estado (S) al Agente RL.
 */
public abstract class Personaje {
    protected String nombre;
    protected int vidaActual;
    protected int vidaMaxima;
    protected int kiActual;
    protected int kiMaximo; 
    protected int ataqueFisico;
    protected int ataqueKi;
    protected int defensaBase; 
    protected int defensa;     
    protected int velocidad;
    protected List<Ataque> movimientos;
    
    protected int bonoDefensaTemporal = 0;
    protected boolean transformado = false; 

    public Personaje(String nombre, int vida, int ki, int atqFisico, int atqKi, int def, int vel, List<Ataque> movimientos) {
        this.nombre = nombre;
        this.vidaActual = vida;
        this.vidaMaxima = vida;
        this.kiActual = ki;
        this.kiMaximo = ki;
        this.ataqueFisico = atqFisico;
        this.ataqueKi = atqKi;
        this.defensaBase = def;
        this.defensa = def;
        this.velocidad = vel;
        this.movimientos = movimientos;
    }

    // --- Lógica de Combate ---

    public void resetearDefensaTemporal() {
        this.defensa = this.defensaBase;
        this.bonoDefensaTemporal = 0;
    }

    public void usarAtaque(Ataque ataque, Personaje objetivo) {
        if (this.kiActual < ataque.getCostoKi()) {
            System.out.printf("¡%s no tiene suficiente Ki para usar %s! (Ki actual: %d/%d)%n", 
                              nombre, ataque.getNombre(), kiActual, kiMaximo);
            return; 
        }
        
        this.kiActual -= ataque.getCostoKi();
        System.out.printf("--> %s usa %s... ", nombre, ataque.getNombre());

        switch (ataque.getTipo()) {
            case KI:
            case FISICO:
                int poderAtacante = (ataque.getTipo() == TipoAtaque.KI) ? this.ataqueKi : this.ataqueFisico;
                int statDefensa = objetivo.getDefensa();
                int poderBaseAtaque = ataque.getPoderBase();
                int danio = calcularDanio(poderBaseAtaque, poderAtacante, statDefensa);
                objetivo.recibirDanio(danio);
                break;
            case ESPECIAL:
                if (ataque.getNombre().toLowerCase().contains("cargar ki")) {
                    cargarKi(ataque.getPoderBase());
                } else if (ataque.getNombre().toLowerCase().contains("transformación") || ataque.getNombre().toLowerCase().contains("despertar") || ataque.getNombre().toLowerCase().contains("furia")) {
                    transformar(ataque.getPoderBase()); 
                } else {
                    System.out.printf("Efecto especial desconocido: %s%n", ataque.getNombre());
                }
                break;
            case CURA:
                curar(ataque.getPoderBase());
                break;
            case DEFENSA:
                defender(ataque.getPoderBase()); 
                break;
        }
    }

    private int calcularDanio(int poderBaseAtaque, int statAtacante, int statDefensa) {
        int danioBase = poderBaseAtaque + statAtacante;
        int danioFinal = danioBase - statDefensa;
        return Math.max(1, danioFinal / 2);
    }

    public void recibirDanio(int danio) {
        int danioReal = Math.max(0, danio);
        this.vidaActual -= danioReal;
        this.vidaActual = Math.max(0, vidaActual);
        System.out.printf("¡%s recibe %d puntos de daño! (Vida restante: %d/%d)%n", 
                          nombre, danioReal, vidaActual, vidaMaxima);
    }

    public void curar(int cantidad) {
        this.vidaActual = Math.min(vidaMaxima, vidaActual + cantidad);
        System.out.printf("¡%s se cura %d puntos de vida! (Vida actual: %d/%d)%n", 
                          nombre, cantidad, vidaActual, vidaMaxima);
    }

    public void cargarKi(int cantidad) {
        this.kiActual = Math.min(kiMaximo, kiActual + cantidad);
        System.out.printf("¡%s carga %d puntos de Ki! (Ki actual: %d/%d)%n", 
                          nombre, cantidad, kiMaximo, kiMaximo);
    }

    public void defender(int bonoDefensa) {
        this.bonoDefensaTemporal = bonoDefensa;
        this.defensa = this.defensaBase + bonoDefensa;
        System.out.printf("¡%s se defiende! Su defensa aumenta en +%d este turno. (Defensa total: %d)%n", 
                          nombre, bonoDefensa, this.defensa);
    }

    public void transformar(int multiplicador) {
        if (transformado) return;

        double factor = 1 + multiplicador / 100.0;
        this.ataqueKi = (int) (this.ataqueKi * factor);
        this.ataqueFisico = (int) (this.ataqueFisico * factor);
        this.transformado = true;
        
        System.out.printf("¡%s se transforma! Sus ataques se multiplican por %.1f. (¡Ki gastado!)%n", 
                          nombre, factor);
    }


    // --- Getters y Estado ---

    /**
     * MÉTODO CLAVE PARA RL: Devuelve las stats del personaje en un array de double.
     */
    public double[] obtenerStatsBaseRL() {
        return new double[]{
            (double)vidaActual,
            (double)kiActual,
            (double)ataqueFisico,
            (double)ataqueKi,
            (double)defensaBase,
            (double)velocidad,
            transformado ? 1.0 : 0.0
        };
    }
    
    public String getNombre() { return nombre; }
    public int getVidaActual() { return vidaActual; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getKiMaxima() { return kiMaximo; } 
    public int getKiActual() { return kiActual; }
    public int getDefensa() { return defensa; }
    public int getVelocidad() { return velocidad; }
    public List<Ataque> getMovimientos() { return movimientos; }
    public boolean estaVivo() { return vidaActual > 0; }
    public boolean estaTransformado() { return transformado; } 
    public int getAtaqueKi() { return ataqueKi; }
    public int getAtaqueFisico() { return ataqueFisico; }
    public int getDefensaBase() { return defensaBase; }
    
    public void mostrarEstado() {
        System.out.printf("  > %s%s | Vida: %d/%d | Ki: %d/%d | Def: %d | Vel: %d%n", 
                          nombre, transformado ? " (T)" : "", vidaActual, vidaMaxima, kiActual, kiMaximo, defensa, velocidad);
    }
}
