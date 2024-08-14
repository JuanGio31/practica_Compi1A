package com.mycompany.practica1compiladores.backend.expresion;

import com.mycompany.practica1compiladores.backend.instruccion.Instruccion;
import com.mycompany.practica1compiladores.backend.symbol.Arbol;
import com.mycompany.practica1compiladores.backend.symbol.TablaDeSimbolo;
import com.mycompany.practica1compiladores.backend.symbol.Tipo;
import com.mycompany.practica1compiladores.backend.symbol.TipoDeDato;

public class Aritmetico extends Instruccion {
    private Instruccion operando1;
    private Instruccion operando2;
    private OpAritmetic operacion;
    private Instruccion operandoUnico;

    // negacion
    public Aritmetico(Instruccion operandoUnico, OpAritmetic operacion, int linea, int columna) {
        super(new Tipo(TipoDeDato.ENTERO), linea, columna);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }

    // cualquier operacion menos negacion
    public Aritmetico(Instruccion operando1, Instruccion operando2, OpAritmetic operacion, int linea, int columna) {
        super(new Tipo(TipoDeDato.ENTERO), linea, columna);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaDeSimbolo tabla) {
        // TODO Auto-generated method stub
        System.out.println("Operador aritmetico\n");
        return null;
    }

}
