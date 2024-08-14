package com.mycompany.practica1compiladores.backend.analisis;

import java_cup.runtime.Symbol;
//import org.apache.commons.text.StringEscapeUtils;
//import org.example.backend.interprete.error.*;
import java.util.LinkedList;


%%
%cup
%public
%type Symbol
%class Scan
%line
%column
%full
%debug
//%ignorecase

%init{
    yyline = 1;
    yycolumn = 1;
%init}

LineTerminator       = \r|\n|\r\n
InputCharacter       = [^\r\n]
CommentContent       = ( [^*] | \*+ [^/*] )*
ComentarioMultiLine  = "/*" {CommentContent} "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
WhiteSpace           = {LineTerminator} | [ \t\f]

IDENTIFICADOR  = [A-Za-z_][A-Za-z0-9_]*
ENTERO         = [0-9]+
DECIMAL        = [0-9]+"."[0-9]+
COMENTARIO     =  {EndOfLineComment} | {ComentarioMultiLine}
//CHARACTER      = "\'" [^\'] "\'"
//CADENACOMILLASDOBLES = [\"]([^\r\"])*[\"]

%{
//    public LinkedList<Errores> listaErrores = new LinkedList<>();

        StringBuffer str = new StringBuffer();

        public Symbol symbol(int tipo){
            return new Symbol(tipo, yyline, yycolumn);
        }

        public Symbol symbol(int tipo, Object value){
            return new Symbol(tipo, yyline, yycolumn, value);
        }
%}


%eofval{
    return symbol(ParserSym.EOF);
%eofval}

%%
    <YYINITIAL>{
        /*OPERADORES ARITMETICOS*/
        "+"     {return symbol(ParserSym.MAS, yytext());   }
        "-"     {return symbol(ParserSym.MENOS, yytext());   }
        "*"     {return symbol(ParserSym.POR, yytext());   }
        "/"     {return symbol(ParserSym.DIV, yytext());   }
        "("     {return symbol(ParserSym.LPAREN, yytext());   }
        ")"     {return symbol(ParserSym.RPAREN, yytext());   }

        /*PALABRAS RESERVADAS*/
        "graficar"          {return symbol(ParserSym.GRAFICAR, yytext());   }
        "circulo"          {return symbol(ParserSym.CIRCULO, yytext());   }
        "cuadrado"          {return symbol(ParserSym.CUADRADO, yytext());   }
        "rectangulo"          {return symbol(ParserSym.RECTANGULO, yytext());   }
        "poligono"          {return symbol(ParserSym.POLIGONO, yytext());   }
        "animar"          {return symbol(ParserSym.ANIMAR, yytext());   }
        "objeto"          {return symbol(ParserSym.OBJETO, yytext());   }
        "anterior"          {return symbol(ParserSym.ANTERIOR, yytext());   }


        /*COLORES*/
        "azul"          {return symbol(ParserSym.COL_AZUL, yytext());   }
        "rojo"          {return symbol(ParserSym.COL_ROJO, yytext());   }
        "amarillo"      {return symbol(ParserSym.COL_AMARILLO, yytext());   }
        "verde"         {return symbol(ParserSym.COL_VERDE, yytext());   }

        "gris"         {return symbol(ParserSym.COL_GRIS, yytext());   }
        "negro"        {return symbol(ParserSym.COL_NEGRO, yytext());   }
        "naranja"      {return symbol(ParserSym.COL_NARANJA, yytext());   }
        "celeste"      {return symbol(ParserSym.COL_CELESTE, yytext());   }
        "violeta"      {return symbol(ParserSym.COL_VIOLETA, yytext());   }

        /*ANIMACION*/
        "linea"     {return symbol(ParserSym.LINEA, yytext());   }
        "curva"     {return symbol(ParserSym.CURVA, yytext());   }
    }

//   <YYINITIAL> {CADENACOMILLASDOBLES} {
//             String cadena = yytext();
//             cadena = cadena.substring(1, cadena.length()-1);
//             return symbol(ParserSym.CADENA, cadena);
//     }

<YYINITIAL>{
            /* Identificadores */
            {IDENTIFICADOR}    {     return symbol(ParserSym.ID, yytext());           }
            /* Numeros/digitos */
            {ENTERO}        {     return symbol(ParserSym.ENTERO, yytext());       }
            {DECIMAL}       {     return symbol(ParserSym.DECIMAL, yytext());      }
            /* Comentarios */
            {COMENTARIO}    {     /* no haceer nada */       }
            /* espacios en blanco */
            {WhiteSpace}+   {     /* no haceer nada */        }
    }

[^] {    /* listaErrores.add(new Errores(TipoError.LEXICO, "El caracter no es valido: "+yytext(), yyline, yycolumn));    */
    System.out.println("Error lexico: " + yytext() + " | [" + yyline +", " + yycolumn + "]" );
}
