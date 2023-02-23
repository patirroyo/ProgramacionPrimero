/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio020;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;



public class JugarPelota extends Applet implements Runnable {
    int velocidad = 20;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    Pelota pelota;
    private static int TAM_X = 500;
    private static int TAM_Y = 500;
    List<Pelota> pelotas;
    
    
    
    public void init(){
        this.setSize(TAM_X, TAM_Y);
        pelotas = new ArrayList<Pelota>();
        pelota = new Pelota();
        pelotas.add(pelota);
        imagen = this.createImage(TAM_X, TAM_Y);
        noseve = imagen.getGraphics(); 
    }
    public void start(){
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        animacion.start();//es el que llama a ejecutar el método run
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.BLACK);
       noseve.fillRect(0, 0, TAM_X, TAM_Y);
       if(!pelotas.isEmpty())
            for(Pelota pl : pelotas)
                pl.paint(noseve);
       g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            if(!pelotas.isEmpty())
                for(Pelota pl : pelotas)
                    pl.update();
            repaint();
           
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){
            }
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
       for(Pelota pl : pelotas)
            if(pl.contains(x, y)){
                pelotas.add(new Pelota(x-pl.width/2, y-pl.height/2, pl.width/2));
                pelotas.add(new Pelota(x+pl.width/2, y + pl.height/2, pl.width/2));
                pelotas.remove(pl);
                break;
                
            }
       return false;
         
    }

    public static int getTAM_X() {
        return TAM_X;
    }

    public static int getTAM_Y() {
        return TAM_Y;
    }

   
    
}
    

