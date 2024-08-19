package com.mycompany.practica1compiladores.view;

import com.mycompany.practica1compiladores.view.figura.ColorEnum;
import com.mycompany.practica1compiladores.view.figura.Cuadrado;
import com.mycompany.practica1compiladores.view.figura.Figura;
import com.mycompany.practica1compiladores.view.figura.Linea;
import com.mycompany.practica1compiladores.view.figura.Poligono;
import javax.swing.*;
import java.awt.*;

public class CuadroEnDialogo extends JPanel {

    private int x, y;      // Posición del cuadrado
    private int tamaño;    // Tamaño del cuadrado
    private Color color;   // Color del cuadrado

    public CuadroEnDialogo(int x, int y, int tamaño, Color color) {
        this.x = x;
        this.y = y;
        this.tamaño = tamaño;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color); // Establece el color del cuadrado
        g.fillRect(x, y, tamaño, tamaño); // Dibuja el cuadrado
    }

    public static void main(String[] args) {
        // Parámetros del cuadrado
        int x = 50;       // Posición X
        int y = 50;       // Posición Y
        int tamaño = 100; // Tamaño del cuadrado
        Color color = Color.RED; // Color del cuadrado

        // Crea un cuadro de diálogo
        JDialog dialog = new JDialog((JFrame) null, "Dibujo de Cuadrado", true); // Modal
        dialog.setSize(400, 400); // Tamaño del diálogo

        // Añade el panel con el cuadrado al diálogo
        CuadroEnDialogo panel = new CuadroEnDialogo(x, y, tamaño, color);
        Figura cuadrado = new Cuadrado("cuadrado", 1, 1, 40, ColorEnum.ROJO);
        Figura linea = new Linea("linea", 2, 2, 100, 100, ColorEnum.VIOLETA);
        dialog.add(cuadrado);
        dialog.add(linea);
        //dialog.add(panel);

        dialog.setVisible(true); // Muestra el diálogo
    }
}
