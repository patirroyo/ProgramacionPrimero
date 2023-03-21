/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio03;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Globo extends Rectangle{
    private Image imagen;
    Image explosion; 
    private int velY;
    private boolean explotado = false;
    
    public Globo(Image img, Image explota){
        super(Robin.SIZEX - 150, Robin.SIZEY, 100, 100);
        imagen = img;
        explosion = explota;
        velY = - ((int)(Math.random()*3) + 2);
    }
    public void paint(Graphics g, Applet applet){
        if(!explotado)
            g.drawImage(imagen, x, y, width, height, applet);
        else
            g.drawImage(explosion, x, y, width, height, applet);
    }
    public void update(){
        y += velY;
    }

    public void setExplotado() {
        explotado = true;
    }
    
}
