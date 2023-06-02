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
public class Fondo extends Rectangle {
    private Image imagen;
    private int velX = 20;
    
    public Fondo(int ancho, int alto, Image imagen){
        super(0, 0, ancho*2, alto);
        this.imagen = imagen;
    }
    public void paint(Graphics gg, Applet applet){
        gg.drawImage(imagen, x, y, width, height, applet);               
    }
    public void update(){
        if(velX < 0)
            velX = 0;
        if(x < -width/2)
            x = -velX;
        x -= velX;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }
    
}
