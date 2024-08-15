package com.mycompany.practica1compiladores.backend.symbol;

import com.mycompany.practica1compiladores.view.figura.ColorEnum;

public class TipoColor {
    private ColorEnum tipo;

    public TipoColor(ColorEnum tipo) {
        this.tipo = tipo;
    }

    public ColorEnum getTipo() {
        return tipo;
    }

    public void setTipo(ColorEnum tipo) {
        this.tipo = tipo;
    }

}
