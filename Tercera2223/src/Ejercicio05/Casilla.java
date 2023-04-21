/*
 * Hoy toca hacer una ruleta de casino.
 */
package Ejercicio05;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    public static final int LADO = 75;
    private int valor; 
    private Color color;
    
    
    public Casilla(int x, int y, int valor, Color color){
        super(x, y, LADO, LADO);
        this.valor = valor;
        this.color = color;
    }
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillRect(x, y, width, height);
        gg.setColor(Color.WHITE);
        gg.drawRect(x, y, width, height);
        gg.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        gg.drawString(Integer.toString(valor), (x + 2*LADO/5), (y + 3*LADO/5));
        
        
        /*también se puede transformar a String con "" + valor*/
    }

    public int getValor() {
        return valor;
    }
    
}
