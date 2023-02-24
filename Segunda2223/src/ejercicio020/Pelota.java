/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio020;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle {
    private Color [] colores = {Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.LIGHT_GRAY};
    private int velX;
    private int velY;
    private Color color;
    
    public Pelota(){
        super(390,290,100,100);
        color = colores[(int)(Math.random()*colores.length)];
        velX = (int)(Math.random()*7)-3;
        velY = (int)(Math.random()*7)-3;
    }
    public Pelota(int x, int y, int dam){
        super(x,y,dam,dam);
        color = colores[(int)(Math.random()*colores.length)];
        velX = (int)(Math.random()*7)-3;
        velY = (int)(Math.random()*7)-3;
    }
    
    public void update(){ 
        x += velX;
        y += velY; 
        if(y >= (500 - this.height)|| y <= 0)
            velY = -velY;
        if(x >= (500 - this.height)|| x <= 0)
            velX = -velX; 
    }
    
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillOval(x, y, width, height);
        gg.setColor(Color.WHITE);
        gg.drawOval(x, y, width, height);
    }
}
