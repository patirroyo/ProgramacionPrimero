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
    public static final int FILAS = 3;
    public static final int COLUMNAS = 4;
    int delay = 200;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    public static int tamX = 600;
    public static int tamY = 600;
    Image img;
    Image imagenes[][];
    String elementos[] = {"Guerrillero/g", "Hampon/h", "Vaquero/v"};
    DibujoAnimado personaje;//declaro un dibujo animado para mostrarlo, reservo memoria.
    
    
    
    
    public void init(){
        this.setSize(tamX, tamY);
       
        imagen = this.createImage(tamX, tamY);
        noseve = imagen.getGraphics(); 
        
        img = getImage(getCodeBase(), "Ejercicio01/Sprites/Guerrillero/g1.gif");
        /*este método devuelve algo, una imagen
        primero se le da el path (en ese caso usamos getCodeBase() para
        obtener el path), lo mete en una dirección de memoria ram y con el
        getImage accedemos a él.
        */
        imagenes = new Image[FILAS][COLUMNAS];
        
        //Cargamos las imágenes en el array bidimensional.
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 4; j++)
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
       noseve.fillRect(0, 0, tamX, tamY);
       
       personaje.paint(noseve, this);
      
       g.drawImage(imagen, 0, 0, tamX, tamY, this);//200 anchura y 300 altura
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
            }
        }
    }
    public boolean keyDown(Event ev, int tecla){
        switch (tecla){
            case KeyEvent.VK_G: case 103: //G 71
                personaje.setImagenes(imagenes[0]);  
                return true;

            case KeyEvent.VK_H: case 104://H 72
                personaje.setImagenes(imagenes[1]);  
                 return true;

            case KeyEvent.VK_V: case 118:// 86 v
                personaje.setImagenes(imagenes[2]);
                return true;
        }
        return false;
    }
}