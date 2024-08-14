package com.mycompany.practica1compiladores.backend.figura;

public class Rectangulo extends Figura {
    private int ancho;
    private int alto;

    public Rectangulo(String nombre, int posX, int posY, int ancho, int alto, ColorEnum color) {
        super(nombre, posX, posY, color);
        this.ancho = ancho;
        this.alto = alto;
    }
    

    @Override
    public String toString() {
        return "Rectangulo [ancho=" + ancho + ", alto=" + alto + ", toString()=" + super.toString() + "]";
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
