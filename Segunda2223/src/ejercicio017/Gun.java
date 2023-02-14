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
public class Gun{
    Color color;
    int velX; 
    static int Y = 525;
    Rectangle arma;
    Rectangle canon;
    
    
    
    public Gun(){
        arma = new Rectangle(280,525,30,10);
        canon = new Rectangle(arma.x + 10, arma.y - arma.height, 10,10);
        color = Color.ORANGE;
        velX = 10;
    }
    
    public void paint(Graphics g){
       g.setColor(color);
       g.fillRect(arma.x, arma.y, arma.width, arma.height);
       g.fillRect(canon.x, canon.y, canon.width, canon.height);
       g.setColor(Color.WHITE);
       g.drawRect(arma.x, arma.y, arma.width, arma.height);
       g.drawRect(canon.x, canon.y, canon.width, canon.height);
    }
    
    public void update(int velX){
        if(velX < 0){
            arma.x += this.velX;
            canon.x += this.velX;
        }
        else{
            arma.x -= this.velX;
            canon.x -= this.velX;
        }
    }

     public void setX(int x) {
        this.arma.x = x;
        this.canon.x = arma.x + 10;
    }
    
 

   

  
    
}
