package com.mycompany.practica1compiladores.backend.expresion;

import com.mycompany.practica1compiladores.backend.instruccion.Instruccion;
import com.mycompany.practica1compiladores.backend.symbol.Arbol;
import com.mycompany.practica1compiladores.backend.symbol.TablaDeSimbolo;
import com.mycompany.practica1compiladores.backend.symbol.Tipo;
import com.mycompany.practica1compiladores.backend.symbol.TipoDeDato;
import com.mycompany.practica1compiladores.backend.error.Error;

public class Aritmetico extends Instruccion {
    private Instruccion operando1;
    private Instruccion operando2;
    private OpAritmetic operacion;
    private Instruccion operandoUnico;

    // negacion
    public Aritmetico(Instruccion operandoUnico, OpAritmetic operacion, int linea, int columna) {
        super(new Tipo(TipoDeDato.ENTERO), linea, columna);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }

    // cualquier operacion menos negacion
    public Aritmetico(Instruccion operando1, Instruccion operando2, OpAritmetic operacion, int linea, int columna) {
        super(new Tipo(TipoDeDato.ENTERO), linea, columna);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaDeSimbolo tabla) {
        System.out.println("Operador aritmetico\n");
        Object opIzq = null, opDer = null, Unico = null;
        if (this.operandoUnico != null) {
            Unico = this.operandoUnico.interpretar(arbol, tabla);
            if (Unico instanceof Error) {
                return Unico;
            }
        } else {
            opIzq = this.operando1.interpretar(arbol, tabla);
            if (opIzq instanceof Error) {
                return opIzq;
            }
            opDer = this.operando2.interpretar(arbol, tabla);
            if (opDer instanceof Error) {
                return opDer;
            }
        }

        return switch (operacion) {
            case SUMA -> this.suma(opIzq, opDer);
            case RESTA -> this.resta(opIzq, opDer);
            case MULT -> this.multiplicacion(opIzq, opDer);
            case DIVISION -> this.division(opIzq, opDer);
            case NEGACION -> this.negacion(Unico);
            default -> new Error("SEMANTICO", "Operador invalido", getLinea(), getColumna());
        };
    }

    private Object negacion(Object unico) {
        var opU = this.operandoUnico.getTipo().getTipo();
        switch (opU) {
            case ENTERO -> {
                this.getTipo().setTipo(TipoDeDato.ENTERO);
                return (int) unico * -1;
            }
            case DECIMAL -> {
                this.getTipo().setTipo(TipoDeDato.DECIMAL);
                return (double) unico * -1;
            }
            default -> {
                System.out.println("Negacion erronea");
                return new Error("SEMANTICO", "Negacion erronea", getLinea(), getColumna());
            }
        }
    }

    private Object division(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.getTipo().getTipo();
        var tipo2 = this.operando2.getTipo().getTipo();

        double auxiliar = -1;
        if (tipo2 == TipoDeDato.ENTERO || tipo2 == TipoDeDato.ENTERO) {
            auxiliar = Double.parseDouble(String.valueOf(opDer));
        }

        if (auxiliar == 0.0) {
            System.out.println("Division por cero");
            // return null;
            return new Error("SEMANTICO", "Division por cero", getLinea(),
                    getColumna());
        }

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO, DECIMAL -> {
                        this.getTipo().setTipo(TipoDeDato.DECIMAL);
                        return (double) opIzq / (double) opDer;
                    }
                    default -> {
                        return new Error("SEMANTICO", "Division erronea", getLinea(), getColumna());
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO, DECIMAL -> {
                        this.getTipo().setTipo(TipoDeDato.DECIMAL);
                        return (double) opIzq / (double) opDer;
                    }
                    default -> {
                        return new Error("SEMANTICO", "Division erronea", getLinea(), getColumna());
                    }
                }
            }

            default -> {
                return new Error("SEMANTICO", "Division erronea", getLinea(), getColumna());
            }
        }
    }

    private Object multiplicacion(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.getTipo().getTipo();
        var tipo2 = this.operando2.getTipo().getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.getTipo().setTipo(TipoDeDato.ENTERO);
                        return (int) opIzq * (int) opDer;
                    }
                    case DECIMAL -> {
                        this.getTipo().setTipo(TipoDeDato.DECIMAL);
                        return (int) opIzq * (double) opDer;
                    }
                    default -> {
                        return new Error("SEMANTICO", "Multiplicacion erronea", getLinea(), getColumna());
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.getTipo().setTipo(TipoDeDato.ENTERO);
                        return (int) opIzq * (int) opDer;
                    }
                    case DECIMAL -> {
                        this.getTipo().setTipo(TipoDeDato.DECIMAL);
                        return (double) opIzq * (double) opDer;
                    }
                    default -> {
                        return new Error("SEMANTICO", "Multiplicacion erronea", getLinea(), getColumna());
                    }
                }
            }

            default -> {
                return new Error("SEMANTICO", "Multiplicacion erronea", getLinea(), getColumna());
            }
        }
    }

    private Object resta(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.getTipo().getTipo();
        var tipo2 = this.operando2.getTipo().getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.getTipo().setTipo(TipoDeDato.ENTERO);
                        return (int) opIzq - (int) opDer;
                    }
                    case DECIMAL -> {
                        this.getTipo().setTipo(TipoDeDato.DECIMAL);
                        return (int) opIzq - (double) opDer;
                    }
                    default -> {
                        return new Error("SEMANTICO", "Resta erronea", getLinea(), getColumna());
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.getTipo().setTipo(TipoDeDato.ENTERO);
                        return (int) opIzq - (int) opDer;
                    }
                    case DECIMAL -> {
                        this.getTipo().setTipo(TipoDeDato.DECIMAL);
                        return (double) opIzq - (double) opDer;
                    }
                    default -> {
                        return new Error("SEMANTICO", "Resta erronea", getLinea(), getColumna());
                    }
                }
            }

            default -> {
                return new Error("SEMANTICO", "Resta erronea", getLinea(), getColumna());
            }
        }
    }

    private Object suma(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.getTipo().getTipo();
        var tipo2 = this.operando2.getTipo().getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.getTipo().setTipo(TipoDeDato.ENTERO);
                        return (int) opIzq + (int) opDer;
                    }
                    case DECIMAL -> {
                        this.getTipo().setTipo(TipoDeDato.DECIMAL);
                        return (int) opIzq + (double) opDer;
                    }
                    default -> {
                        return new Error("SEMANTICO", "Suma erronea", getLinea(), getColumna());
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.getTipo().setTipo(TipoDeDato.ENTERO);
                        return (int) opIzq + (int) opDer;
                    }
                    case DECIMAL -> {
                        this.getTipo().setTipo(TipoDeDato.DECIMAL);
                        return (double) opIzq + (double) opDer;
                    }
                    default -> {
                        return new Error("SEMANTICO", "Suma erronea", getLinea(), getColumna());
                    }
                }
            }

            default -> {
                return new Error("SEMANTICO", "Suma erronea", getLinea(), getColumna());
            }
        }
    }

}
