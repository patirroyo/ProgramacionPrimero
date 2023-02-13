/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio015;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Bonus extends Rectangle {
    Color color;
    public static final int RADIO = 15;

    
    public Bonus(int x, int y, Color color){
        super(x, y, 0, 0);
        this.height = RADIO;
        this.width = RADIO;
        this.color = color;
        
    }
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillOval(x, y, width, height);
        gg.drawOval(x, y, width, height);
    }
    public void update(){
        y++;
    }
}
