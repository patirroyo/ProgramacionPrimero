/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio014;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author alber
 */
public class Jugando extends Applet implements Runnable {
    public static final int NUM_PEL = 5;
    int velocidad = 30;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    List<Pelota> pelotas;//creo una lista de Pelotas
    
   /* int posX = (int)(Math.random()*350);
    int posY =  (int)(Math.random()*350);
    int anchura = 40;
    Color color =  Color.RED;  
    
    Esto no hace falta porque lo hacemos con el metodo constructor de la pelota
    */
    
    public void init(){
        pelotas = new ArrayList<Pelota>(); //pelotas es un array de pelotas
        this.setSize(400, 400);
        for(int i = 0; i<NUM_PEL; i++)
            pelotas.add(new Pelota()); //añado las pelotas a la lista
        imagen = this.createImage(400, 400); //no llamo al constructor, llamo a un método que llamará a un método constructor.
        noseve = imagen.getGraphics(); //obtenemos el objeto graphics del objeto imagen y lo guardamos en noseve   
    }
    public void start(){
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        animacion.start();//es el que llama a ejecutar el método run
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.BLACK);
       noseve.fillRect(0, 0, 400, 400);
       for(int i = 0; i < pelotas.size(); i++) //pinto todos los elementos de la lista
           pelotas.get(i).paint(noseve);
       g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            for(Pelota pl : pelotas)//actualizo todas los elementos de la lista
                pl.actualizar();
            repaint();
           
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){
            }
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
       for(Pelota pl : pelotas)//recorro todas los elementos de la lista
            if(pl.contains(x, y)){//si alguna pelota contiene los puntos donde se ha hecho el click
                pelotas.remove(pl);//la eliminamos de la lista
                return true;
            }
       return false;
         
    }
    
}
