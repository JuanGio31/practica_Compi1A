package com.mycompany.practica1compiladores.backend.instruccion;

import com.mycompany.practica1compiladores.backend.symbol.Arbol;
import com.mycompany.practica1compiladores.backend.symbol.Tipo;

/**
 * @author giovanic
 */
abstract public class Instruccion {

    private Tipo tipo;
    private int linea;
    private int columna;

    public Instruccion(Tipo tipo, int linea, int columna) {
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
    }

    public abstract Object interpretar(Arbol arbol);

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
