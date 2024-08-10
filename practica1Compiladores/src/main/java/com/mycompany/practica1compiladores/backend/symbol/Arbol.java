package com.mycompany.practica1compiladores.backend.symbol;

import java.util.LinkedList;

import com.mycompany.practica1compiladores.backend.instruccion.Instruccion;

/**
 * @author giovanic
 */
public class Arbol {

    private LinkedList<Instruccion> instrucciones;
    private TablaDeSimbolo global;

    public Arbol(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
        this.global = new TablaDeSimbolo();
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public TablaDeSimbolo getGlobal() {
        return global;
    }

    public void setGlobal(TablaDeSimbolo global) {
        this.global = global;
    }

}
