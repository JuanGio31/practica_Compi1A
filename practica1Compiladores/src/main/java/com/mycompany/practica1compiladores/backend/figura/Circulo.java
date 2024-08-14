package com.mycompany.practica1compiladores.backend.figura;

public class Circulo extends Figura {
    private int radio;

    public Circulo(String nombre, int posX, int posY, int radio, ColorEnum color) {
        super(nombre, posX, posY, color);
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo [radio=" + radio + ", toString()=" + super.toString() + "]";
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

}
