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
public class Flecha extends Rectangle{
    Image imagen;
    int velX = 4;
    
    public Flecha(int y, Image img){
        super(100, y-30, 50, 25);
        imagen = img;
    }
    public void paint(Graphics g, Applet applet){
        g.drawImage(imagen, x, y, width, height, applet);
    }
    public void update(){
        x += velX;
        
    }
}
