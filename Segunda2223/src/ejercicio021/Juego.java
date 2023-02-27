/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio021;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;



public class Juego extends Applet implements Runnable {
    public static final int DELAY = 20;
    public static final int TIEMPOMIN = 800;
    public static final int TIEMPOMAX = 2000;
    public static final int POS_INI_X = 600;
    int espera;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    DinosaurioChrome dino;
    List<Piedras> piedras = new ArrayList<Piedras>();
    private static int TAM_X = 600;
    private static int TAM_Y = 600;
    int timer = 0;
    static Boolean gameOver = false;
    int score;
    int scoreMax;
    Piedras piedra1;
    
    
    
    
    public void init(){
        this.setSize(TAM_X, TAM_Y);
        dino = new DinosaurioChrome();
        piedras.add(new Piedras());
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
        dino.paint(noseve); 
        paintPiedras();
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
        do{
/*con el do, nos aseguramos que por lo menos una vez se ejecute
*mientras que con el while, siempre va a preguntar, en estos
casos no vamos a notar diferencia, pero puede que sea útil en otras ocasiones*/
            timer++;
            loDeLasPiedras();
            dino.update();
            repaint();
           
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException ex){
            }
        }while(true);
    }

   public boolean mouseDown(Event ev, int x, int y){
       if(!gameOver && dino.y == 450-dino.height){
           dino.saltar();
           return true;
       }
       return false;
         
    }
    public boolean keyDown(Event ev, int tecla){
       if(!gameOver && tecla == 32 && dino.y == 450-dino.height){//barra espaciadora
           dino.saltar();   
           return true;
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
        dino = new DinosaurioChrome();
        piedras = new ArrayList<Piedras>();
        piedra1 = new Piedras();
        piedras.add(piedra1);
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

    private void paintPiedras() {
        for(Piedras pi: piedras)
            pi.paint(noseve);
    }

    private void paintScore() {
        noseve.setFont(new Font("Arial", Font.BOLD, 14));
        noseve.setColor(Color.YELLOW);
        noseve.drawString("MAX: " + Integer.toString(scoreMax), 20, 560);
        noseve.drawString("Score: " + Integer.toString(score), 20, 580);
    }
    
    private void paintLives() {
        noseve.setColor(Color.RED);
        switch (dino.vida){
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
    
    private void loDeLasPiedras() {
        if(timer*DELAY > espera){
            piedras.add(new Piedras());
            espera = (int)(Math.random()*(TIEMPOMAX-TIEMPOMIN))+TIEMPOMIN;
            timer = 0;
        }
        for(Piedras pi: piedras)
            pi.update();
        if(piedras.get(0).intersects(dino)){
            dino.vida--;
            piedras.clear();
            piedra1 = new Piedras();
            piedras.add(piedra1);
        }
        if(piedras.get(0).x + piedras.get(0).width < 0){
                score++;
                piedras.remove(0);
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

    public static int getTAM_X() {
        return TAM_X;
    }

    public static int getTAM_Y() {
        return TAM_Y;
    }

   
    
}