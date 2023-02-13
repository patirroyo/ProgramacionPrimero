/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio017;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Gun extends Rectangle{
    Color color;
    int velX; 
    static int Y = 525;

   
    public static int ANCHO = 30;
    public static int ALTO = 10;
    
    
    public Gun(){
        super(280,525,30,10);
        color = Color.ORANGE;
        velX = 10;
    }
    
    public void paint(Graphics g){
       g.setColor(color);
       g.fillRect(x, y, width, height);
       g.fillRect(x+width/2-5, y-10, 10, 10);
       g.setColor(Color.WHITE);
       g.drawRect(x, y, width, height);
       g.drawRect(x+width/2-5, y-10, 10, 10);
    }
    
    public void update(int velX){
        if(velX < 0)
            x += this.velX;
        else
            x -= this.velX;
    }

     public void setX(int x) {
        this.x = x;
    }
    
 

   

  
    
}
