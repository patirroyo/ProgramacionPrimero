/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio09;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Carita extends Rectangle {
    public static final int LADO = 40;
    private Image carita;
    private boolean click;
    
    public Carita(Image imagen){
        super(Buscaminas.SIZEX/2-LADO/2, Buscaminas.TOP-(LADO+LADO/2), LADO, LADO);
        carita = imagen;
        click = true;
    }
    
    public void paint(Graphics gg, Applet ap){
        gg.setColor(Color.LIGHT_GRAY);
        gg.fill3DRect(x, y, width, height, click);
        gg.drawImage(carita, x, y, width, height, ap);
        
    }

    public void setClick(){
        click = false;
    }
}