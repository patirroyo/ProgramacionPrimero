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
public class Arquero{
    Image imagen;
    int posY;
    
    public Arquero(Image img){
        posY = 250;
        imagen = img;
    }
    public void paint(Graphics g, Applet applet){
        g.drawImage(imagen, 0, posY, 100, 120, applet);
    }
    public void update(int x, int y){
        posY = y - 75;
        if(y < 75)
            posY = 0;
        if(y > Robin.SIZEY - 75)
            posY = Robin.SIZEY - 150;
    }
}
