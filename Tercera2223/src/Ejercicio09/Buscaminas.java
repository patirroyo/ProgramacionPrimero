/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio09;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author alberto
 */
public class Buscaminas extends Applet implements Runnable {
    public static final int FILAS = 10;
    public static final int COLUMNAS = 10;
    public final static int SIZEX = 500;
    public final static int SIZEY = 500;
    private Image imagen; 
    private Graphics noseve;
    private Thread animacion;
    private int delay = 200;
    private Image reverso;
    private Image[] imagenes;
    private Casilla[][] casillas;
    private Casilla activa1;
    private Casilla activa2;
    private int contador;
    private int descubiertas;
    private int fallos;
    
    public void init(){
        this.setSize(SIZEX, SIZEY);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        
        reverso = getImage(getCodeBase(), "Ejercicio09/Imagenes/casilla.png");
        
        
        casillas = new Casilla[FILAS][COLUMNAS];
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++)   
                casillas[i][j] = new Casilla(j*Casilla.LADO, i*Casilla.LADO, reverso);
        
        

    }

    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        //noseve.fillRect(0, 0, SIZEX, SIZEY);
        noseve.setColor(Color.BLACK);
        
        for(int i = 0; i < FILAS; i++)
             for(int j = 0; j < COLUMNAS; j++){
                 casillas[i][j].paint(noseve, this);
                 
             }
        
        
        
        
        
        
      
       g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
        
    }
    
    public void run(){
        while(true){
            contador++;
            if(contador == 1000/delay){
                repaint();
            }
            
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++)
                if(casillas[i][j].contains(x,y)){
                    casillas[i][j].destapar();
                    repaint();
                }
        return false;
    } 

    public boolean mouseUp(Event ev, int x, int y){
        

        return true;
    } 
}