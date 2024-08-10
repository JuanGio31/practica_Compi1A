package com.mycompany.practica1compiladores.backend.analisis;

public class Generador {

    public static void main(String[] args) {
        generar();
    }

    public static void generar() {
        try {
            String ruta = "analisis/";
            /*
                ruta -> ruta del los archivos
                -d -> ruta donde se genera la salida
                ruta salida
             */

            String[] Flex = {ruta + "lexico.flex", "-d", ruta};
            jflex.Main.generate(Flex);

            /*
            -destdir indica la ruta donde se generara la salida
            ruta de salida
            -parser indican el nombre del archivo
            parser
            ruta del archivo cup
             */
            String Cup[] = {"-destdir", ruta, "-parser", "parser", ruta + "parser.cup"};

            java_cup.Main.main(Cup);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
