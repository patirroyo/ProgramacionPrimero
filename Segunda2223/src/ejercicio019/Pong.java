/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio019;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import static javafx.scene.paint.Color.rgb;



public class Pong extends Applet implements Runnable {
    final int VELOCIDADINICIAL = 20;
    int velocidad;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    Pelota pelota;
    Raqueta raqueta1, raqueta2;
    int score1, score2;
    final int ARRIBA = -1;
    final int ABAJO = 1;
    boolean fin = false;
    
    public void init(){
        pelota = new Pelota(Color.WHITE);
        raqueta1 = new Raqueta(1);
        raqueta2 = new Raqueta(2);
        
        this.setSize(800, 600);
       
        imagen = this.createImage(800, 600); 
        noseve = imagen.getGraphics();
        
    }
    
    
    public void start(){
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        //animacion.start();//es el que llama a ejecutar el método run
        
        
    }
    
    public void paint(Graphics g){
       paintBoard();
       pelota.paint(noseve);
       paintPantallaInicio();
       raqueta1.paint(noseve);
       raqueta2.paint(noseve);
       paintScore();
       fin();
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
    public void startNewGame(){
        if(!animacion.isAlive())
            animacion.start();
        fin = false;
        velocidad = VELOCIDADINICIAL;
        score1 = score2 = 0;
        pelota = new Pelota(Color.WHITE);
        raqueta1 = new Raqueta(1);
        raqueta2 = new Raqueta(2);
        this.setSize(800, 600);
       
        imagen = this.createImage(800, 600); 
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
       if(ev.key == 32){//barra espaciadora
           startNewGame();
           return true;
       }           
        return false;
    }
    public boolean mouseMove(Event ev, int x, int y){
        raqueta1.y = y - raqueta1.height/2;
        
        return true;
    }
    private void paintBoard() {
        noseve.setColor(new Color(76,106,90));
        noseve.fillRect(0, 0, 800, 600);
        noseve.setColor(Color.LIGHT_GRAY);
        noseve.fillRect(0, 297, 800, 6);
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 0, 800, 10);
        noseve.fillRect(0, 100, 800, 10);
        noseve.fillRect(0, 490, 800, 10);
        noseve.fillRect(0, 590, 800, 10);
        noseve.setColor(Color.DARK_GRAY);
        noseve.fillRect(395, 10, 10, 580);
        
    }
    private void paintScore() {
        if(!fin){
            noseve.setFont(new Font("Arial", Font.BOLD, 16));
            noseve.setColor(Color.BLACK);
            noseve.drawString("Nadal: " + String.valueOf(score1), 159, 49);
            noseve.drawString("Nadal: " + String.valueOf(score1), 159, 51);
            noseve.drawString("Nadal: " + String.valueOf(score1), 161, 49);
            noseve.drawString("Nadal: " + String.valueOf(score1), 161, 51);
            noseve.setColor(Color.WHITE);
            noseve.drawString("Alcaraz: " + String.valueOf(score2), 549, 49);
            noseve.drawString("Alcaraz: " + String.valueOf(score2), 549, 51);
            noseve.drawString("Alcaraz: " + String.valueOf(score2), 551, 49);
            noseve.drawString("Alcaraz: " + String.valueOf(score2), 551, 51);
            noseve.setColor(raqueta1.getColor());
            noseve.drawString("Nadal: " + String.valueOf(score1), 160, 50);
            noseve.setColor(raqueta2.getColor());
            noseve.drawString("Alcaraz: " + String.valueOf(score2), 550, 50);
        }
    }

    private void paintPantallaInicio() {
        if(!animacion.isAlive()){
            noseve.setColor(Color.BLACK);
            noseve.drawString("Para jugar pulsa", 279, 449);
            noseve.drawString("la barra espaciadora", 414, 449);
            noseve.drawString("Para jugar pulsa", 279, 451);
            noseve.drawString("la barra espaciadora", 414, 451);
            noseve.drawString("Para jugar pulsa", 281, 449);
            noseve.drawString("la barra espaciadora", 416, 449);
            noseve.drawString("Para jugar pulsa", 281, 451);
            noseve.drawString("la barra espaciadora", 416, 451);
            noseve.setColor(Color.WHITE);
            noseve.drawString("Para jugar pulsa", 280, 450);
            noseve.drawString("la barra espaciadora", 415, 450);
        }
    }
    private void fin() {
        if(fin){
            noseve.setFont(new Font("Arial", Font.BOLD, 22));
            if(score1 > score2){
                noseve.setColor(Color.BLACK);
                noseve.drawString("NADAL", 364, 249);
                noseve.drawString("GANA", 364, 349);
                noseve.drawString("NADAL", 364, 251);
                noseve.drawString("GANA", 364, 351);
                noseve.drawString("NADAL", 366, 251);
                noseve.drawString("GANA", 366, 351);
                noseve.drawString("NADAL", 366, 249);
                noseve.drawString("GANA", 366, 349);
                noseve.setColor(raqueta1.getColor());
                noseve.drawString("NADAL", 365, 250);
                noseve.drawString("GANA", 365, 350);
            }else if(score1 < score2){
                noseve.setColor(Color.WHITE);
                noseve.drawString("ALCARAZ", 349, 249);
                noseve.drawString("GANA", 364, 349);
                noseve.drawString("ALCARAZ", 349, 251);
                noseve.drawString("GANA", 364, 351);
                noseve.drawString("ALCARAZ", 351, 251);
                noseve.drawString("GANA", 366, 351);
                noseve.drawString("ALCARAZ", 351, 249);
                noseve.drawString("GANA", 366, 349);
                noseve.setColor(raqueta2.getColor());
                noseve.drawString("ALCARAZ", 350, 250);
                noseve.drawString("GANA", 365, 350);
            } 
            pelota.setVelX(0);
            pelota.setVelY(0);
        }
    }
    private void hacerTrampa() {
        raqueta2.y = pelota.y + pelota.height/2 - raqueta2.height/2;
    }

    private void loDeLaPelota() {
        if(pelota.intersects(raqueta1)){
            pelota.setVelX(pelota.getVelX()*-1);
            pelota.color = raqueta1.getColor();
            if(pelota.y - raqueta1.y < 5 && pelota.getVelY() > 0)
                pelota.setVelY(pelota.getVelY()*-1);
            if(pelota.y - raqueta1.y > raqueta1.height - pelota.height &&
                    pelota.getVelY() < 0)
                pelota.setVelY(pelota.getVelY()*-1);
            velocidad--;
        }
        if(pelota.intersects(raqueta2)){
            pelota.setVelX(pelota.getVelX()*-1);
            pelota.color = raqueta2.getColor();
            if(pelota.y - raqueta2.y < 5 && pelota.getVelY() > 0)
                pelota.setVelY(pelota.getVelY()*-1);
            if(pelota.y - raqueta2.y > raqueta2.height - pelota.height &&
                    pelota.getVelY() < 0)
               pelota.setVelY(pelota.getVelY()*-1);
            //velocidad--; //Solo hago que vaya mas rapido con una raqueta, es mas divertido
        }
        if(pelota.x <= -10){
            score2++;
            if(score2 == 10)
                fin = true;
            //pelota.x = raqueta1.x + raqueta1.width+100;
            //pelota.y = 290;
            pelota.setVelX(pelota.getVelX()*-1);
            pelota.color = Color.WHITE;
            velocidad = VELOCIDADINICIAL;
        }
        if(pelota.x >= 790){
            score1++;
            if(score1 == 10)
                fin = true;
            //pelota.x = raqueta2.x - raqueta2.width - pelota.width-100;
            //pelota.y = 290;
            pelota.setVelX(pelota.getVelX()*-1);
            pelota.color = Color.WHITE;
            velocidad = VELOCIDADINICIAL;
        }
         pelota.actualizar();
    }  
}