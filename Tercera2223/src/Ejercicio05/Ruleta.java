/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio05;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alberto
 */
public class Ruleta extends Applet implements Runnable {
    private Graphics noseve;
    private Image imagen; 
    public final static int SIZEX = 1000;
    public final static int SIZEY = 800;
    private int NUMCASILLAS = 36;
    public static final int ROWS = 12;
    public static final int COLUMNS = 3;
    private boolean win = false;
    private Casilla[][] casillas;
    private List lRojos;
    
    
    public void init(){
        this.setSize(SIZEX, SIZEY);
        
        casillas = new Casilla[ROWS][COLUMNS];
        lRojos = new ArrayList<Integer>();
        
        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLUMNS; j++){
                final int valorCasilla = (i*COLUMNS + j)+1;
                if(numeroEsNegro(valorCasilla))
                    casillas[i][j] = new Casilla(j*Casilla.LADO, i*Casilla.LADO, (i*COLUMNS + j) +1, Color.BLACK);
                else{
                    casillas[i][j] = new Casilla(j*Casilla.LADO, i*Casilla.LADO, (i*COLUMNS + j) +1, Color.RED);
                    lRojos.add(new Integer(valorCasilla));
                }
        }
        
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        
    }

    private static boolean numeroEsNegro(final int valorCasilla) {
        return (valorCasilla % 2 == 0 && (valorCasilla <= 10 || ((valorCasilla > 19) && valorCasilla < 29)))||
                (valorCasilla % 2 == 1 && ((valorCasilla > 10 && valorCasilla < 19)|| valorCasilla >= 29 ));
    }

    
    public void start(){
        

        
    }
    
    public void paint(Graphics g){
       noseve.setColor(new Color(76,106,90));
       noseve.fillRect(0, 0, SIZEX, SIZEY);
       noseve.setColor(Color.BLACK);
     
       for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++)
                casillas[i][j].paint(noseve);
       }
       
       
      
       g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }

    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);  
    }
    
    public void run(){
        while(true){
            
            
            
        }
    }
    
    public boolean mouseDown(Event ev, int x, int y){
       
        
        return true;
    }
    
    public boolean action(Event ev, Object obj){
         if(ev.target instanceof Button){
           
            return true;
         }
         return false;
    }
    
}
