/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio05;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Ficha extends Rectangle{
    private int valor;
    public static final int LADO = 100;
    private Image imagen;
    private static final int XiNICIO = 900;
    
    public Ficha(int y, int valor, Image imagen){
        super(XiNICIO, y, LADO, LADO);
        this.valor = valor;
        this.imagen = imagen;
    }
    public void paint(Graphics gg, Applet ap){
        gg.drawImage(imagen, x, y, width, height, ap);
    }
    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }
}
