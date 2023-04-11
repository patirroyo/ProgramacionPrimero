/*
 * Hoy toca hacer una ruleta de casino.
 */
package Ejercicio05;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    public static final int LADO = 60;
    private int valor; 
    private Color color;
    
    
    public Casilla(int x, int y, int valor, Color color){
        super(x, y, LADO, LADO);
        this.valor = valor;
        this.color = color;
    }
    public void paint(Graphics gg){
        gg.setColor(Color.WHITE);
        gg.drawRect(x, y, width, height);
        gg.setColor(color);
        gg.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        gg.drawString(Integer.toString(valor), (x + LADO/3), (y + LADO/2));
        /*también se puede transformar a String con "" + valor*/
    }
}
