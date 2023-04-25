/*

 */
package Ejercicio06;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Carta {
    private int valor;
    private Image imagen;
    private Image reverso;
    private int x;
    private int y;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 145;
    
    public Carta(int valor, Image imagen, Image reverso){
        x = 150;
        y = 50;
        this.valor = (valor > 10)?10:valor;
        this.imagen = imagen;
        this.reverso = reverso;
    }
    public void paint(Graphics g, Applet applet){
        g.drawImage(imagen, x, y, WIDTH, HEIGHT, applet);
    }
    public void paint(int x, Graphics g, Applet applet){
        g.drawImage(imagen, x, y, WIDTH, HEIGHT, applet);
    }
        public void paint(int x, int y, Graphics g, Applet applet){
        g.drawImage(imagen, x, y, WIDTH, HEIGHT, applet);
    }
    public void paint(int x, Graphics g, Applet applet, boolean tapada){
        if(tapada)
            g.drawImage(reverso, x, y, WIDTH, HEIGHT, applet);
        else
            g.drawImage(imagen, x, y, WIDTH, HEIGHT, applet);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
