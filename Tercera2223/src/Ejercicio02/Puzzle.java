
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
public class Puzzle extends Applet{
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;
    public static final int PIECES = 25;
    private Image imagen; 
    private Graphics noseve;
    public final static int SIZEX = 1000;
    public final static int SIZEY = 600;
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
        //instanciamos las 25 imágnes y las 25 piezas que se alimentaran las imagenes
        imagenes = new Image[PIECES];
        piezas = new Pieza[PIECES];
        
        //cargamos la imágenes y se las asignamos a las piezas con el método constructor.
        for(int i = 0; i < PIECES; i++){
            imagenes[i] = getImage(getCodeBase(), "Ejercicio02/directorioImagenes/" + (i+1) + ".png"); 
            //en este ejemplo no hace falta el segundo atributo, pero así funcionan las dos clases
            piezas[i] = new Pieza(imagenes[i], i); 

        }
        
        //creamos los lugares donde tienen que ir las piezas
        sitios = new Rectangle[PIECES];
        //les damos el lugar correcto
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++)
                sitios[i*ROWS + j] = new Rectangle(j*Pieza.SIZE + 100, i*Pieza.SIZE + 150, Pieza.SIZE, Pieza.SIZE);
        }
        
      
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        //pintamos una imagen de referencia para ayudar
        noseve.drawImage(getImage(getCodeBase(), "Ejercicio02/directorioImagenes/mapamundi3.png"), 100, 150, this);
        
        //pintamos las piezas y la cuadricula donde tienen que ir.
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
    
    public boolean mouseDown(Event ev, int x, int y){
        for(int i = 0; i < PIECES; i++)
           if(piezas[i].contains(x, y)){
               actual = piezas[i];
               posActual = i;
               actualIniX = actual.x;
               actualIniY = actual.y;
               break;
           }
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){//cuando haces click y sin soltar, mueves
        if(actual != null){ 
            actual.update(x, y);
            repaint();
        }
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        if(actual != null){    
            if(actual.intersects(sitios[posActual])){
               actual.x = sitios[posActual].x;
               actual.y = sitios[posActual].y;
               actual.setOk();
            } else{
                actual.setX(actualIniX);
                actual.setY(actualIniY);
            }
            repaint();
        }
        return true;
    }
}