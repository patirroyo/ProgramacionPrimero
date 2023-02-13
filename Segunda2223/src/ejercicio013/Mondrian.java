/*
vamos a pintar un cuadro de Mondrian y luego le vamos a dar movimiento.
 */
package ejercicio013;

import java.applet.Applet; 
import java.awt.Color;

/* es como una ventana que se puede meter dentro de una página web
Tiene un ciclo de vida: un método va detrás de otro. Consta de varios
métodos que se van a ejecutar sin que nadie los llame.
primero se ejecuta el método init y luego el start
init: se dan valores iniciales a los atributos
start: se suele instanciar el objeto de la clase thread
paint:

*/
import java.awt.Graphics;
import java.awt.Image;


public class Mondrian extends Applet implements Runnable{
    int posX = 80;
    int posY = 100;
    int velocidad = 0;
    Thread animacion;
    public static final int DERECHA = 0; //ATRIBUTOS DE CLASE PARA INDICAR LOS MOVIMIENTOS
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int ARRIBA = 3;
    int direccion;
    Image imagen; //declaro un objeto de la clase Image y otro de la clase Graphics
    Graphics noseve;
    /*Dentro de un objeto de la clase Image hay otro de la clase Graphics,
    Hay dos tipos de imagenes: un archivo y las que construyes tu
    lo que hacemos es dibujar en el graphics noseve
    y cuando lo tenemos dibujado, pintamos encima el objeto imagen
    no se llega a borrar lo que hay por lo que no parpadeará
    */
    
    
    public void init(){
        this.setSize(320, 350);
        direccion = DERECHA;
        imagen = this.createImage(320, 350); //no llamo al constructor, llamo a un método que llamará a un método constructor.
        noseve = imagen.getGraphics(); //obtenemos el objeto graphics del objeto imagen y lo guardamos en noseve
        
    }
    public void start(){
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        animacion.start();//es el que llama a ejecutar el método run
        
    }
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 350, 350);
        noseve.setColor(Color.YELLOW);
        noseve.fillRect(0, 0, 90, 90);
        noseve.fillRect(250, 0, 40, 190);
        noseve.fillRect(80, 160, 100, 120);
        noseve.setColor(Color.BLUE);
        noseve.fillRect(80, 220, 220, 90);
        noseve.fillRect(100, 10, 90, 80);
        noseve.setColor(Color.LIGHT_GRAY);
        noseve.fillRect(posX, posY, 110, 90);//queremos que se mueva, tenemos que darle variables
        noseve.setColor(Color.RED);
        noseve.fillRect(200,0,45,45);
        noseve.fillRect(0, 110, 70, 200);
        noseve.setColor(Color.MAGENTA);
        noseve.fillRect(200, 55, 60, 135);
        g.drawImage(imagen, 0, 0, this);//dibujamos la imagen en el objeto graphics del applet
    }
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        //aquí iria la linea que borra todo
        paint(g);
        /*el rectángulo negro grande es el que elimina lo anterior, porque lo que hace es tapar
        lo anterior con negro
        */
    }
    public void run(){
        while(true){//bucle infinito--infinite loop
            switch (direccion){
                case DERECHA: 
                    posX++;
                    if (posX == 100)
                        direccion = ABAJO;
                    break;
                case ABAJO:
                    posY++;
                    if (posY == 120)
                        direccion = IZQUIERDA;
                    break;
                case IZQUIERDA:
                    posX--;
                    if (posX == 80)
                        direccion = ARRIBA;
                    
                    break;
                case ARRIBA:
                    posY--;
                    if (posY == 100)
                        direccion = DERECHA;
            }
            repaint();
           
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex){
            }
        }
    }
    
}
