package com.mycompany.practica1compiladores.backend.symbol;

/**
 * @author giovanic
 */
public class Simbolo {

    private Tipo tipoDato;
    private String id;
    private Object valor;

    public Simbolo(Tipo tipoDato, String id, Object valor) {
        this.tipoDato = tipoDato;
        this.id = id;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Tipo getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Tipo tipoDato) {
        this.tipoDato = tipoDato;
    }

}
