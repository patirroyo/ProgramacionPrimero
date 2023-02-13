/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio012;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.util.logging.Level;
import java.util.logging.Logger;


/*Un thread es un programa que ha tomado la CPU, un proceso, un hilo
Es un objeto que ha tomado la CPU que se está ejecuntando y que se puede
manipular: dormir, parar, reanudar
El thread 
Un interface es una especie de clase
lo que hace es declarar atributos y métodos, que luego estás obligado a
implementar.
El interface Runnable dentro tiene el encabezado de un método, solo, no 
tiene la implementación.

    interface Runnable{
        public abstract void run();
    }
*/


public class Animacion1 extends Frame implements Runnable{//tenemos la obligación de implementar los métodos del interface Runnable, en este caso el run();
    Thread animacion;
    String frames[][] = {{"*","**","***","****","*****","******","*****","****","***","**"},
                         {"-","--","---","----","-----","------","-----","----","---","--"},
                         {"*","--","***","----","*****","------","*****","----","***","--"},
                         {"3==mD","3=m=D","3m==D","3=m=D"}};
    int actual = 0;//es una especie de puntero para que se vaya viendo la animación.
    int dibujo = 0;
    int velocidad = 500;
    
    public static void main(String arg[]) {
        Animacion1 app = new Animacion1();
        
    } 
    public Animacion1(){
        super("Animación Sencilla");
        pack();
        this.setSize(400,400);
        this.setVisible(true);
        setupMenuBar();
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        animacion.start();//es el que llama a ejecutar el método run
    }
    
    public void setupMenuBar(){
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Archivo");
        menu1.add(new MenuItem("Salir"));
        menuBar.add(menu1);
        Menu menu2 = new Menu("Animación");
        menu2.add(new MenuItem(" * "));
        menu2.add(new MenuItem(" - "));
        menu2.add(new MenuItem("*-"));
        menu2.add(new MenuItem("Jesús e Ismael el uno al otro"));
        menuBar.add(menu2);
        this.setMenuBar(menuBar);
        
    }
    
    public void paint(Graphics g){
        g.drawString(frames[dibujo][actual], 200, 200);
    }
    
    public void run(){
        while(true){//bucle infinito--infinite loop
           actual = ++actual % frames[dibujo].length;//modo preincrementativo
           repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animacion1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean handleEvent(Event ev) {
        if (ev.id == Event.WINDOW_DESTROY) {
            System.exit(0);
            return true;
        } else if(ev.id == Event.ACTION_EVENT){
            if(ev.target instanceof MenuItem){//instanceof sirve para comparar clases
              if(ev.arg.equals("Salir")){//Si el argumento, es decir, el texto es Salir
                  System.exit(0);
                  return true;
              }
              if(ev.arg.equals(" * ")){
                  velocidad = 500;
                  dibujo = 0;
                  return true;
              }
              if(ev.arg.equals(" - ")){
                  velocidad = 500;
                  dibujo = 1;
                  return true;
              }
              if(ev.arg.equals("*-")){
                  velocidad = 500;
                  dibujo = 2;
                  return true;
              }
              if(ev.arg.equals("Jesús e Ismael el uno al otro")){
                  velocidad = 50;
                  dibujo = 3;
                  return true;
              }
            }
        }
        return false;
    }
}
