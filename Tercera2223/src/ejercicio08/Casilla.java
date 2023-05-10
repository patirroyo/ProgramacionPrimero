/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio08;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    private Image imagen;
    private Image reverso;
    private Boolean descubierta;
    public static final int LADO = 128;
    
    
    public Casilla(int posX, int posY, Image img, Image reverso){
        super(posX, posY, LADO, LADO);
        descubierta = false;
        imagen = img;
        this.reverso = reverso;
    }
    
    public void paint(Graphics gg, Applet ap){
        if(descubierta)
            gg.drawImage(imagen, x, y, width, height, ap);
        else
            gg.drawImage(reverso, x, y, width, height, ap);
        gg.setColor(Color.BLACK);
        gg.drawRect(x, y, width, height);
    }

    public Boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(Boolean descubierta) {
        this.descubierta = descubierta;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
}
