/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio014a;

import java.awt.*;

/**
 La clase Rectangle tiene 4 atributos x, y, width, height
 * y varios métodos:
 * -intersect: si dos rectangulos intersectan
 * -contains: si un punto está dentro del rectangulo
 */
public class Pelota extends Rectangle {
    Color color;
    public static final int TOPX = Jugando.tamX;
    public static final int TOPY = Jugando.tamY;
    public static final int BOTTOMX = 0;
    public static final int BOTTOMY = 0;
    public static final int DERECHA = 2;
    public static final int ABAJO = 2;
    public static final int IZQUIERDA = 1;
    public static final int ARRIBA = 1;
    public int direccionH;
    public int direccionV;
    
    public Pelota(int x, int y, int ancho, Color col, int dirH, int dirV){
        super(x, y, ancho, ancho);
        this.color = col;
        direccionH = dirH;
        direccionV = dirV;
    }
    
    public void actualizar(){
        if (direccionH == 0 && direccionV == 0){
            direccionH = (int)(Math.random()*3);
            direccionV = (int)(Math.random()*3);    
        }
        switch(direccionV){
            case ABAJO :
                y++;
                if (y == Jugando.tamY - height)
                    direccionV = ARRIBA;
                break;
            case ARRIBA : 
                y--;
                if (y == BOTTOMY)
                    direccionV = ABAJO;
        }
        switch(direccionH){
            case DERECHA :
                x++;
                if (x == Jugando.tamX - width)
                    direccionH = IZQUIERDA;
                break;
            case IZQUIERDA :
                x--;
                if (x == BOTTOMX)
                    direccionH = DERECHA;
        }
    }
    
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillOval(x, y, width, height);
    }
    
}
