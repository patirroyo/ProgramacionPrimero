/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio02;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Pieza extends Rectangle{
    private Image image;
    public static final int SIZE = 60;
    private boolean ok = false;
    
    public Pieza(Image imagen){
        super((int)(Math.random()*400)+500, (int)(Math.random()*450)+50, SIZE, SIZE);
        this.image = imagen;
       
    }
    
    public void paint(Graphics g, Applet applet){
       g.drawImage(image, x, y, applet);
    }
    public void update(int x, int y){
        if(!ok){  
            this.x = x - SIZE/2;
            this.y = y - SIZE/2;
        }
    }

    public void setOk() {
        this.ok = true;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

   
}
