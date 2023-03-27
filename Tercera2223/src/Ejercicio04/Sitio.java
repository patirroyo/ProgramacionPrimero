/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio04;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Sitio extends Rectangle{
    public final static int SIZE = 48;
    private Image imagen;
    
    public Sitio(int x, int y, Image img){
        super(x, y, SIZE, SIZE);
        imagen = img;
    }
    
    public void paint(Graphics g, Applet a){
        if(imagen == null)
            return;
        g.drawImage(imagen, x, y, a);
    }
}
