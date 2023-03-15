/*
Vamos a trabajar con imágenes ya creadas, no las tenemos que crear nosotros.
Tenemos que coger esos archivos y meterlos en memoria, y direccionarlos, apuntarlos
desde un objeto de la clase imagen para poder referenciarlos.
 */
package Ejercicio01;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author alber
 */
public class Caminando extends Applet implements Runnable {
    public static final int ROWS = 3;
    public static final int COLUMNS = 4;
    private int delay = 200;
    private Thread animacion;
    private Image imagen; 
    private Graphics noseve;
    public final static int SIZEX = 600;
    public final static int SIZEY = 600;
    Image img;
    Image imagenes[][];
    String elementos[] = {"Guerrillero/g", "Hampon/h", "Vaquero/v"};
    DibujoAnimado personaje;//declaro un dibujo animado para mostrarlo, reservo memoria.
    
    
    
    
    public void init(){
        this.setSize(SIZEX, SIZEY);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        img = getImage(getCodeBase(), "Ejercicio01/Sprites/Guerrillero/g1.gif");
        /*este método devuelve algo, una imagen
        primero se le da el path (en ese caso usamos getCodeBase() para
        obtener el path), lo mete en una dirección de memoria ram y con el
        getImage accedemos a él.
        */
        imagenes = new Image[ROWS][COLUMNS];
        
        //Cargamos las imágenes en el array bidimensional.
        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLUMNS; j++)
                imagenes[i][j] = getImage(getCodeBase(), "Ejercicio01/Sprites/" + elementos[i] + (j+1) + ".gif");   
        //instancio el personaje.
        personaje = new DibujoAnimado(imagenes[0]);
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.BLACK);
       noseve.fillRect(0, 0, SIZEX, SIZEY);
       
       personaje.paint(noseve, this);
      
       g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
        
    }
    
    public void run(){
        while(true){
            personaje.update();
            repaint();
           
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
    }
    public boolean keyDown(Event ev, int tecla){
        final int KeyEvent_g = 103;
        final int KeyEvent_h = 104;
        final int KeyEvent_v = 118;
        boolean isKeyDown = false;
        switch (tecla){
            case KeyEvent.VK_G: case KeyEvent_g:
                personaje.setImagenes(imagenes[0]);  
                isKeyDown = true;
                break;
            case KeyEvent.VK_H: case KeyEvent_h:
                personaje.setImagenes(imagenes[1]);  
                isKeyDown = true;
                break;
            case KeyEvent.VK_V: case KeyEvent_v:
                personaje.setImagenes(imagenes[2]);
                isKeyDown = true;
                break;
        }
        return isKeyDown;
    }
}