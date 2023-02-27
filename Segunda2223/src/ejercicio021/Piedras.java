/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio021;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Piedras extends Rectangle {
    Random random = new Random();
    Color color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)); ;
    int velX = -4;  
    
    public Piedras(){
        super(Juego.POS_INI_X, 438, 15, 12);
        switch ((int)(Math.random()*4)){
            case 0:
                this.height *= 2;
                this.y -= 12;
                this.width *= 2;
                break;
            case 1:
                this.height *= 2;
                this.y -= 12;
                break;
            case 2:
                this.width *= 2;
        }
        
    }

    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fill3DRect(x, y, width, height, true);
        
    }
    
    public void update(){
       x += velX;
      
        
    }
}