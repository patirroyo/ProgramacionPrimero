/*
Vamos a jugar al arkanoid

Necesitaremos pelota, ladrillos y raqueta.
También un thread para la velocidad de la pelota.
Clases: -pelota: similar a la anterior: x, y, dam, velocidad en X y en Y
                y nos interesará saber si intersecta --> extends Rectangle
        -ladrillo: posX, posY, anchura y altura + metodo intersección
                    --> Extends rectangle.
                    Cada fila será de un color, por lo tanto un atributo: color
        -raqueta: también un rectángulo, sin atributo color
 */
package ejercicio015;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class Arkanoid extends Applet implements Runnable {
    int velocidad;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    Pelota pelota;
    List<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
    Color [] colores = {Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.LIGHT_GRAY};
    Raqueta raqueta;
    int score;
    final int IZQUIERDA = -1;
    final int DERECHA = 1;
    List<Bonus> bonus = new ArrayList<Bonus>();
    
    public void init(){
        pelota = new Pelota(Color.WHITE);
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 10; j++)
                ladrillos.add(new Ladrillo(j*(Ladrillo.ANCHURA+4)+1, i*30+1, colores[i]));
        raqueta = new Raqueta();
        
        this.setSize(600, 600);
       
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
       pelota.paint(noseve);
       if(!animacion.isAlive()){
            noseve.setColor(Color.WHITE);
            noseve.drawString("Para jugar pulsa", 235, 450);
            noseve.drawString("la barra espaciadora", 230, 475);
       }
       for(Ladrillo ld : ladrillos)
           ld.paint(noseve);
       
       raqueta.paint(noseve);
       
       if(!bonus.isEmpty())
           for(Bonus bon : bonus)
               bon.paint(noseve);

       if(pelota.y >= 600){
                noseve.setColor(Color.WHITE);
                noseve.drawString("GAME OVER", 260, 300);
                noseve.drawString("SCORE: " + String.valueOf(score), 270, 340);
                noseve.drawString("Para volver a jugar pulsa", 215, 450);
                noseve.drawString("la barra espaciadora", 230, 475);
                animacion.interrupt();
       }
       if(ladrillos.isEmpty()){
                noseve.setColor(Color.WHITE);
                noseve.drawString("YOU WIN", 260, 300);
                noseve.drawString("SCORE: " + String.valueOf(score), 260, 340);
                pelota.x = 280;
                pelota.y = 250;
                animacion.interrupt();
       }
        if(animacion.isAlive()){
       
       noseve.setColor(Color.WHITE);
       noseve.drawString("Score: " + String.valueOf(score), 10, 575);
       }
        
       g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            siPelotaTocaRaqueta();
            siPelotaTocaLadrillo();
            pelota.actualizar();
            if(!bonus.isEmpty())
                 loteriaBonus();
            
            //hacerTrampa();//para hacer pruebas
            
            repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){           
            }
        }
    }

    private void hacerTrampa() {
        raqueta.x = pelota.x + pelota.width/2 - raqueta.width/2;
    }

    private void loteriaBonus() {
        for(Bonus bon : bonus){
            bon.update();
            if(raqueta.intersects(bon)){
                raqueta.width +=10;
                raqueta.color = bon.color;
                score++;
                bonus.remove(bon);
                break;
            }
        }
    }

    private void siPelotaTocaRaqueta() {
        if(pelota.intersects(raqueta)){
            if(raqueta.y - pelota.y >= pelota.height/2)
                pelota.velY *= -1;
            if(pelota.velX > 0 && pelota.x - raqueta.x < 0)
                pelota.velX *= -1;
            if(pelota.velX < 0 && pelota.x - raqueta.x > raqueta.width-pelota.width)
                pelota.velX *= -1;
            pelota.color = raqueta.color;
        }
    }

    private void siPelotaTocaLadrillo() {
        for(Ladrillo ld : ladrillos)
            if(pelota.intersects(ld)){
                score++;
                pelota.velY *= -1;
                pelota.color = ld.color;
                ld.vida -= 1;
                if(ld.vida == 0){
                    ladrillos.remove(ld);
                    bonusAleatorio(ld.color);
                    switch(ladrillos.size()){
                        case 40:
                            velocidad = 12;
                            raqueta.width -=10;
                            raqueta.color = Color.WHITE;
                            break;
                        case 30:
                            velocidad = 10;
                            raqueta.width -=10;
                            raqueta.color = Color.WHITE;
                            break;
                        case 20:
                            velocidad = 8;
                            raqueta.width -=10;
                            raqueta.color = Color.WHITE;
                            break;
                        case 15:
                            velocidad = 6;
                            raqueta.width -=10;
                            raqueta.color = Color.WHITE;
                            break;
                        case 10:
                            velocidad = 4;
                            break;
                        case 5:
                            velocidad = 3;
                            raqueta.width -=10;
                            raqueta.color = Color.WHITE;
                    }
                }else
                    ld.color = Color.WHITE;
                break;//para evitar que la pelota se quede en el ladrillo que acaba de destruir
            }
    }

    private void bonusAleatorio(Color color) {
        if((int)(Math.random()*10) == 0)
            bonus.add(new Bonus(pelota.x + pelota.width/2, pelota.y, color));
    }
    public void startNewGame(){
        if(!animacion.isAlive())
            animacion.start();
        ladrillos.clear();
        velocidad = 15;
        score = 0;
        pelota = new Pelota(Color.WHITE);
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 10; j++)
                if(i == 0){
                    ladrillos.add(new Ladrillo(j*60, i*30, colores[i], 2));
                }else if (i <5){
                    ladrillos.add(new Ladrillo(j*60, i*30, colores[i]));
                }else
                    ladrillos.add(new Ladrillo(j*60, i*30, colores[4]));
        
        raqueta = new Raqueta();
        this.setSize(600, 600);
       
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics();  
    }
    public boolean keyDown(Event ev, int tecla){
       //método para mover la raqueta con las teclas 1006 izda y 1007 dcha
       if(ev.key == 1006 && raqueta.x > 0){
           raqueta.update(IZQUIERDA);
           return true;
       }
       if(ev.key == 1007 && raqueta.x < 600 - raqueta.width){
           raqueta.update(DERECHA);
           return true;
       }
       if(ev.key == 32){//barra espaciadora
           //if(animacion.isInterrupted())
           startNewGame();
           return true;
       }
       if(ev.key == 84){//T de trampa
           hacerTrampa();
           return true;
       }
           
        return false;
    }
    public boolean mouseMove(Event ev, int x, int y){
        raqueta.x = x - raqueta.width/2;
        
        return true;
    }

    
}
    

