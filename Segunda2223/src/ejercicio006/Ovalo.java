/*
Vamos a diseñar una ventana y en la ventana vamos a poner un botón.
Vamos a usar un objeto de la clase "Button".
Cuando hagamos click se mostrará un óvalo que se mostrará en una posición
aleatoria y con unas dimensiones aleatorias.
 */
package ejercicio006;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ovalo {
    /*Para definir un óvalo, lo definimos con altura, anchura, posición (posX y 
    posY) que marca la parte superior izquierda.
    Un óvalo está inscrito en un rectángulo, también le podemos dar otro atributo
    que será la clase color.
    */
    int anchura;
    int altura;
    int posX;
    int posY;
    Color color; //para definir la clase color tenemos que importarla de otro paquete
    Random r; //para la clase Random cogemos el paquete del cajon desastre util.
    /* El paquete tiene un método .nextInt(), que es polimorfo y nos devuelve un número 
    aleatorio, para usarlo y sabiendo que no es estático y que está en la clase util;
    no puedo llamarlo Random.nextInt()
    Tengo que llamarlo con un objeto, para ello utilizaré r, que lo instancio.
    */

    
    public Ovalo() {
        r = new Random();//instancio un objeto de la clase Random para poder acceder al método.
        inicializar(); 
    }

    public void inicializar() {
        anchura = r.nextInt(100) + 100; // un número aleaotorio entre 100 y 199
        altura = r.nextInt(100) + 100;
        posX = r.nextInt(600);
        posY = r.nextInt(400);
        color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
        //el color se define por 3 enteros entre 0 y 255 que definen rgb
    }
    /* Un método para dibujar, necesitamos un papel y un pincel
    el papel va a ser un objeto de la clase Graphics, cuando lo instancias
    podrás pintar en él, no puedes pintar en otro sitio.
    
    el pincel */
    public void paint(Graphics papel){
        papel.setColor(color);//voy a establecer el color sobre el objeto
        papel.fillOval(posX, posY, anchura, altura);
    }
}
