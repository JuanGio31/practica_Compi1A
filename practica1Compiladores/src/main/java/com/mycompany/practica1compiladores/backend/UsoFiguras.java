package com.mycompany.practica1compiladores.backend;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.practica1compiladores.view.figura.ColorEnum;

public class UsoFiguras {

    public static HashMap<ColorEnum, Integer> usoColores = new HashMap<>();
    public static HashMap<String, Integer> usoObj = new HashMap<>();
    public static HashMap<String, Integer> usoAnimacion = new HashMap<>();

    public static void inicializar() {
        // inicializar colores
        usoColores.put(ColorEnum.AZUL, 0);
        usoColores.put(ColorEnum.AMARILLO, 0);
        usoColores.put(ColorEnum.CELESTE, 0);
        usoColores.put(ColorEnum.NARANJA, 0);
        usoColores.put(ColorEnum.ROJO, 0);
        usoColores.put(ColorEnum.VERDE, 0);
        usoColores.put(ColorEnum.NEGRO, 0);
        usoColores.put(ColorEnum.VIOLETA, 0);
        usoColores.put(ColorEnum.GRIS, 0);

        // inicializar Objetos
        usoObj.put("CIRCULO", 0);
        usoObj.put("CUADRADO", 0);
        usoObj.put("RECTANGULO", 0);
        usoObj.put("LINEA", 0);
        usoObj.put("POLIGONO", 0);

        // inicializar Animaciones
        usoAnimacion.put("LINEA", 0);
        usoAnimacion.put("CURVA", 0);
    }

    public static void actualizarColor(ColorEnum color) {
        int valor = usoColores.get(color);
        usoColores.put(color, valor + 1);
    }

    public static void actualizarAni(String animacion) {
        int valor = usoAnimacion.get(animacion.toUpperCase());
        usoAnimacion.put(animacion.toUpperCase(), valor + 1);
    }

    public static void actualizarObj(String obj) {
        int valor = usoObj.get(obj.toUpperCase());
        usoObj.put(obj.toUpperCase(), valor + 1);
    }

    public static void limpiar() {
        for (Map.Entry<ColorEnum, Integer> entry : usoColores.entrySet()) {
            // Actualiza el valor de cada clave a 0
            usoColores.put(entry.getKey(), 0);
        }

        for (Map.Entry<String, Integer> entry : usoAnimacion.entrySet()) {
            // Actualiza el valor de cada clave a 0
            usoAnimacion.put(entry.getKey(), 0);
        }

        for (Map.Entry<String, Integer> entry : usoObj.entrySet()) {
            // Actualiza el valor de cada clave a 0
            usoObj.put(entry.getKey(), 0);
        }
    }

    public static void size() {
        System.out.println("COLORES" + usoColores.size());
        System.out.println("FIGURAS" + usoObj.size());
        System.out.println("ANIMACIONES" + usoAnimacion.size());
    }

}
