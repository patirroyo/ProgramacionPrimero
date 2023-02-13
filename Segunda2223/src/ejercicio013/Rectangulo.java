/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio013;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author alber
 */
public class Rectangulo {
    private int posX, posY, anchura, altura;
    private Color color;
    public static final int DERECHA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int ARRIBA = 3;
    public int direccion;
    public int topeDer, topeIz, topeArriba, topeAbajo;
    
    
    public Rectangulo(int x, int y, int anchura, int altura, Color color){
        posX = x;
        posY = y;
        this.anchura = anchura;
        this.altura = altura;
        this.color = color;
        topeDer = x + 20;
        topeIz = x;
        topeArriba = y;
        topeAbajo = y + 20;
        direccion = DERECHA;
    }
    
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(posX, posY, anchura, altura);
        
    }
    public void actualizar(){
        switch (direccion){
                case DERECHA: 
                    posX++;
                    if (posX == this.topeDer)
                        direccion = ABAJO;
                    break;
                case ABAJO:
                    posY++;
                    if (posY == this.topeAbajo)
                        direccion = IZQUIERDA;
                    break;
                case IZQUIERDA:
                    posX--;
                    if (posX == this.topeIz)
                        direccion = ARRIBA;
                    break;
                case ARRIBA:
                    posY--;
                    if (posY == this.topeArriba)
                        direccion = DERECHA;
            }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
