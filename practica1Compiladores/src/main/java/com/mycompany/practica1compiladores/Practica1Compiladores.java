package com.mycompany.practica1compiladores;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mycompany.practica1compiladores.view.VentanaPrincipal;

/**
 *
 * @author giovanic
 */
public class Practica1Compiladores {

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
        //init();
    }

    /*
    public static void init() {
        JFrame fr = new JFrame("prueba");
        fr.setSize(500, 300);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Obtener el entorno gráfico y el dispositivo
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Crear un panel principal con un diseño adecuado
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        LinkedList<Figura> figuras = new LinkedList<>();
        ListaFiguras lFiguras = new ListaFiguras(figuras);
        System.out.println("\n\n");
        String texto = """
                graficar poligono ( PoligA, 100+(2.3-2)*12  + 2 -1/12,100+ 15, 6, 50 + 50 / 2, 38 + 12, amarillo)
                graficar circulo ( cir_Uno,  15, 6, 5  * 2 -1/12-(1.5*3), azul)
                animar objeto anterior (curva, 50*3-4, 75+ 15/5, 2-1)

                graficar rectangulo (RectAngulo_test_1, 12 * 3 + 2 (100), 2*60.50, 16 / 4, rojo)
                animar objeto anterior (linea, 300, 6+ 15/5+112, 2-1/2+1)
                graficar linea (linea_Amarillo, 1 * 3 + 2, 7.5+7.5, 4 / 4+100, 30/2, gris)
                animar objeto anterior (linea, 120, 15, 3)
                animar objeto anterior (curva, 150, 200, 0)
                graficar cuadrado ( figura_cuadrada, 12*3+200, 15+1+300, (15-3) / 4+1.8+0.2, verde)
                graficar poligono ( PoligB, 100, 400, 9, 25 / 2 + 100.5, 50*2-10, rosado)
                                                                        """;
        ;
        System.out.println();
        String str = "2+2+6";
        try {
            StringReader stringReader = new StringReader(texto);
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
                if (res instanceof Figura f) {
                    // fr.add((Figura) a.interpretar(ast, tabla));
                    figuras.add(f);
                }
                if (res instanceof Error r) {
                    System.out.println(r.toString());
                }
            }
//            for (Figura figura : figuras) {
//                System.out.println(figura.getNombre());
//                panelPrincipal.add(figura);
//            }
            fr.add(lFiguras);
            fr.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     */
}

// FlatDarculaLaf.setup();
// java.awt.EventQueue.invokeLater(() -> {
// new VentanaPrincipal().setVisible(true);
// });
