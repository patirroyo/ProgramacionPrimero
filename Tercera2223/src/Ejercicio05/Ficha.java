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
import java.util.ArrayList;


/**
 *
 * @author alberto
 */
public class Ficha extends Rectangle{
    private static final int XiNICIO = 900;
    public static final int LADO = 70;
    private int valor;
    private Image imagen;
    private ArrayList<Integer> apuestas;
    
    public Ficha(int y, int valor, Image imagen){
        super(XiNICIO, y, LADO, LADO);
        this.valor = valor;
        this.imagen = imagen;
        apuestas = new ArrayList<Integer>();
    }
    public void paint(Graphics gg, Applet ap){
        gg.drawImage(imagen, x, y, width, height, ap);
    }
    public void move(int x, int y){
        this.x = x - Ficha.LADO/2;
        this.y = y - Ficha.LADO/2;
    }
    public void setApuestas(Casilla[][] casillas){
        for(int i = 0; i < Ruleta.ROWS; i++)
            for(int j = 0; j < Ruleta.COLUMNS; j++)
               if(casillas[i][j].intersects(this)){
                    apuestas.add(casillas[i][j].getValor());
                    System.out.println("Ficha : "+ valor + " Añadido apuesta: " + casillas[i][j].getValor());
               }
    }
    public void clearApuestas(){
        apuestas.clear();
        System.out.println("Ficha : "+ valor + " Borradas apuestas");
    }

    public int getValor() {
        return valor;
    }

    public ArrayList<Integer> getApuestas() {
        return apuestas;
    }
    
}
