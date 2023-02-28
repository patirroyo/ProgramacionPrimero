/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio022;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class SaltarPlataformas extends Applet implements Runnable{
    public static final int DELAY = 20;
    public static final int TIEMPOMIN = 800;
    public static final int TIEMPOMAX = 2000;
    int espera;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    List<Platform> plataformas = new ArrayList<Platform>();
    private static int TAM_X = 600;
    private static int TAM_Y = 600;
    int timer = 0;
    static Boolean gameOver = false;
    int score;
    int scoreMax;
    Platform plataforma1;
    Mario mario;
    
    public void init(){
        this.setSize(TAM_X, TAM_Y);
        mario = new Mario();
        plataforma1 = new Platform(250, 50, 120);
        plataformas.add(plataforma1);
        imagen = this.createImage(TAM_X, TAM_Y);
        noseve = imagen.getGraphics();
        score = 0;
        scoreMax = 0;
    }
    public void start(){
        animacion = new Thread(this);
    }
    
    public void paint(Graphics g){
        paintLandscape();
        paintPlataformas();
        mario.paint(noseve);
        paintScore();
        paintLives();
        gameOver();
        tituloInicio();
        g.drawImage(imagen, 0, 0, this);
    }
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        do{timer++;
            loDeLasPlataformas();
            mario.update();
            repaint();
           
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException ex){
            }
        }while(true);
    }
    public boolean keyDown(Event ev, int tecla){
       if(!gameOver && tecla == 32 ){//barra espaciadora
           mario.saltar();   
           return true;
       }
       if(!gameOver){
            mario.update(tecla);
       }
       if(gameOver || !animacion.isAlive() && tecla == 10){
            startNewGame();
            return true;   
       }
       return false;
    }
    public void startNewGame(){
        if(scoreMax < score)
            scoreMax = score;
        score = 0;
        mario = new Mario();
        plataformas = new ArrayList<Platform>();
        plataforma1 = new Platform(250, 50, 120);
        plataformas.add(plataforma1);
        gameOver = false;
        espera = (int)(Math.random()*(TIEMPOMAX-TIEMPOMIN))+TIEMPOMIN;
        if(!animacion.isAlive())
            animacion.start();  
        else
            animacion.resume();
    }
    private void tituloInicio() {
        if(!animacion.isAlive()){
            noseve.setColor(Color.BLACK);
            noseve.setFont(new Font("Arial", Font.BOLD, 20));
            noseve.drawString("Para jugar o para ", 205, 300);
            noseve.drawString("reiniciar pulsa ENTER", 180, 325);
        }
    }
    private void paintLandscape() {
        noseve.setColor(Color.LIGHT_GRAY);
        noseve.fillRect(0, 0, TAM_X, TAM_Y-150);
        noseve.setColor(Color.DARK_GRAY);
        noseve.fillRect(0, TAM_Y-150, TAM_X, 150);
        noseve.setColor(Color.WHITE);  
    }
     private void paintPlataformas() {
        for(Platform pl: plataformas)
            pl.paint(noseve);
    }
     
    private void paintScore() {
       noseve.setFont(new Font("Arial", Font.BOLD, 14));
       noseve.setColor(Color.YELLOW);
       noseve.drawString("MAX: " + Integer.toString(scoreMax), 20, 560);
       noseve.drawString("Score: " + Integer.toString(score), 20, 580);
    }
    private void paintLives() {
        noseve.setColor(Color.RED);
        switch (mario.vida){
            case 3:
                noseve.fillOval(20, 20, 15, 15);
                noseve.fillOval(40, 20, 15, 15);
                noseve.fillOval(60, 20, 15, 15);
                break;
            case 2:
                noseve.fillOval(20, 20, 15, 15);
                noseve.fillOval(40, 20, 15, 15);
                break;
            case 1:
                noseve.fillOval(20, 20, 15, 15);
                break;
            case 0:
                break;
        }
        noseve.setColor(Color.BLACK);
        noseve.drawOval(20, 20, 15, 15);
        noseve.drawOval(40, 20, 15, 15);
        noseve.drawOval(60, 20, 15, 15);
    }
    private void loDeLasPlataformas() {
        if(timer*DELAY > espera){
            plataformas.add(new Platform());
            espera = (int)(Math.random()*(TIEMPOMAX-TIEMPOMIN))+TIEMPOMIN;
            timer = 0;
        }
        for(Platform pl: plataformas){
            pl.update();
            if(!plataformas.isEmpty() && plataformas.get(0).y > 450){
                score++;
                plataformas.remove(0);
                break;
            }
            if(mario.y <= pl.y && mario.intersects(pl))
                mario.y = pl.y - mario.height;
                
        }
        
            
        
    }
    private void gameOver() {
        if(gameOver){
            noseve.setFont(new Font("Arial", Font.BOLD, 20));
            noseve.setColor(Color.WHITE);
            noseve.drawString("GAME OVER ", 220, 300);
            noseve.drawString("Para reiniciar pulsa ENTER", 170, 325);
            animacion.suspend();
        }
    }
    
    
}
