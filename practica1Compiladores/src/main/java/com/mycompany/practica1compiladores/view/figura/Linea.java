package com.mycompany.practica1compiladores.view.figura;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Linea extends Figura {

    private int posX2;
    private int posY2;

    public Linea(String nombre, int posX, int posY, int posX2, int posY2, ColorEnum color) {
        super(nombre, posX, posY, color);
        this.posX2 = posX2;
        this.posY2 = posY2;
    }

    @Override
    public String toString() {
        return "Linea [posX2=" + posX2 + ", posY2=" + posY2 + ", toString()=" + super.toString() + "]";
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(getColor(getColor()));
//        g2d.drawLine(getPosX(), getPosY(), posX2, posY2);
//    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor(getColor()));
        g.drawLine(getPosX(), getPosY(), posX2, posY2);
    }

    public int getPosX2() {
        return posX2;
    }

    public void setPosX2(int posX2) {
        this.posX2 = posX2;
    }

    public int getPosY2() {
        return posY2;
    }

    public void setPosY2(int posY2) {
        this.posY2 = posY2;
    }

}
