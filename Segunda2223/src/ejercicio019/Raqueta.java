/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio019;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author alber
 */
public class Raqueta extends Rectangle {
    Color color;
    int velY;
    
    public Raqueta(int numero){
        super(20,250,10,100);
        color = Color.YELLOW;
        velY = 30;
        if(numero == 2){
            this.x = 580;
            this.color = Color.PINK;
        }
    }
    

    
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillRect(x, y, width, height);
        gg.setColor(Color.LIGHT_GRAY);
        gg.drawRect(x, y, width, height);
        
        
    }
    public void update(int direccion){
        y += (velY * direccion);
    }
}
