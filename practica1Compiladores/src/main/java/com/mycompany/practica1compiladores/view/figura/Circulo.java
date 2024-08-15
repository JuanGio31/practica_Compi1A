package com.mycompany.practica1compiladores.view.figura;

import java.awt.Graphics;
import java.awt.Graphics2D;

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
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor(getColor()));
        // Dibuja el círculo usando el método fillOval
        g2d.fillOval(getPosX() - radio, getPosY() - radio, 2 * radio, 2 * radio);
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

}
