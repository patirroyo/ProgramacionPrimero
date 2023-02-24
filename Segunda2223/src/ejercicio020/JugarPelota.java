/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio020;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;



public class JugarPelota extends Applet implements Runnable {
     static final int VELOCIDAD = 20;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    Pelota pelota;
    private static int TAM_X = 500;
    private static int TAM_Y = 500;
    List<Pelota> pelotas;
    Boolean win = false;
    int timer = 0;
    int segundos = 0;
    int minutos = 0;
    
    
    
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
       else
           win = true;
       noseve.setColor(Color.YELLOW);
       noseve.drawString(Integer.toString(minutos) + " : " + 
                        Integer.toString(segundos) + " : " + 
                        Integer.toString(timer*2), 20, 480);
       win();
       g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            timer++;
            if(timer*VELOCIDAD == 800){//ajustado para que mas o menos coincida con el reloj; 
                //se debería usar un objeto de la clase Date para obtener los segundos y que fuera fiable
                segundos++;
                timer = 0;
            }
            if(segundos == 60){
                minutos++;
                segundos = 0;
            }
            if(!pelotas.isEmpty())
                for(Pelota pl : pelotas)
                    pl.update();
            repaint();
           
            try {
                Thread.sleep(VELOCIDAD);
            } catch (InterruptedException ex){
            }
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
       for(Pelota pl : pelotas)
            if(pl.contains(x, y)){
                if(pl.width > 15){
                    pelotas.add(new Pelota(x-pl.width/4, y - pl.height/4, pl.width/2));
                    pelotas.add(new Pelota(x+pl.width/4, y + pl.height/4, pl.width/2));
                }
                pelotas.remove(pl);
                break;
                
            }
       return false;
         
    }
    
    private void win() {
        if(win){
            noseve.setFont(new Font("Arial", Font.BOLD, 20));
            noseve.setColor(Color.WHITE);
            noseve.drawString("HAS GANADO ", 150, 200);
            noseve.drawString("Tiempo: " + Integer.toString(minutos) + " : " + 
                        Integer.toString(segundos) + " : " + 
                        Integer.toString(timer*2), 125, 225);
            animacion.stop();
        }
    }

    public static int getTAM_X() {
        return TAM_X;
    }

    public static int getTAM_Y() {
        return TAM_Y;
    }

   
    
}
    

