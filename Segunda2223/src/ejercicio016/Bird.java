/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio016;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Bird extends Rectangle {
    public static final int RADIO = 40;
    public int velY = 2;
    
    
    
    public Bird(){
        super(250, 250, 0, 0);
        this.height = RADIO;
        this.width = RADIO;
       
        
    }
    public void paint(Graphics gg){
        int[] xPoints = {x + width, x + width, x + width +10};
        int[] yPoints = {y+6+RADIO/2,y-6+RADIO/2,y+RADIO/2};
        
        
        gg.setColor(Color.RED);
        gg.fillOval(x, y, width, height);
        gg.setColor(Color.BLACK);
        gg.drawOval(x, y, width, height);
        gg.fillRect(x + 2*width/3, y + height/4, width/8, height/8);
        gg.drawPolygon(xPoints, yPoints, xPoints.length);
        gg.setColor(Color.YELLOW);
        gg.fillPolygon(xPoints, yPoints, xPoints.length);
    }
    public void update(){
        if(y<600-RADIO)
            y += velY;
        else
            y = 600 - RADIO;
        if(y <= 0)
            y = 0;
    }
    public void saltar() {
        y -=50;
    }
}

