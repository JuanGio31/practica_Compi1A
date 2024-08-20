package com.mycompany.practica1compiladores.view.figura;

import java.awt.Graphics;
import java.awt.Polygon;

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
        return "Poligono [cantidadLados=" + cantidadLados + ", ancho="
                + ancho + ", alto=" + alto + ", toString()=" + super.toString() + "]";
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(getColor(getColor()));
//
//        // Crear el polígono
//        Polygon polygon = new Polygon();
//        double angleStep = 2 * Math.PI / cantidadLados;
//
//        for (int i = 0; i < cantidadLados; i++) {
//            double angle = i * angleStep;
//            int x = (int) (getPosX() + ancho * Math.cos(angle));
//            int y = (int) (getPosY() + alto * Math.sin(angle));
//            polygon.addPoint(x, y);
//        }
//        // Dibujar el polígono
//        g2d.fillPolygon(polygon);
//    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor(getColor()));

        // Crear el polígono
        Polygon polygon = new Polygon();
        double angleStep = 2 * Math.PI / cantidadLados;

        for (int i = 0; i < cantidadLados; i++) {
            double angle = i * angleStep;
            int x = (int) (getPosX() + ancho * Math.cos(angle));
            int y = (int) (getPosY() + alto * Math.sin(angle));
            polygon.addPoint(x, y);
        }
        // Dibujar el polígono
        g.fillPolygon(polygon);
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
