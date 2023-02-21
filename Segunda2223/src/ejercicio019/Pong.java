/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio019;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class Pong extends Applet implements Runnable {
    int velocidad;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    Pelota pelota;
    Raqueta raqueta1, raqueta2;
    int score1, score2;
    final int ARRIBA = -1;
    final int ABAJO = 1;
    boolean fin = true;
    
    public void init(){
        pelota = new Pelota(Color.WHITE);
        raqueta1 = new Raqueta(1);
        raqueta2 = new Raqueta(2);
        
        this.setSize(600, 600);
       
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics();
        
    }
    
    
    public void start(){
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        //animacion.start();//es el que llama a ejecutar el método run
        
        
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.BLACK);
       noseve.fillRect(0, 0, 600, 600);
       pelota.paint(noseve);
       if(!animacion.isAlive()){
            noseve.setColor(Color.WHITE);
            noseve.drawString("Para jugar pulsa", 235, 450);
            noseve.drawString("la barra espaciadora", 230, 475);
       }
       raqueta1.paint(noseve);
       raqueta2.paint(noseve);
       
       
        if(!fin){
            noseve.setColor(Color.WHITE);
            noseve.drawString("Player 1: " + String.valueOf(score1), 200, 50);
            noseve.drawString("Player 2: " + String.valueOf(score2), 400, 50);
       }
        
       g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            loDeLaPelota();
            //hacerTrampa();//para hacer pruebas
            repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){           
            }
        }
    }

    private void hacerTrampa() {
        raqueta2.y = pelota.y + pelota.height/2 - raqueta2.height/2;
    }

   

    private void loDeLaPelota() {
        if(pelota.intersects(raqueta1)){
            pelota.velX *= -1;
            pelota.color = raqueta1.color;
            if(pelota.y - raqueta1.y < 5 && pelota.velY > 0)
                pelota.velY = -pelota.velY;
            if(pelota.y - raqueta1.y > raqueta1.height - pelota.height &&
                    pelota.velY < 0)
                pelota.velY = -pelota.velY;
        }
        if(pelota.intersects(raqueta2)){
            pelota.velX *= -1;
            pelota.color = raqueta2.color;
            if(pelota.y - raqueta2.y < 5 && pelota.velY > 0)
                pelota.velY = -pelota.velY;
            if(pelota.y - raqueta2.y > raqueta2.height - pelota.height &&
                    pelota.velY < 0)
                pelota.velY = -pelota.velY;
        }
        if(pelota.x <= 0){
            score2++;
            pelota.x = raqueta1.x + raqueta1.width+100;
            pelota.y = 290;
            pelota.velX *= -1;
            pelota.color = Color.WHITE;
        }
        if(pelota.x >= 590){
            score1++;
            pelota.x = raqueta2.x - raqueta2.width - pelota.width-100;
            pelota.y = 290;
            pelota.velX *= -1;
            pelota.color = Color.WHITE;
        }
         pelota.actualizar();
    }

   
    public void startNewGame(){
        if(!animacion.isAlive())
            animacion.start();
        fin = false;
        velocidad = 15;
        score1 = score2 = 0;
        pelota = new Pelota(Color.WHITE);
        raqueta1 = new Raqueta(1);
        raqueta2 = new Raqueta(2);
        this.setSize(600, 600);
       
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics();  
    }
    public boolean keyDown(Event ev, int tecla){
       //método para mover la raqueta con las teclas 1006 izda y 1007 dcha
       if(ev.key == 1004 && raqueta1.y > 0){
           raqueta1.update(ARRIBA);
           return true;
       }
       if(ev.key == 1005 && raqueta1.y < 600 - raqueta1.height){
           raqueta1.update(ABAJO);
           return true;
       }
       if(ev.key == 1006 && raqueta2.y > 0){
           raqueta2.update(ARRIBA);
           return true;
       }
       if(ev.key == 1007 && raqueta2.y < 600 - raqueta2.height){
           raqueta2.update(ABAJO);
           return true;
       }
       if(fin && ev.key == 32){//barra espaciadora
           
           startNewGame();
           return true;
       }           
        return false;
    }
    public boolean mouseMove(Event ev, int x, int y){
        raqueta1.y = y - raqueta1.height/2;
        
        return true;
    }

    
}