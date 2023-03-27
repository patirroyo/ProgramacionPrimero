
package Ejercicio04;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Tablero extends Applet implements Runnable {
    private int delay = 1000;
    private Thread animacion;
    private Image imagen; 
    private Graphics noseve;
    public final static int SIZEX = 500;
    public final static int SIZEY = 500;
    private int seconds = 0;
    private int minutes = 0;
    private int TOTALNUMEROS = 25;
    private Image imagenes[];
    private Sitio[] sitios;
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;
    private Button boton;
    
    
    public void init(){
        this.setSize(SIZEX, SIZEY);
        
        imagenes = new Image[TOTALNUMEROS-1];
        
        for(int i = 0; i < TOTALNUMEROS-1; i++)
            imagenes[i] = getImage(getCodeBase(), "Ejercicio04/botones/" + (i+1) + ".gif"); 
        
        sitios = new Sitio[TOTALNUMEROS];
        //les damos el lugar correcto
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++)
                if(i*ROWS + j < TOTALNUMEROS-1)
                    sitios[i*ROWS + j] = new Sitio(j*Sitio.SIZE + 125, i*Sitio.SIZE + 100, imagenes[i*ROWS + j]);
                else
                    sitios[i*ROWS + j] = new Sitio(j*Sitio.SIZE + 125, i*Sitio.SIZE + 100, null);
        }
        
        boton = new Button("Empezar a jugar");
        this.add(boton);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        
    }
    public void start(){
        animacion = new Thread(this);
        //animacion.start();
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.LIGHT_GRAY);
       noseve.fillRect(0, 0, SIZEX, SIZEY);
       noseve.setColor(Color.BLACK);
     
       for(int i = 0; i < TOTALNUMEROS-1; i++){
            sitios[i].paint(noseve, this);
       }
       
       paintTime();
      
       g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }

    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);  
    }
    
    public void run(){
        while(true){
            seconds++;
            if(seconds >= 60){
                minutes++;
                seconds = 0;
            }
            repaint();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
    }

    public boolean mouseDown(Event ev, int x, int y){
        
        return true;
    }
    
    private void paintTime() {
        noseve.setColor(Color.BLACK);
        if(seconds < 10)
            noseve.drawString("Time:    " + minutes + " : 0"+ seconds, 400, SIZEY - 5);
        else
            noseve.drawString("Time:    " + minutes + " : "+ seconds, 400, SIZEY - 5);
        
        
    }
}
