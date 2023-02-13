/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio017;


import java.applet.Applet;
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
public class Marcianitos extends Applet implements Runnable {
   
    int velocidad = 10;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    
    Gun arma;
    Nave nave;
    List<Bala> balas = new ArrayList<Bala>();
    int cronometro = 0;
    int score;
    int scoreMax;
    
    public void init(){
        score = 0;
        scoreMax = 0;
        
        this.setSize(600, 600);
        arma = new Gun();
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
       tituloInicio();
       arma.paint(noseve);
       paintBalas();
       gameOver();
       paintScore();
       g.drawImage(imagen, 0, 0, this);
    }

    private void paintBalas() {
        for(Bala ba : balas)
            ba.paint(noseve);
    }

    private void paintScore() {
        noseve.setColor(Color.WHITE);
        noseve.drawString("SCORE: " + Integer.toString(score), 20, 580);
        noseve.drawString("MAX: " + Integer.toString(scoreMax), 20, 560);
    }

    private void gameOver() {
        /*if(pajaro.velY == 0){
          noseve.setColor(Color.WHITE); 
          if(pajaro.y >= 250){
            noseve.drawString("GAME OVER ", 235, pajaro.y- 175 );
            noseve.drawString("Para reiniciar pulsa ENTER", 220, pajaro.y- 150);
          }else{
              noseve.drawString("GAME OVER ", 235, pajaro.y + 155 );
              noseve.drawString("Para reiniciar pulsa ENTER", 220, pajaro.y + 175);
          }  
        }*/
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
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            for(Bala ba : balas)
                ba.update();
            //loDeLasColumnas();
            
            repaint();
           
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){
            }
        }
    }

    private void loDeLasBalas() {
       /* for(Column co : columns){
            co.update();
            if(co.getParteArriba().x == 300){
                columns.add(new Column());
                break;
            }
            if(pajaro.intersects(co.getParteArriba())||
                    pajaro.intersects(co.getParteAbajo())||
                    pajaro.intersects(co.getBocaArriba())||
                    pajaro.intersects(co.getBocaAbajo())){
                pajaro.velY = 0;
                repaint();
                animacion.suspend();
               break;
           
            }
            if(co.getParteAbajo().x + co.getParteAbajo().width == pajaro.x - pajaro.width){
                score++;
            }
            if(co.getParteAbajo().x + co.getParteAbajo().width <= 0){
                columns.remove(co);
                break;
            }
            
            
        }*/
    }
    
    public void startNewGame(){
        if(!animacion.isAlive())
            animacion.start();
        else
            animacion.resume();
        if(scoreMax < score)
            scoreMax = score;
        score = 0;
        arma = new Gun();
        nave = new Nave();
        this.setSize(600, 600);
        
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics(); 
        
        
    }
    public boolean mouseDown(Event ev, int x, int y){
       if(animacion.isAlive()){
           balas.add(new Bala(x));
           return true;
       }
       return false;
         
    }
    
    public boolean mouseMove(Event ev, int x, int y){
        arma.setX(x - arma.width/2);
        
        return true;
    }
    
    public boolean keyDown(Event ev, int tecla){
        if(tecla == 1006)
            arma.update(1);
        if(tecla == 1007)
            arma.update(-1);
        
        if(tecla == 32){//barra espaciadora
            if(animacion.isAlive()){
                balas.add(new Bala((int)(arma.getX())+ arma.width/2));
                return true;
       }
      
       }
       if(tecla == 10){
            startNewGame();
            return true;
           
       }
       
       return false;
    }
}    

