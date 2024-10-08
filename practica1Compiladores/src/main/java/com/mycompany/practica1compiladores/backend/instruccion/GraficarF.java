package com.mycompany.practica1compiladores.backend.instruccion;

import java.util.Objects;
import com.mycompany.practica1compiladores.backend.symbol.*;
import com.mycompany.practica1compiladores.view.figura.*;
import com.mycompany.practica1compiladores.backend.UsoFiguras;
import com.mycompany.practica1compiladores.backend.error.ErrorC;
import com.mycompany.practica1compiladores.backend.error.TipoError;

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
    public Object interpretar(Arbol arbol) {
        var id = this.nombre.interpretar(arbol);
        if (id instanceof Error) {
            return id;
        }
        if (this.nombre.getTipo().getTipo() != TipoDeDato.ID) {
            return new ErrorC(TipoError.SEMANTICO, "ID no valido", getLinea(), getColumna());
        }

        switch (clase) {
            case CIRCULO, CUADRADO -> {
                if (!Objects.isNull(this.pX) && !Objects.isNull(this.pY)
                        && !Objects.isNull(this.r)) {
                    var posX = this.pX.interpretar(arbol);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var posY = this.pY.interpretar(arbol);
                    if (posY instanceof Error) {
                        return posY;
                    }
                    var lado = this.r.interpretar(arbol);
                    if (lado instanceof Error) {
                        return lado;
                    }
                    return createF(id, posX, posY, lado);
                }
            }
            case RECTANGULO, LINEA -> {
                if (!Objects.isNull(this.pX) && !Objects.isNull(this.pY)
                        && !Objects.isNull(this.a) && !Objects.isNull(this.b)) {
                    var posX = this.pX.interpretar(arbol);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var posY = this.pY.interpretar(arbol);
                    if (posY instanceof Error) {
                        return posY;
                    }
                    var alto = this.a.interpretar(arbol);
                    if (alto instanceof Error) {
                        return alto;
                    }
                    var base = this.b.interpretar(arbol);
                    if (base instanceof Error) {
                        return base;
                    }
                    return createF(id, posX, posY, base, alto);
                }
            }
            case POLIGONO -> {
                if (!Objects.isNull(this.pX) && !Objects.isNull(this.pY)
                        && !Objects.isNull(this.r)
                        && !Objects.isNull(this.a) && !Objects.isNull(this.b)) {
                    var posX = this.pX.interpretar(arbol);
                    if (posX instanceof Error) {
                        return posX;
                    }
                    var posY = this.pY.interpretar(arbol);
                    if (posY instanceof Error) {
                        return posY;
                    }
                    var lados = this.r.interpretar(arbol);
                    if (lados instanceof Error) {
                        return lados;
                    }
                    var alto = this.a.interpretar(arbol);
                    if (alto instanceof Error) {
                        return alto;
                    }
                    var base = this.b.interpretar(arbol);
                    if (base instanceof Error) {
                        return base;
                    }
                    return createF(id, posX, posY, lados, base, alto);
                }
                return new ErrorC(TipoError.SEMANTICO, "Figura invalida", getLinea(), getColumna());
            }
            default -> {
                return new ErrorC(TipoError.SEMANTICO, "Figura invalida", getLinea(), getColumna());
            }
        }
        return new ErrorC(TipoError.SEMANTICO, "Figura invalida", getLinea(), getColumna());
    }

    private Object createF(Object id, Object posX, Object posY, Object lados, Object base, Object alto) {
        UsoFiguras.actualizarObj("poligono");
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
            UsoFiguras.actualizarObj("rectangulo");
            return new Rectangulo(String.valueOf(id),
                    getInt(posX),
                    getInt(posY),
                    getInt(base),
                    getInt(alto),
                    color.getTipo());
        } else if (clase == FiguraEnum.LINEA) {
            UsoFiguras.actualizarObj("linea");
            return new Linea(String.valueOf(id),
                    getInt(posX),
                    getInt(posY),
                    getInt(base),
                    getInt(alto),
                    color.getTipo());
        }
        return new ErrorC(TipoError.SEMANTICO, "Figura invalida", getLinea(), getColumna());
    }

    private Object createF(Object id, Object posX, Object posY, Object lado) {
        if (clase == FiguraEnum.CIRCULO) {
            UsoFiguras.actualizarObj("circulo");
            return new Circulo(String.valueOf(id),
                    getInt(posX),
                    getInt(posY),
                    getInt(lado),
                    color.getTipo());
        } else if (clase == FiguraEnum.CUADRADO) {
            UsoFiguras.actualizarObj("cuadrado");
            return new Cuadrado(String.valueOf(id),
                    getInt(posX),
                    getInt(posY),
                    getInt(lado),
                    color.getTipo());
        }
        return new ErrorC(TipoError.SEMANTICO, "Figura invalida", getLinea(), getColumna());
    }

    private int getInt(Object num) {
        return (int) Math.round(Double.parseDouble(num.toString()));
    }
}
