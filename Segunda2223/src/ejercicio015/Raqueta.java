/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio015;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author alber
 */
public class Raqueta extends Rectangle {
    Color color;
    int velX;
    
    public Raqueta(){
        super(250,550,100,10);
        color = Color.WHITE;
        velX = 10;
      
        
    }
    

    
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillRect(x+10, y, width-20, height);
        gg.setColor(Color.LIGHT_GRAY);
        gg.fillRect(x, y, 10, height);
        gg.fillRect(x+width-10, y, 10, height);
        gg.setColor(color);
        gg.drawRect(x, y, width, height);
        
    }
    public void update(int direccion){
        x += (velX * direccion);
    }
}
