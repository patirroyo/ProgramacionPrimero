/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio014;

import java.awt.*;

/**
 La clase Rectangle tiene 4 atributos x, y, width, height
 * y varios métodos:
 * -intersect: si dos rectangulos intersectan
 * -contains: si un punto está dentro del rectangulo
 */
public class Pelota extends Rectangle {
    Color color;
    int velX;
    int velY;
    
    public Pelota(){
        super();
        this.x = (int)(Math.random()*350);
        this.y = (int)(Math.random()*350);
        this.height = this.width = (int)(Math.random()*50) +10;
        this.color = new Color((int)(Math.random() * 0x1000000));
        velX = (int)(Math.random()*5) + 1;
        velY = (int)(Math.random()*5) + 1;
        
    }
    
    public void actualizar(){ 
        if(x >= (400 - this.width)|| x <= 0)
            velX = -velX;
        if (y >= (400 - width)|| y <= 0)
            velY *= -1;
        x += velX;
        y += velY;
        
    }
    public void matar(){
        this.color = Color.BLACK;
    }
    
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillOval(x, y, width, height);
    }
    
}
