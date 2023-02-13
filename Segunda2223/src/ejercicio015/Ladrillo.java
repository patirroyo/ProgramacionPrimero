/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio015;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ladrillo extends Rectangle {
    Color color;
    int vida;
    public static final int ANCHURA = 56;
    public static final int ALTURA = 20;
   
    
    public Ladrillo(int x, int y, Color color){
        super(x,y,0, 0);
        this.width = ANCHURA;
        this.height = ALTURA;
        this.color = color;
        vida = 1;  
    }
    
    public Ladrillo(int x, int y, Color color, int vida){
        super(x,y,56,20);
        this.color = color;
        this.vida = vida;  
    }
    
     
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillRect(x, y, width, height);
        gg.setColor(Color.LIGHT_GRAY);
        gg.drawRect(x, y, width, height);
    }
}
