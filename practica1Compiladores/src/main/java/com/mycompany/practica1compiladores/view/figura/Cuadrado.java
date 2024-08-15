package com.mycompany.practica1compiladores.view.figura;

import java.awt.Graphics;
import java.awt.Graphics2D;

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor(getColor()));
        // Dibuja el cuadrado usando el método fillRect
        g2d.fillRect(getPosX(), getPosY(), getLado(), getLado());
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

}
