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
    int actual = 0;
    Image imagenes[];
   
    
    public DibujoAnimado(Image imagenes[]){
        this.imagenes = imagenes;
        
    }
    public void paint(Graphics g, Applet applet){
        g.drawImage(imagenes[actual], 0, 0, applet);
        
    }
    public void update(){
        if(actual < 3)
            actual++;
        else
            actual = 0;
    }
    
}
