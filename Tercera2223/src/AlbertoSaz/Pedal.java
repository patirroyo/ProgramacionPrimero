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
public class Pedal extends Rectangle {
    private Image imagen;
    
    public Pedal(int x, int y, int ancho, int alto, Image imagen){
        super(x, y, ancho, alto);
        this.imagen = imagen;
    }
    
    public void paint(Graphics gg, Applet applet){
        gg.drawImage(imagen, x, y, width, height, applet);
    }
}
