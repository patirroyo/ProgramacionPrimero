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
    List<Nave> naves = new ArrayList<Nave>();
    int cronometro = 0;
    int score;
    int scoreMax;
    
    public void init(){
        score = 0;
        scoreMax = 0;
        
        this.setSize(600, 600);
        arma = new Gun();
        nave = new Nave();
        naves.add(nave);
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
       paintNaves();
       paintBalas();
       gameOver();
       paintScore();
       g.drawImage(imagen, 0, 0, this);
    }

    private void paintNaves() {
        for(Nave na: naves)
            na.paint(noseve);
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
            cronometro++;
            loDeLasBalas();
            loDeLasNaves();
            repaint();
           
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){
            }
        }
    }

    public void loDeLasBalas() {
         for(Bala ba : balas){
                ba.update();
            if(ba.y <= 0){
                balas.remove(ba);
                break;
            } 
            for(Nave na: naves){
                if(na.intersects(ba)){
                    na.setVida(na.getVida()-1);
                    ba.setY(0);
                }
                if(na.getVida()<0){
                    naves.remove(na);
                    break;
                }
                
            }
            
            
        }
    }
    public void loDeLasNaves(){
       if(cronometro%5000 == 0){
            naves.add(new Nave());
                
        }
       
        for(Nave na: naves){
            na.update();
            
        }
       
    }
    
    public void startNewGame(){
        
        if(scoreMax < score)
            scoreMax = score;
        score = 0;
        arma = new Gun();
        naves.clear();
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 5; j ++)
                if(i%2==0)
                    naves.add(new Nave((3*j)+2 ,i));
                else
                    naves.add(new Nave((3*j),i));
        
        this.setSize(600, 600);
        
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics(); 
        if(!animacion.isAlive())
            animacion.start();
        else
            animacion.resume();
        
    }
    public boolean mouseDown(Event ev, int x, int y){
       if(animacion.isAlive()){
           balas.add(new Bala(x));
           return true;
       }
       return false;
         
    }
    
    public boolean mouseMove(Event ev, int x, int y){
        arma.setX(x - arma.arma.width/2);
        
        return true;
    }
    
    public boolean keyDown(Event ev, int tecla){
        if(tecla == 1006)
            arma.update(1);
        if(tecla == 1007)
            arma.update(-1);
        
        if(tecla == 32){//barra espaciadora
            if(animacion.isAlive()){
                balas.add(new Bala((int)(arma.canon.getX())+ arma.canon.width/2));
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

