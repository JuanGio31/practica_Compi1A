package com.mycompany.practica1compiladores.backend.error;

public class ErrorC {
    private TipoError tipo;
    private String descripcion;
    private int linea;
    private int columna;

    public ErrorC(TipoError tipo, String descripcion, int linea, int columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Error [tipo=" + tipo + ", descripcion=" + descripcion + ", linea=" + linea + ", columna=" + columna
                + "]";
    }

    public TipoError getTipo() {
        return tipo;
    }

    public void setTipo(TipoError tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
