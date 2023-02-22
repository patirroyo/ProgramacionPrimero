/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio019;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle {
    Color color = Color.LIGHT_GRAY;
    private int velX;
    private int velY;
    
    public Pelota(Color color){
        super(390,290,20,20);
        this.color = color;
        velX = 4;
        velY = -4;
        
    }
    
    public void actualizar(){ 
        if(y >= (600 - this.height)|| y <= 0)
            velY = -velY;
        x += velX;
        y += velY;
       
        
    }
    
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillOval(x, y, width, height);
        gg.setColor(Color.ORANGE);
        gg.drawOval(x, y, width, height);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
}
