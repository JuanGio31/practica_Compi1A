package com.mycompany.practica1compiladores.view;

import com.mycompany.practica1compiladores.view.figura.Figura;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 *
 * @author giovanic
 */
public class ListaFiguras extends JPanel {

    private LinkedList<Figura> figuras;

    public ListaFiguras(LinkedList<Figura> figuras) {
        this.figuras = figuras;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja las figuras
        for (Figura f : figuras) {
            f.dibujar(g);
        }
    }

    public void setFiguras(LinkedList<Figura> figuras) {
        this.figuras = figuras;
    }

    public LinkedList<Figura> getFiguras() {
        return figuras;
    }

}
