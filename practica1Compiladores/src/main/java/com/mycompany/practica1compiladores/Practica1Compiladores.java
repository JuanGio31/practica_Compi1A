package com.mycompany.practica1compiladores;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.mycompany.practica1compiladores.view.VentanaPrincipal;

/**
 *
 * @author giovanic
 */
public class Practica1Compiladores {

    public static void main(String[] args) {
        FlatDarculaLaf.setup();

        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
