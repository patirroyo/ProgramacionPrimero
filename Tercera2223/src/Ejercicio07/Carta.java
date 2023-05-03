package Ejercicio07;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta extends Rectangle{ //extiende al recatangulo para poder usar intersect, contains, etc
    public static final int WIDTH = 100; //las cartas nunca cambian de tamaño pero si de posicion
    public static final int HEIGHT = 150;
    public static final int ROJO = 1;
    public static final int NEGRO = 2;
    public static final int ESPADAS = 0;
    public static final int DIAMANTES = 1;
    public static final int CORAZONES = 2;
    public static final int TREBOLES = 3;
    
    public Image imagen;
    private int valor;
    private int color;
    private int palo;

    public Carta(Image imagen, int valor, int palo, int color){
        super(-200, -200, WIDTH, HEIGHT);
        this.imagen = imagen;
        this.valor = valor;
        this.palo = palo;
        this.color = color;
    }

    public void paint(Graphics g, Applet applet){
        g.drawImage(imagen, x, y, WIDTH, HEIGHT, applet);
                    //x, y, width y height son lo mismo que los nuestros pero hacen referencia a los del rectangulo
                    //no los usamos porque sino son una mala practica de programacion
    }

    public void setPosicion(int X, int Y){//sirve para cuando movamos la carta al hacer click y arrastrarla
        x = X;
        y = Y;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getPosX() {
        return x;
    }
    public void setPosX(int posX) {
        this.x = posX;
    }
    public int getPosY() {
        return y;
    }
    public void setPosY(int posY) {
        this.y = posY;
    }
    public int getPalo() { //Solo hacemos get porque nunca lo vamos a modificar
        return palo;
    }
    public int getColor() { //Solo hacemos get porque nunca lo vamos a modificar
        return color;
    }
    
    
    
}
