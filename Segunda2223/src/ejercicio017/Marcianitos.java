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
    List<Bomba> bombas = new ArrayList<Bomba>();
    int cronometro = 0;
    int score;
    int scoreMax;
    int contadorFilaNaves = 1;
    Bala cargador = new Bala(550, 570);
    int cartuchos = 10;
    boolean gameOver = false;
    boolean win = false;
    
    public void init(){
        score = 0;
        scoreMax = 0;
        this.setSize(600, 600);
        arma = new Gun();
        iniciarNaves();
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics(); 
    }
    public void start(){
        animacion = new Thread(this);
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.BLACK);
       noseve.fillRect(0, 0, 600, 600);
       noseve.setColor(Color.WHITE);
       noseve.drawLine(0, (int)(arma.arma.getY() + arma.arma.height),
               600, (int)(arma.arma.getY() + arma.arma.height));
       tituloInicio();
       arma.paint(noseve);
       paintNaves();
       paintBalas();
       paintBombas();
       paintScore();
       paintGameOver();
       paintWin();
       g.drawImage(imagen, 0, 0, this);
    }

    public void startNewGame(){
        if(scoreMax < score)
            scoreMax = score;
        score = 0;
        arma = new Gun();
        naves = new ArrayList<Nave>();
        bombas = new ArrayList<Bomba>();
        balas.clear();
        iniciarNaves();
        this.setSize(600, 600);
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics();
        gameOver = false;
        win = false;
        if(!animacion.isAlive())
            animacion.start();
        else
            animacion.resume();
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
    private void paintNaves() {
        for(Nave na: naves)
            na.paint(noseve);
    }
    
    private void paintBombas() {
        if(!bombas.isEmpty())
            for(Bomba bo: bombas)
                bo.paint(noseve);
    }

    private void paintBalas() {
        for(Bala ba : balas)
            ba.paint(noseve);
        cargador.paint(noseve);
        noseve.setColor(Color.WHITE);
        noseve.drawString(Integer.toString(cartuchos-balas.size()), 560, 575);
    }

    private void paintScore() {
        noseve.setColor(Color.WHITE);
        noseve.drawString("SCORE: " + Integer.toString(score), 20, 580);
        noseve.drawString("MAX: " + Integer.toString(scoreMax), 20, 560);
    }

    private void gameOver() {
          gameOver = true;
          repaint();
          animacion.suspend();
    }
    
    private void win() {
          win = true;
          repaint();
          animacion.suspend();
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
            loDeLasBombas();
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
                    ba.color = Color.BLACK;
                    ba.setY(0);
                    score++;
                }
                if(na.getVida()< 0){
                    naves.remove(na);
                    if(naves.isEmpty())
                        win();
                    break;
                }
            }  
        }
    }
    
    public void loDeLasBombas() {
        for(Bomba bo : bombas){
            bo.update();
            if(bo.y >= arma.arma.y + arma.arma.height){
                bombas.remove(bo);
                break;
            } 
            if(bo.intersects(arma.arma)||bo.intersects(arma.canon)){
                gameOver();
                break;
            }
        }
    }  
        
    public void loDeLasNaves(){
       if(naves.isEmpty()){
            win();
       }else if(cronometro%1200 == 0){
          for(int j = 0; j < 5; j ++){
                if(contadorFilaNaves%2==0)
                    naves.add(new Nave(2*j, 0));
                else
                    naves.add(new Nave(2*j +1, 0)); 
            }
          contadorFilaNaves++;
        }
        for(Nave na: naves){
            na.update();
            if((int)(Math.random()*10000) == 2){
                bombas.add(new Bomba(na.x+na.width/2,na.y+na.height));
            }
       
            if(arma.canon.intersects(na)|| na.intersects(arma.canon)||
               na.getY() >= arma.arma.getY())
                gameOver();   
        }
    }

    private void iniciarNaves() {
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j ++){
                if(i%2==0)
                    naves.add(new Nave(2*j, i));
                else
                    naves.add(new Nave(2*j +1 ,i));
            }
    }
    public boolean mouseDown(Event ev, int x, int y){
       if(animacion.isAlive()&& balas.size()<cartuchos){
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
            if(animacion.isAlive()&& balas.size()<cartuchos){
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

