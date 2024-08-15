package com.mycompany.practica1compiladores.view.figura;

import java.awt.Graphics;
import java.awt.Graphics2D;

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor(getColor()));
        // Dibuja el rectángulo usando el método fillRect
        g2d.fillRect(getPosX(), getPosY(), ancho, alto);
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
