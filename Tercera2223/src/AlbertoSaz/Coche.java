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
public class Coche extends Rectangle{
    private Image imagen;
    public static final int POSX = 10;
    public static final int POSY = 390;
    public static final int WIDTH = 360;
    public static final int HEIGHT = 123;
    
    public Coche(Image imagen){
        super(POSX, POSY, WIDTH, HEIGHT);
        this.imagen = imagen;
    }
    
    public void paint(Graphics gg, Applet applet){
        gg.drawImage(imagen, x, y, width, height, applet);               
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
}
