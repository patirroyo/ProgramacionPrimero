/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio016;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alber
 */
public class FlappyBird extends Applet implements Runnable {
   
    int velocidad = 10;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    Bird pajaro;
    List<Column> columns = new ArrayList<Column>();
    Column primeraColumna;
    int score;
    int scoreMax;
    
    public void init(){
        score = 0;
        scoreMax = 0;
        pajaro = new Bird();
        primeraColumna = new Column();
        columns.add(primeraColumna);
        this.setSize(600, 600);
        
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics(); 
    }
    public void start(){
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        //animacion.start();//es el que llama a ejecutar el método run
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.CYAN);
       noseve.fillRect(0, 0, 600, 600);
       tituloInicio();
       paintColumns();
       pajaro.paint(noseve);
       gameOver();
       paintScore();
       g.drawImage(imagen, 0, 0, this);
    }

    private void paintColumns() {
        for(Column co : columns)
            co.paint(noseve);
    }

    private void paintScore() {
        noseve.setColor(Color.WHITE);
        noseve.drawString("SCORE: " + Integer.toString(score), 20, 580);
        noseve.drawString("MAX: " + Integer.toString(scoreMax), 20, 560);
    }

    private void gameOver() {
        if(pajaro.velY == 0){
          noseve.setColor(Color.WHITE); 
          if(pajaro.y >= 250){
            noseve.drawString("GAME OVER ", 235, pajaro.y- 175 );
            noseve.drawString("Para reiniciar pulsa ENTER", 220, pajaro.y- 150);
          }else{
              noseve.drawString("GAME OVER ", 235, pajaro.y + 155 );
              noseve.drawString("Para reiniciar pulsa ENTER", 220, pajaro.y + 175);
          }  
        }
    }

    private void tituloInicio() {
        if(!animacion.isAlive()){
            noseve.setColor(Color.WHITE);
            noseve.drawString("Para jugar o para ", 235, 450);
            noseve.drawString("reiniciar pulsa ENTER", 230, 475);
            noseve.drawString("Para volar pulsa ", 235, 525);
            noseve.drawString("la barra espaciadora", 230, 550);
        }
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            pajaro.update();
            loDeLasColumnas();
            
            repaint();
           
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){
            }
        }
    }

    private void loDeLasColumnas() {
        for(Column co : columns){
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
            
            
        }
    }
    
    public void startNewGame(){
        if(!animacion.isAlive())
            animacion.start();
        else
            animacion.resume();
        if(scoreMax < score)
            scoreMax = score;
        score = 0;
        columns.clear();
        pajaro = new Bird();
        primeraColumna = new Column();
        columns.add(primeraColumna);
        this.setSize(600, 600);
        
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics(); 
        
        
    }
    public boolean mouseDown(Event ev, int x, int y){
       if(animacion.isAlive()){
           pajaro.saltar();
           return true;
       }
       return false;
         
    }
    public boolean keyDown(Event ev, int tecla){
       if(tecla == 32){//barra espaciadora
           pajaro.saltar();
           
           return true;
       }
       if(tecla == 10){
            startNewGame();
            return true;
           
       }
       
       return false;
    }
}
