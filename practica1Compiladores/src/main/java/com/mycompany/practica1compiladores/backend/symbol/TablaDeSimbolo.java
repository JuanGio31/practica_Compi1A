package com.mycompany.practica1compiladores.backend.symbol;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author giovanic
 */
public class TablaDeSimbolo {

    private TablaDeSimbolo tablaAnterior;
    private HashMap<String, Object> tablaActual;
    private String nombre;

    public TablaDeSimbolo() {
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public TablaDeSimbolo(TablaDeSimbolo tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public boolean obtenerVariable(Simbolo simbolo) {
        Simbolo busqueda = (Simbolo) this.tablaActual.get(simbolo.getId());
        if (Objects.isNull(busqueda)) {
            this.tablaActual.put(simbolo.getId(), simbolo);
            return true;
        }
        return false;
    }

    public Simbolo getVariable(String id) {
        for (TablaDeSimbolo i = this; i != null; i = i.tablaAnterior) {
            Simbolo busqueda = (Simbolo) i.tablaActual.get(id.toLowerCase());
            if (busqueda != null) {
                return busqueda;
            }
        }
        return null;
    }

    public TablaDeSimbolo getTablaAnterior() {
        return tablaAnterior;
    }

    public void setTablaAnterior(TablaDeSimbolo tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
    }

    public HashMap<String, Object> getTablaActual() {
        return tablaActual;
    }

    public void setTablaActual(HashMap<String, Object> tablaActual) {
        this.tablaActual = tablaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
