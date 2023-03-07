/*
Realizar el juego que “una” los rectángulos inmóviles, 
situados en la parte inferior de la pantalla, 
con los rectángulos móviles que circulan por su parte superior.  
Siguiendo los siguientes pasos:

Crear una clase para los rectángulos inmóviles de la parte inferior.  1 punto

Crear una clase para los rectángulos móviles de la parte superior.  1 punto

Crear una clase para las líneas que unirán los rectángulos inmóviles 
con los móviles.  1 punto

De cada una de estas clases, deberás crear una lista en el programa principal y 
resolver correctamente cuando cargas sus elementos, cómo se actualizan,
cómo interactúan… 2 puntos

Las líneas adquirirán el color del rectángulo inmóvil sobre el que se 
haga click. 0,5 puntos

Las líneas se irán pintando mientras el botón izquierdo del ratón permanezca 
pulsado, siempre y cuando se haya hecho click sobre un 
rectángulo inmóvil previamente.  2 puntos

Al soltar el ratón sobre un rectángulo móvil del mismo color,
la línea permanecerá unida a este y 
continuará redibujándose según la trayectoria que este siga.  
Si no se suelta el ratón sobre un rectángulo móvil del mismo color, 
la línea desaparece.  2,5 puntos*/

package examenAlbertoSaz;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class Examen extends Applet implements Runnable {
    int delay = 20;
    Thread animacion;
    Image imagen; 
    Graphics noseve;
    Color [] colores = {Color.RED, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
    List<CuadradoInferior> cuadradosAbajo = new ArrayList<CuadradoInferior>();
    List<CuadradoMovil> cuadradosArriba = new ArrayList<CuadradoMovil>();
    List<DosPuntos> lineas = new ArrayList<DosPuntos>();
    DosPuntos actual;
    
    public void init(){
        
        for(int i = 0; i < colores.length; i++)
            cuadradosAbajo.add(new CuadradoInferior(i, colores[i]));
        for(int i = 0; i < colores.length; i++)
            cuadradosArriba.add(new CuadradoMovil(i, colores[i]));
        this.setSize(600, 600);
       
        imagen = this.createImage(600, 600); 
        noseve = imagen.getGraphics();
        
    }
    
    
    public void start(){
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        animacion.start();//es el que llama a ejecutar el método run
        
        
    }
    public void paint(Graphics g){
       noseve.setColor(Color.BLACK);
       noseve.fillRect(0, 0, 600, 600);
       
       for(CuadradoInferior ci : cuadradosAbajo)
           ci.paint(noseve);
       
       for(CuadradoMovil cm : cuadradosArriba)
           cm.paint(noseve);
       
       if(actual != null)
           actual.paint(noseve);
       
       if(!lineas.isEmpty())
           for(DosPuntos li : lineas)
               li.paint(noseve);
       
       
       g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }
    
    public void run(){
        while(true){
            for(CuadradoMovil cm : cuadradosArriba){
                cm.update();
            if(!lineas.isEmpty())    
                for(DosPuntos li : lineas){
                    li.update();
                }
                
            }
          
            repaint();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){           
            }
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(CuadradoInferior ci : cuadradosAbajo){
           if(ci.contains(x, y)){
               actual = new DosPuntos(x, y, ci.color);
               repaint();
               return true;
           }
        }
        
        
        return false;
    }
    public boolean mouseDrag(Event ev, int x, int y){//cuando haces click y sin soltar, mueves
        if(actual != null){ 
            actual.setPosFinX(x);
            actual.setPosFinY(y);
            for(DosPuntos li: lineas)
                if(li.getColor()==actual.getColor()){
                    actual = null;
                    break;
                }
            
            repaint();
        }
       
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        for(CuadradoMovil cm : cuadradosArriba){
            if(cm.contains(x, y) && cm.color == actual.getColor()){
               lineas.add(new DosPuntos(actual.getPosIniX(), actual.getPosIniY(), cm));
               actual = null;
               repaint();
               break;  
           } 
           
        }
        
        actual = null;
        return true;
    }
        
}