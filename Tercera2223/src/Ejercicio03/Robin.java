/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio03;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alber
 */
public class Robin extends Applet implements Runnable {
    private int delay = 20;
    private Thread animacion;
    private Image imagen; 
    private Graphics noseve;
    public final static int SIZEX = 800;
    public final static int SIZEY = 600;
    Image robin, flecha, globo, explota;
    Arquero arquero;
    List<Flecha> flechas = new ArrayList<Flecha>();
    List<Globo> globos = new ArrayList<Globo>();
    
    
    
    
    
    
    public void init(){
        this.setSize(SIZEX, SIZEY);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        robin = getImage(getCodeBase(), "Ejercicio03/Imagenes/robin.png");
        flecha = getImage(getCodeBase(), "Ejercicio03/Imagenes/flecha.png");
        globo = getImage(getCodeBase(), "Ejercicio03/Imagenes/globo.jpg");
        explota = getImage(getCodeBase(), "Ejercicio03/Imagenes/bang.jpg");
        
        arquero = new Arquero(robin);
        globos.add(new Globo(globo, explota));
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.WHITE);
       noseve.fillRect(0, 0, SIZEX, SIZEY);
       arquero.paint(noseve, this);
       
       if(!flechas.isEmpty())
           for(Flecha flecha : flechas)
               flecha.paint(noseve, this);
       
       if(!globos.isEmpty())
           for(Globo globo : globos)
               globo.paint(noseve, this);
      
       g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
        
    }
    
    public void run(){
        while(true){
            if((int)(Math.random()*100) == 0)
                globos.add(new Globo(globo, explota));
            if(!flechas.isEmpty())
                for(Flecha flecha : flechas){
                    flecha.update();
                    if(flecha.x > SIZEX){
                        flechas.remove(flecha);
                        break;
                    }
                }
            if(!globos.isEmpty())
                for(Globo globo : globos){
                    globo.update();
                    if(globo.y < - globo.height){
                        globos.remove(globo);
                        break;
                    }
                    if(!flechas.isEmpty())
                        for(Flecha flecha : flechas){
                            if(globo.intersects(flecha))
                               globo.setExplotado();
                        }
                                
                }
                    
            repaint();
           
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
    }
    
    public boolean mouseMove(Event ev, int x, int y){
        arquero.update(x, y);
        
        
        return true;
    }
    public boolean mouseDown(Event ev, int x, int y){
       flechas.add(new Flecha(y, flecha));
        
        return true;
    }
}