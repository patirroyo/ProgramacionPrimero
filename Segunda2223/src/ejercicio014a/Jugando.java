/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio014a;

import java.applet.Applet;
import java.awt.*;


public class Jugando extends Applet implements Runnable {
    int velocidad = 5;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    public static int tamX = 500;
    public static int tamY = 500;
    int radioPelota = 100;
   
    int numPelotas = 250;
    
    Pelota[] pelota; 
    
    
    
    public void init(){
        this.setSize(tamX, tamY);
        pelota = new Pelota[numPelotas];
        for(int i = 0; i < numPelotas; i++)
            pelota[i] = new Pelota((int) (Math.random() * (tamX - radioPelota)),
                                    (int) (Math.random() * (tamY - radioPelota)), 
                                    (int) (Math.random() * radioPelota) + 10 , 
                                    new Color((int)(Math.random() * 0x1000000)), 
                                    (int) (Math.random()*3),
                                    (int) (Math.random()*3));
        imagen = this.createImage(tamX, tamY);//no llamo al constructor, llamo a un método que llamará a un método constructor.
        noseve = imagen.getGraphics(); //obtenemos el objeto graphics del objeto imagen y lo guardamos en noseve   
    }
    public void start(){
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        animacion.start();//es el que llama a ejecutar el método run
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.WHITE);
       noseve.fillRect(0, 0, tamX, tamY);
       for(int i = 0; i < numPelotas; i++)
        pelota[i].paint(noseve);
       g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            for(int i = 0; i < numPelotas; i++)    
                pelota[i].actualizar();
            repaint();
           
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){
            }
        }
    }
    
}
