package com.mycompany.practica1compiladores.backend.symbol;

import java.util.LinkedList;

import com.mycompany.practica1compiladores.backend.instruccion.Instruccion;

/**
 * @author giovanic
 */
public class Arbol {

    private LinkedList<Instruccion> instrucciones;

    public Arbol(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
}
