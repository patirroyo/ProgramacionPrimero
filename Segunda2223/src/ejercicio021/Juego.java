/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio021;

/**
 *
 * @author alberto
 */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;



public class Juego extends Applet implements Runnable {
    static final int VELOCIDAD = 20;
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
    
    
    
    
    public void init(){
        this.setSize(TAM_X, TAM_Y);
        dino = new DinosaurioChrome();
        piedras.add(new Piedras());
        imagen = this.createImage(TAM_X, TAM_Y);
        noseve = imagen.getGraphics(); 
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        paintLandscape();
        dino.paint(noseve); 
        paintPiedras();
        paintScore();
        gameOver();
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            timer++;
            loDeLasPiedras();
            dino.update();
            repaint();
           
            try {
                Thread.sleep(VELOCIDAD);
            } catch (InterruptedException ex){
            }
        }
    }

   public boolean mouseDown(Event ev, int x, int y){
       if(dino.y == 450-dino.height){
           dino.saltar();
           return true;
       }
       return false;
         
    }
    public boolean keyDown(Event ev, int tecla){
       if(tecla == 32 && dino.y == 450-dino.height){//barra espaciadora
           dino.saltar();
           
           return true;
       }
       if(tecla == 10){
            //startNewGame();
            return true;
           
       }
       
       return false;
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
        noseve.setColor(Color.YELLOW);
        noseve.drawString("Score: " + Integer.toString(score), 20, 580);
    }
    
    private void loDeLasPiedras() {
        if(timer%100 == 0)
            piedras.add(new Piedras());
        for(Piedras pi: piedras){
            pi.update();
            if(pi.intersects(dino)){
                dino.vida--;
                piedras.clear();
                break;
            }
            if(pi.x + pi.width < 0){
                score++;
                piedras.remove(pi);
                break;
            }
            
        }
    }
    private void gameOver() {
        if(gameOver){
            noseve.setFont(new Font("Arial", Font.BOLD, 20));
            noseve.setColor(Color.WHITE);
            noseve.drawString("GAME OVER ", 220, 300);
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