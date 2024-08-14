package com.mycompany.practica1compiladores.backend.figura;

public class Cuadrado extends Figura {
    private int lado;

    public Cuadrado(String nombre, int posX, int posY, int lado, ColorEnum color) {
        super(nombre, posX, posY, color);
        this.lado = lado;
    }

    @Override
    public String toString() {
        return "Cuadrado [lado=" + lado + ", toString()=" + super.toString() + "]";
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

}
