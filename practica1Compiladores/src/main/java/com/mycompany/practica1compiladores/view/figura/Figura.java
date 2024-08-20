package com.mycompany.practica1compiladores.view.figura;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.mycompany.practica1compiladores.backend.UsoFiguras;

/**
 * @author giovanic
 */
abstract public class Figura extends JPanel {

    private String nombre;
    private int posX;
    private int posY;
    private ColorEnum color;

    public Figura(String nombre, int posX, int posY, ColorEnum color) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        UsoFiguras.actualizarColor(color);
    }

    @Override
    public String toString() {
        return "Figura [nombre=" + nombre + ", posX=" + posX + ", posY=" + posY + ", color=" + color + "]";
    }
    //
    // @Override
    // protected void paintComponent(Graphics g) {
    // super.paintComponent(g);
    // }

    public abstract void dibujar(Graphics g);

    protected Color getColor(ColorEnum c) {
        return switch (c) {
            case AZUL ->
                Color.BLUE;
            case ROJO ->
                Color.RED;
            case AMARILLO ->
                Color.YELLOW;
            case VERDE ->
                Color.GREEN;
            case GRIS ->
                Color.GRAY;
            case NEGRO ->
                Color.BLACK;
            case NARANJA ->
                Color.ORANGE;
            case CELESTE ->
                Color.CYAN;
            case VIOLETA ->
                Color.MAGENTA;
            default ->
                null;
        };
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
