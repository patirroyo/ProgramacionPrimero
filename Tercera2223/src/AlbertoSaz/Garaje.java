/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlbertoSaz;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Garaje extends Rectangle{
    private Image imagen;
    public static final int POSY = 10;
    public static final int WIDTH = 120;
    public static final int HEIGHT = 41;
    
    public Garaje(int x, Image imagen){
        super(x, POSY, WIDTH, HEIGHT);
        this.imagen = imagen;
    }
    
    public void paint(Graphics gg, Applet applet){
        gg.drawImage(imagen, x, y, width, height, applet);
    }

    public Image getImagen() {
        return imagen;
    }
    
    
}
