package com.mycompany.practica1compiladores.backend.instruccion;

import java.util.Objects;
import com.mycompany.practica1compiladores.backend.symbol.*;
import com.mycompany.practica1compiladores.view.figura.*;
import com.mycompany.practica1compiladores.backend.error.Error;

public class GraficarF extends Instruccion {
    // atributos para figuras
    private Instruccion nombre;
    private Instruccion pX;
    private Instruccion pY;
    private FiguraEnum clase;
    private TipoColor color;
    private Instruccion r; // radio/lados
    private Instruccion a; // alto/posY2
    private Instruccion b; // base/posX2

    // CIRCULO y CUADRADO (<nombre>, <posx>, <posy>, <radio>, <color>)
    public GraficarF(Instruccion nombre, Instruccion pX, Instruccion pY,
            Instruccion r, FiguraEnum clase, TipoColor color, int linea, int columna) {
        super(new Tipo(TipoDeDato.VOID), linea, columna);
        this.nombre = nombre;
        this.pX = pX;
        this.pY = pY;
        this.r = r;
        this.clase = clase;
        this.color = color;
    }

    // RECTANGULO y LINEA (<nombre>, <posx>, <posy>, <ancho>, <alto>, <color>)
    public GraficarF(Instruccion nombre, Instruccion pX, Instruccion pY,
            Instruccion a, Instruccion b, FiguraEnum clase, TipoColor color, int linea, int columna) {
        super(new Tipo(TipoDeDato.VOID), linea, columna);
        this.nombre = nombre;
        this.pX = pX;
        this.pY = pY;
        this.a = a;
        this.b = b;
        this.clase = clase;
        this.color = color;
    }

    // Poligono (<nombre>, <posx>, <posy>, <cantidad lados>, <ancho>, <alto>,
    // <color>)
    public GraficarF(Instruccion nombre, Instruccion pX, Instruccion pY, Instruccion r,
            Instruccion a, Instruccion b, FiguraEnum clase, TipoColor color, int linea, int columna) {
        super(new Tipo(TipoDeDato.VOID), linea, columna);
        this.nombre = nombre;
        this.pX = pX;
        this.pY = pY;
        this.r = r;
        this.a = a;
        this.b = b;
        this.clase = clase;
        this.color = color;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaDeSimbolo tabla) {
        var id = this.nombre.interpretar(arbol, tabla);
        if (id instanceof Error) {
            return id;
        }

        switch (clase) {
            case CIRCULO, CUADRADO -> {
                if (!Objects.isNull(this.pX) && !Objects.isNull(this.pY) &&
                        !Objects.isNull(this.r)) {
                    var posX = this.pX.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var posY = this.pY.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var lado = this.r.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    return createF(id, posX, posY, lado);
                }
            }
            case RECTANGULO, LINEA -> {
                if (!Objects.isNull(this.pX) && !Objects.isNull(this.pY)
                        && !Objects.isNull(this.a) && !Objects.isNull(this.b)) {
                    var posX = this.pX.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var posY = this.pY.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var alto = this.a.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return alto;
                    }
                    var base = this.b.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return base;
                    }
                    return createF(id, posX, posY, base, alto);
                }
            }
            case POLIGONO -> {
                if (!Objects.isNull(this.pX) && !Objects.isNull(this.pY) &&
                        !Objects.isNull(this.r)
                        && !Objects.isNull(this.a) && !Objects.isNull(this.b)) {
                    var posX = this.pX.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var posY = this.pY.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var lados = this.r.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var alto = this.a.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return alto;
                    }
                    var base = this.b.interpretar(arbol, tabla);
                    if (posX instanceof Error) {
                        return base;
                    }
                    return createF(id, posX, posY, lados, base, alto);
                }
                return new Error("SEMANTICO", "Figura invalida", getLinea(), getColumna());
            }
            default -> {
                return new Error("SEMANTICO", "Figura invalida", getLinea(), getColumna());
            }
        }
        return new Error("SEMANTICO", "Figura invalida", getLinea(), getColumna());
    }

    private Object createF(Object id, Object posX, Object posY, Object lados, Object base, Object alto) {
        return new Poligono(String.valueOf(id),
                getInt(posX),
                getInt(posY),
                getInt(lados),
                getInt(base),
                getInt(alto),
                color.getTipo());
    }

    private Object createF(Object id, Object posX, Object posY, Object base, Object alto) {
        if (clase == FiguraEnum.RECTANGULO) {
            return new Rectangulo(String.valueOf(id),
                    getInt(posX),
                    getInt(posY),
                    getInt(base),
                    getInt(alto),
                    color.getTipo());
        } else if (clase == FiguraEnum.LINEA) {
            return new Linea(String.valueOf(id),
                    getInt(posX),
                    getInt(posY),
                    getInt(base),
                    getInt(alto),
                    color.getTipo());
        }
        return new Error("SEMANTICO", "Figura invalida", getLinea(), getColumna());
    }

    private Object createF(Object id, Object posX, Object posY, Object lado) {
        if (clase == FiguraEnum.CIRCULO) {
            return new Circulo(String.valueOf(id),
                    getInt(posX),
                    getInt(posY),
                    getInt(lado),
                    color.getTipo());
        } else if (clase == FiguraEnum.CUADRADO) {
            return new Cuadrado(String.valueOf(id),
                    getInt(posX),
                    getInt(posY),
                    getInt(lado),
                    color.getTipo());
        }
        return new Error("SEMANTICO", "Figura invalida", getLinea(), getColumna());
    }

    private int getInt(Object num) {
        return (int) Math.round(Double.parseDouble(num.toString()));
    }
}
