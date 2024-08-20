package com.mycompany.practica1compiladores.backend;

public class Ocurrencia {
    private String ocurrencia;
    private String operador;
    private int linea;
    private int columna;

    public Ocurrencia(String operador, int linea, int columna, String ocurrencia) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
        this.ocurrencia = ocurrencia;
    }

    @Override
    public String toString() {
        return "Ocurrencia [ocurrencia=" + ocurrencia + ", operador=" + operador + ", linea=" + linea + ", columna="
                + columna + "]";
    }

    public String getOcurrencia() {
        return ocurrencia;
    }

    public void setOcurrencia(String ocurrencia) {
        this.ocurrencia = ocurrencia;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
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
