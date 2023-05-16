/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio09;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Casilla extends Rectangle {
    public static final int LADO = 50;
    private Image mina;
    private Image reverso;
    private Boolean tapada;
    private int alrededor;
    
    public Casilla(int posX, int posY, Image image){
        super(posX, posY, LADO, LADO);
        tapada = true;
        reverso = image;
        alrededor = 0;
    }
    
    public void paint(Graphics gg, Applet ap){
        gg.setColor(Color.BLACK);
        gg.drawRect(x, y, width, height);
        if(tapada)
            gg.drawImage(reverso, x, y, width, height, ap);
        else if(mina != null)
            gg.drawImage(mina, x, y, width, height, ap);
        else
            gg.drawString("" + alrededor, x+15, y+40);
        
    }

    public Boolean isTapada() {
        return tapada;
    }

    public void destapar() {
        this.tapada = false;
    }

    public Image getMina() {
        return mina;
    }

    public void setMina(Image imagen) {
        mina = imagen;
    }
    
}