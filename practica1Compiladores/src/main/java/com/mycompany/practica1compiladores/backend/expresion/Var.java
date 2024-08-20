package com.mycompany.practica1compiladores.backend.expresion;

import com.mycompany.practica1compiladores.backend.instruccion.Instruccion;
import com.mycompany.practica1compiladores.backend.symbol.Arbol;
import com.mycompany.practica1compiladores.backend.symbol.Tipo;

public class Var extends Instruccion {

    private Object valor;

    public Var(Tipo tipo, Object valor, int linea, int columna) {
        super(tipo, linea, columna);
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol) {
        return this.getValor();
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

}
