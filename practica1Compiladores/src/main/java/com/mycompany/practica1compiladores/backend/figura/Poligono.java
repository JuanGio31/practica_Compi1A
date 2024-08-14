package com.mycompany.practica1compiladores.backend.figura;

public class Poligono extends Figura {
    private int cantidadLados;
    private int ancho;
    private int alto;

    public Poligono(String nombre, int posX, int posY, int cantidadLados, int ancho, int alto, ColorEnum color) {
        super(nombre, posX, posY, color);
        this.cantidadLados = cantidadLados;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public String toString() {
        return "Poligono [cantidadLados=" + cantidadLados + ", ancho=" + ancho + ", alto=" + alto + ", toString()="
                + super.toString() + "]";
    }

    public int getCantidadLados() {
        return cantidadLados;
    }

    public void setCantidadLados(int cantidadLados) {
        this.cantidadLados = cantidadLados;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

}
