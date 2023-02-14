/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio017;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Bala extends Rectangle {
    Color color = Color.ORANGE;
    public static final int RADIO = 4;

    
    public Bala(int x){
        super(x-1, Gun.Y, 0, 0);
        this.height = RADIO;
        this.width = RADIO;
        
        
    }

    public void setY(int y) {
        this.y = y;
    }
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillOval(x, y, width, height);
        gg.drawOval(x, y, width, height);
    }
    public void update(){
        y--;
    }
}
