
package Ejercicio04;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablero extends Applet implements Runnable {
    private int delay = 1000;
    private Thread animacion;
    private Image imagen; 
    private Graphics noseve;
    public final static int SIZEX = 500;
    public final static int SIZEY = 500;
    private static final int CENTRADOX = 125;
    private static final int CENTRADOY = 100;
    private int seconds = 0;
    private int minutes = 0;
    private int NUMBOTONES = 25;
    private Image imagenes[];
    private Lugar[][] lugares;
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;
    private Button boton;
    private Lugar actual;
    private AudioClip error, acierto, exito;
    private Point hueco;
    private boolean win = false;
    
    
    public void init(){
        this.setSize(SIZEX, SIZEY);
        this.setLayout(new BorderLayout());
        this.add("South", new Button("Empezar a jugar"));
        
        imagenes = new Image[NUMBOTONES];
        
        for(int i = 0; i < NUMBOTONES-1; i++)
            imagenes[i] = getImage(getCodeBase(), "Ejercicio04/botones/" + (i+1) + ".gif"); 
        
        lugares = new Lugar[ROWS][COLUMNS];
        //les damos el lugar correcto
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++)
                if(i*ROWS + j < NUMBOTONES)//el último lugar no tiene imagen = null.
                    lugares[i][j] = new Lugar(j*Lugar.SIZE + CENTRADOX, i*Lugar.SIZE + CENTRADOY, imagenes[i*ROWS + j], (i*ROWS + j) +1);   
        }
        try {
            error = getAudioClip(new URL(getCodeBase(), "Ejercicio04/sonidos/error.wav"));
            acierto = getAudioClip(new URL(getCodeBase(), "Ejercicio04/sonidos/correct.wav"));
            exito = getAudioClip(new URL(getCodeBase(), "Ejercicio04/sonidos/exito.wav"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        //indicamos en qué posicion está el hueco (4,4)
        hueco = new Point(ROWS-1, COLUMNS-1);
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        
    }

    
    public void start(){
        animacion = new Thread(this);

        
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.LIGHT_GRAY);
       noseve.fillRect(0, 0, SIZEX, SIZEY);
       noseve.setColor(Color.BLACK);
     
       for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++)
                lugares[i][j].paint(noseve, this);
       }
       
       paintTime();
       if(win & animacion.isAlive())
           paintWin();
      
       g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }

    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);  
    }
    
    public void run(){
        while(true){
            if(!win)
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
       
        Point click;
        //Restamos el "centrado" y luego dividimos entre Lugar.Size de esta forma
        //obtenemos la poisición 
        click = new Point((y-CENTRADOY)/Lugar.SIZE, (x-CENTRADOX)/Lugar.SIZE);
        if(!mover(click))
            error.play();
        else{
            acierto.play();
            win = true;
            for(int i = 0; i <ROWS; i++)
                for(int j = 0; j<COLUMNS; j++)
                    if(lugares[i][j].getValor() != (i*ROWS + j) +1)
                        win = false;
            if(win)
                exito.play();
        }
        return true;
    }
    
    public boolean action(Event ev, Object obj){
         if(ev.target instanceof Button){
            if(!animacion.isAlive())
                    animacion.start();
            seconds = minutes = 0;
            for(int i = 0; i < 200; i++)
                mover(new Point((int)((Math.random()* COLUMNS)), (int)((Math.random()* ROWS))));
            return true;
         }
         return false;
    }
    
    public boolean mover(Point click){
        //nos indica si la pieza se puede mover o no
        Point desplazamiento, hasta;
        /*desplazamiento es el movimento, posiciones en horizontal y/o en vertical
        que se tiene que mover.
        hasta es el lugar hasta el que se moverá, pero si está ocupado tendremos que
        usar recursividad para hacerle hueco.
        */
        desplazamiento = new Point(delta(click.x, hueco.x), delta(click.y, hueco.y));
        //si un número es 0 y el otro no return true, si no false.
        if((desplazamiento.x == 0) && (desplazamiento.y == 0))  
            return false;
        if((desplazamiento.x != 0) && (desplazamiento.y != 0))  
            return false;
        
        //hasta donde se tiene que mover (click, + desplazamiento)
        hasta = new Point(click.x + desplazamiento.x, click.y + desplazamiento.y);
        //pregunta en negativo un poco fea pero funcional, si no puedo mover...
        if(!(hasta.x == hueco.x && hasta.y == hueco.y))
            mover(hasta);
        lugares[hueco.x][hueco.y].setImagen(lugares[click.x][click.y].getImagen());
        lugares[hueco.x][hueco.y].setValor(lugares[click.x][click.y].getValor());
        lugares[click.x][click.y].setValor((hueco.y * ROWS) + hueco.x +1);
        lugares[click.x][click.y].setImagen(null);
        lugares[click.x][click.y].setValor((click.x+1) * (click.y+1));
        hueco.x -= desplazamiento.x;
        hueco.y -= desplazamiento.y;
        /*
        hueco.x -= click.x;
        hueco.y -= click.y;
        
        O 
  
        hueco = click;
        */
        repaint();
        
        
            
            
        return true;
    }
    public int delta(int a, int b){ 
    //esta función devuelve 0, -1 o 1
        if(a == b)
            return 0;
        else
            return((b - a)/Math.abs(b - a));
    }
    private void paintTime() {
        noseve.setColor(Color.BLACK);
        if(seconds < 10)
            noseve.drawString("Time:    " + minutes + " : 0"+ seconds, 400, 15);
        else
            noseve.drawString("Time:    " + minutes + " : "+ seconds, 400, 15);
    }
    private void paintWin() {
        noseve.setColor(Color.BLACK);
        noseve.drawString("HAS GANADO!", 200, 400);
    }
}
