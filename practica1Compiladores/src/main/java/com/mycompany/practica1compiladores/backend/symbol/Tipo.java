package com.mycompany.practica1compiladores.backend.symbol;

/**
 * @author giovanic
 */
public class Tipo {

    private TipoDeDato tipo;

    public Tipo(TipoDeDato tipo) {
        this.tipo = tipo;
    }

    public TipoDeDato getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeDato tipo) {
        this.tipo = tipo;
    }

}
