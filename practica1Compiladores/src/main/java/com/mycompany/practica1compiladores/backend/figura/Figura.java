package com.mycompany.practica1compiladores.backend.figura;

/**
 * @author giovanic
 */
public class Figura {
    private String nombre;
    private int posX;
    private int posY;
    private ColorEnum color;

    public Figura(String nombre, int posX, int posY, ColorEnum color) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Figura [nombre=" + nombre + ", posX=" + posX + ", posY=" + posY + ", color=" + color + "]";
    }

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

}
