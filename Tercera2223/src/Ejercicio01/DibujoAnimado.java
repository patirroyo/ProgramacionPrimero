/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio01;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author alber
 */
public class DibujoAnimado {
    private int actual = 0;//indice para indicar la imagen que se está mostrando
    private static final int SIZEY = 300;
    private static final int SIZEX = 200;
    private Image imagenes[];
   
    
    public DibujoAnimado(Image imagenes[]){
        this.imagenes = imagenes;
        
    }
    public void paint(Graphics g, Applet applet){
        //200 anchura, 300 altura
        g.drawImage(imagenes[actual], 0, 0, SIZEX, SIZEY, applet);
        
    }

    public void update(){
        actual = ++actual % imagenes.length;
    }

    public Image[] getImagenes() {
        return imagenes;
    }
    
    public void setImagenes(Image[] imagenes) {
        this.imagenes = imagenes;
    }
    
}
