package com.mycompany.practica1compiladores;

import java.io.StringReader;
import java.util.LinkedList;

import com.mycompany.practica1compiladores.backend.analisis.Parser;
import com.mycompany.practica1compiladores.backend.analisis.Scan;
import com.mycompany.practica1compiladores.backend.instruccion.Instruccion;
import com.mycompany.practica1compiladores.backend.symbol.Arbol;
import com.mycompany.practica1compiladores.backend.symbol.TablaDeSimbolo;

/**
 *
 * @author giovanic
 */
public class Practica1Compiladores {

    public static void main(String[] args) {
        System.out.println("\n\n");
        String texto = "graficar poligono ( PoligA, (2.3-2)*12  + 2 -1/12, 15, 6, 50 / 2, 12, amarillo)\n" +
                "animar objeto anterior (curva, 50*3-4, 75+ 15/5, 2-1)\n";
        String str = "2+2+6";
        try {
            StringReader stringReader = new StringReader(str);
            Scan scan = new Scan(stringReader);
            Parser parser = new Parser(scan);
            var resultado = parser.parse();
            var ast = new Arbol((LinkedList<Instruccion>) resultado.value);
            var tabla = new TablaDeSimbolo();
            tabla.setNombre("GLOBAL");

            for (var a : ast.getInstrucciones()) {
                if (a == null) {
                    continue;
                }
                var res = a.interpretar(ast, tabla);
                if (res instanceof Error r) {
                    // System.out.println(r.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // FlatDarculaLaf.setup();

        // java.awt.EventQueue.invokeLater(() -> {
        // new VentanaPrincipal().setVisible(true);
        // });
    }
}
