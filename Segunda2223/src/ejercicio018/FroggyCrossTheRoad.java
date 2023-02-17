/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio018;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;


public class FroggyCrossTheRoad extends Applet implements Runnable{
    int velocidad = 10;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    Rana rana;
    boolean gameOver = false;
    boolean win = false;
    
    
    public void init(){
        this.setSize(600, 600);
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics(); 
        rana = new Rana();
    }
    public void start(){
        animacion = new Thread(this);
    }
    
     public void paint(Graphics g){
       noseve.setColor(Color.LIGHT_GRAY);
       noseve.fillRect(0, 0, 600, 600);
       noseve.setColor(Color.WHITE);
       rana.paint(noseve);
       tituloInicio();
       paintGameOver();
       paintWin();
       g.drawImage(imagen, 0, 0, this);
    }
     public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
  
    
    public void run(){
        while(true){
            rana.update();
            repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){
            }
        }
    }
    public void startNewGame(){
       
        rana = new Rana();
        this.setSize(600, 600);
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics();
        gameOver = false;
        win = false;
        if(!animacion.isAlive())
            animacion.start();
        else
            animacion.run();
    }
    
    
    private void tituloInicio() {
        if(!animacion.isAlive()){
            noseve.setColor(Color.WHITE);
            noseve.drawString("Para jugar o para ", 235, 250);
            noseve.drawString("reiniciar pulsa ENTER", 230, 275);
            noseve.drawString("Para disparar pulsa ", 235, 325);
            noseve.drawString("la barra espaciadora", 230, 350);
        }
    }
        public boolean keyDown(Event ev, int tecla){
       if(!win || !gameOver){
            switch(tecla){
                case 1006: //izquierda
                    rana.update(Rana.IZQUIERDA);
                    return true;
                case 1007: //derecha
                    rana.update(Rana.DERECHA);
                    return true;
                case 1004: //arriba
                    rana.update(Rana.ARRIBA);
                    return true;
                case 1005://abajo
                    rana.update(Rana.ABAJO);
                    return true;
                case 10://intro
                    startNewGame();
                    return true;
            }
       }
        return false;
    }
    private void paintGameOver() {
        if(gameOver){
            noseve.setColor(Color.RED);
            noseve.drawString("GAME OVER ", 240, 275);
            noseve.drawString("Para reiniciar pulsa ENTER", 225, 305);
        }
    }
    private void paintWin() {
        if(win){
            noseve.setColor(Color.YELLOW);
            noseve.drawString("HAS GANADO ", 240, 275);
            noseve.drawString("Para reiniciar pulsa ENTER", 225, 305);
        }
    }
}
