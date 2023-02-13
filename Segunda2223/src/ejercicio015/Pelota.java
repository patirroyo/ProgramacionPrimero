/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio015;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle {
    Color color;
    int velX;
    int velY;
    
    public Pelota(Color color){
        super(290,529,20,20);
        this.color = color;
        velX = 3;
        velY = -3;
        
    }
    
    public void actualizar(){ 
        if(x >= (600 - this.width)|| x <= 0)
            velX = -velX;
        if (y <= 0){
            y = 1;
            velY *= -1;
        }
        x += velX;
        y += velY;
       
        
    }
    
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillOval(x, y, width, height);
        gg.setColor(Color.ORANGE);
        gg.drawOval(x, y, width, height);
    }
}
