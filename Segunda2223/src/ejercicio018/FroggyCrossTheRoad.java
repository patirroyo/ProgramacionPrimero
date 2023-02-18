/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio018;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class FroggyCrossTheRoad extends Applet implements Runnable{
    int velocidad = 10;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    Rana rana;
    boolean gameOver = false;
    boolean win = false;
    boolean jugando;
    List<Coche> coches = new ArrayList<Coche>();
    int cantidadCoches = 100;
    int score;
    int scoreMax;
    
    
    public void init(){
        score = 0;
        scoreMax = 0;
        this.setSize(600, 600);
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics(); 
        rana = new Rana();
    }
    public void start(){
        animacion = new Thread(this);
    }
    
     public void paint(Graphics g){
       paintBoard();
       rana.paint(noseve);
       pintarCoches();
       paintScore();
       paintGameOver();
       paintWin();
       tituloInicio();
       g.drawImage(imagen, 0, 0, this);
    }

     public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    public void run(){
        while(true){
            rana.update();
            if(rana.y < 0 - rana.height){
                rana.y = 590;
                score++;
                cantidadCoches--;
            }
            if(cantidadCoches == 10)
                win();
                
            loDeLosCoches();
            repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){
            }
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
            }
       }
        if(tecla == 10){//intro
            startNewGame();
            return true;
            }
        return false;
    }
    public void startNewGame(){
        if(scoreMax < score)
            scoreMax = score;
        score = 0;
        cantidadCoches = 100;
        rana = new Rana();
        coches = new ArrayList<Coche>();
        iniciarCoches();
        this.setSize(600, 600);
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics();
        paintBoard();
        
        gameOver = false;
        win = false;
        if(!animacion.isAlive())
            animacion.start();  
        else
            animacion.resume();
    }
    private void tituloInicio() {
        if(!animacion.isAlive()){
            noseve.setColor(Color.GREEN);
            noseve.setFont(new Font("Arial", Font.BOLD, 20));
            noseve.drawString("Para jugar o para ", 205, 250);
            noseve.drawString("reiniciar pulsa ENTER", 200, 275);
        }
    }

    private void iniciarCoches() {
        for(int i = 0; i < 6; i++)
            coches.add(new Coche(i));
    }
    
    private void pintarCoches() {
        if(!coches.isEmpty())
            for(Coche co: coches)
                co.paint(noseve);
    }
    private void loDeLosCoches() {
        if((int)(Math.random() * cantidadCoches) == 1)
            coches.add(new Coche((int)(Math.random()*6)));
        if(!coches.isEmpty()){
            for(Coche co : coches){
                co.update();
                if(co.intersects(rana)){
                    rana.vida--;
                    gameOver();
                }
                if(co.x <= -200 || co.x >=800){
                    coches.remove(co);
                    break;
                }
                co.cocheChocon(coches);
            }
        }
    }
    private void paintBoard() {
        noseve.setColor(Color.CYAN);
        noseve.fillRect(0, 0, 600, 600);
        noseve.setColor(Color.LIGHT_GRAY);
        noseve.fillRect(0, 75, 600, 200);
        noseve.fillRect(0, 350, 600, 180);
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 75, 600, 15);
        noseve.fillRect(0, 260, 600, 15);
        noseve.fillRect(0, 340, 600, 15);
        noseve.fillRect(0, 520, 600, 15);
        for(int i = 0; i < 10; i++){
            noseve.fillRect((i*60)+5, 135, 50, 15);
            noseve.fillRect((i*60)+5, 200, 50, 15);
            noseve.fillRect((i*60)+5, 400, 50, 15);
            noseve.fillRect((i*60)+5, 465, 50, 15);
        }
        noseve.setColor(Color.BLACK);
        noseve.drawRect(0, 75, 600, 15);
        noseve.drawRect(0, 260, 600, 15);
        noseve.drawRect(0, 340, 600, 15);
        noseve.drawRect(0, 520, 600, 15);
    }
   private void paintScore() {
        noseve.setColor(Color.BLACK);
        noseve.drawString("SCORE: " + Integer.toString(score), 20, 580);
        noseve.drawString("MAX: " + Integer.toString(scoreMax), 20, 560);
    }
    private void gameOver() {
          gameOver = true;
          repaint();
         
    }
    private void paintGameOver() {
        if(gameOver){
            noseve.setColor(Color.BLACK);
            noseve.drawString("GAME OVER ", 250, 275);
            noseve.drawString("Para reiniciar pulsa ENTER", 225, 305);
        }
    }
    private void win() {
        win = true;
        repaint();
        animacion.suspend();
    }
    private void paintWin() {
        if(win){
            noseve.setColor(Color.BLACK);
            noseve.drawString("HAS GANADO ", 250, 275);
            noseve.drawString("Para reiniciar pulsa ENTER", 225, 305);
        }
    }
}
