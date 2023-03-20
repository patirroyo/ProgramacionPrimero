
package Ejercicio02;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author alberto
 */
public class Puzzle extends Applet implements Runnable{
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;
    public static final int PIECES = 25;
    private int delay = 200;
    private Thread animacion;
    private Image imagen; 
    private Graphics noseve;
    public final static int SIZEX = 1000;
    public final static int SIZEY = 600;
    public final static int IMAGESIZE = 60;
    private Image imagenes[];
    private Pieza piezas[];
    private Pieza actual;
    private int posActual;
    private int actualIniX;
    private int actualIniY;
    private Rectangle[] sitios;
    
    
    public void init(){
        this.setSize(SIZEX, SIZEY);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        //instanciamos las 25 imágnes
       // imagenes = new Image[PIECES];
        piezas = new Pieza[PIECES];
        
        
        for(int i = 0; i < PIECES; i++){
            imagenes[i] = getImage(getCodeBase(), "Ejercicio02/directorioImagenes/" + (i+1) + ".png"); 
            piezas[i] = new Pieza(imagenes[i]);
        }
        sitios = new Rectangle[PIECES];
        
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++)
                sitios[i*ROWS + j] = new Rectangle(j*IMAGESIZE + 100, i*IMAGESIZE + 150, IMAGESIZE, IMAGESIZE);
        }
        
      
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        
        noseve.drawImage(getImage(getCodeBase(), "Ejercicio02/directorioImagenes/mapamundi3.png"), 100, 150, this);
        
        
        for(int i = 0; i < PIECES; i++){
            piezas[i].paint(noseve, this);
            noseve.setColor(Color.YELLOW);
            noseve.drawRect(sitios[i].x, sitios[i].y, sitios[i].width, sitios[i].height);
        }

        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
        
    }
    
    public void run(){
        while(true){
            repaint();
           
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(int i = 0; i < PIECES; i++){
           if(piezas[i].contains(x, y)){
               actual = piezas[i];
               posActual = i;
               actualIniX = actual.x;
               actualIniY = actual.y;
               repaint();
               return true;
           }
        }
        return false;
    }
    public boolean mouseDrag(Event ev, int x, int y){//cuando haces click y sin soltar, mueves
        if(actual != null){ 
            actual.setX(x-actual.width/2);
            actual.setY(y-actual.height/2);
            
            
            repaint();
        }
       
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){//cuando haces click y sin soltar, mueves
        if(actual.intersects(sitios[posActual])){
           actual.x = sitios[posActual].x;
           actual.y = sitios[posActual].y;
        } else{
            actual.setX(actualIniX);
            actual.setY(actualIniY);
        }
        
            
        repaint();
        
       
        return true;
    }
}