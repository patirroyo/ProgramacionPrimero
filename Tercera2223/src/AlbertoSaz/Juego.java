/*
 Tenéis que hacer el juego que mostramos en pantalla.  
Se puede cambiar de coche haciendo click en alguno de los coches de arriba.  
Se acelerará o se frenará pulsando los pedales, el de la derecha acelera, el de la izquierda frena.  
El coche no se mueve, es la imagen de fondo la que se desplaza hacia la izquierda.  
Se desplazará más rápido dependiendo de la velocidad, que también aparece en pantalla, 
la velocidad se modifica pulsando los pedales.
Se puntuará:

Análisis de las clases, sus atributos y métodos
5 puntos.


Clase principal, el Applet, atributos, instanciación, eventos, métodos… 
5 puntos
 */
package AlbertoSaz;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;


public class Juego extends Applet implements Runnable{
    
    public final static int SIZEX = 800;
    public final static int SIZEY = 600;
    private Image imagen; 
    private Graphics noseve;
    private Thread animacion;
    private int delay = 50;
    private Image[] imagenes;
    private Garaje[] coches;
    private static final int COCHESGARAJE = 4;
    private Fondo fondo;
    private Image imagenFondo;
    private Image imagenAcelerador;
    private Image imagenFreno;
    private Coche coche;
    private Pedal acelerador;
    private Pedal freno;

    
    public void init(){
        this.setSize(SIZEX, SIZEY);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        

        imagenes = new Image[COCHESGARAJE];
        for(int i = 0; i < imagenes.length; i++)
            imagenes[i] = getImage(getCodeBase(), "AlbertoSaz/Fotos/coche" + (i+1) + ".png");
        
        coches = new Garaje[COCHESGARAJE];
        for(int i = 0; i < COCHESGARAJE; i++)
                coches[i] = new Garaje( i*(Garaje.WIDTH+50)+80, imagenes[i]);
        
        imagenFondo = getImage(getCodeBase(), "AlbertoSaz/Fotos/tira.jpg");
        imagenAcelerador = getImage(getCodeBase(), "AlbertoSaz/Fotos/acelerador.png");
        imagenFreno = getImage(getCodeBase(), "AlbertoSaz/Fotos/freno.png");
        
        fondo = new Fondo(SIZEX, SIZEY, imagenFondo);
        coche = new Coche(imagenes[0]);
        acelerador = new Pedal(700, 400, 40, 120, imagenAcelerador );
        freno = new Pedal(640, 480, 40, 40, imagenFreno);

    }

    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        fondo.paint(noseve, this);
        
        for(int i = 0; i < COCHESGARAJE; i++)
            coches[i].paint(noseve, this);   
        
        coche.paint(noseve, this);
        acelerador.paint(noseve, this);
        freno.paint(noseve, this);
        
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 56));
        noseve.drawString("" + fondo.getVelX() + " Km/h", 60, 150);
        
       g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
        
    }
    
    public void run(){
        while(true){
            fondo.update();
            repaint();
            
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(int i = 0; i < COCHESGARAJE; i++)
            if(coches[i].contains(x,y))
                coche.setImagen(coches[i].getImagen());
        if(acelerador.contains(x,y))
            fondo.setVelX(fondo.getVelX()+2);
        if(freno.contains(x,y))
            fondo.setVelX(fondo.getVelX()-2);
        return false;
    } 

    
}