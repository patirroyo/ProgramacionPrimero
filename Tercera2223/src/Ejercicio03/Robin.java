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
    private Image robin, flecha, explota;
    private final int NUMGLOBOS = 3;
    private Image globosImgs[];
    private Arquero arquero;
    private List<Flecha> flechas = new ArrayList<Flecha>();
    private List<Globo> globos = new ArrayList<Globo>();
    private int contador = 0;
    private int score = 0;
    private static final int MAXFLECHAS = 3;

    public void init(){
        this.setSize(SIZEX, SIZEY);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        robin = getImage(getCodeBase(), "Ejercicio03/Imagenes/robin.png");
        flecha = getImage(getCodeBase(), "Ejercicio03/Imagenes/flecha.png");
        explota = getImage(getCodeBase(), "Ejercicio03/Imagenes/bang.png");

        globosImgs = new Image[3];
        for(int i = 0; i < NUMGLOBOS; i++)
            globosImgs[i] = getImage(getCodeBase(), "Ejercicio03/Imagenes/globo" + (i+1) + ".png");
        
        
        arquero = new Arquero(robin);
        globos.add(new Globo(globosImgs[0], explota));
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
       noseve.setColor(Color.CYAN);
       noseve.fillRect(0, 0, SIZEX, 100);
       noseve.setColor(Color.LIGHT_GRAY);
       noseve.fillRect(0, 100, SIZEX, SIZEY - 100);
       
       arquero.paint(noseve, this);
       pintarFlechas();
       pintarGlobos();
       pintarScore();
      
       g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }

    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);  
    }
    
    public void run(){
        while(true){
            LoDeLosGlobos();
            LoDeLasFlechas();
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
        if(flechas.size() < MAXFLECHAS)
            flechas.add(new Flecha(y, flecha));   
        return true;
    }
    private void LoDeLosGlobos() {
        //con cada iteración del bucle añadimos al contador el delay para que nos marque los ms "exactos" que han pasado
        contador+= delay;
        if(contador>1000){
            //cada 1000 ms 
            globos.add(new Globo(globosImgs[(int)(Math.random()*NUMGLOBOS)], explota));
            contador = 0;
        }
        if(!globos.isEmpty())
            for(Globo globo : globos){
                globo.update();
                if(!flechas.isEmpty())
                    for(Flecha flecha : flechas){
                        if(globo.intersects(flecha)){
                            if(!globo.isExplotado()){
                               score++;
                               flechas.remove(flecha);
                             }
                            globo.setExplotado();
                            break;
                        }                            
                    }
            }
        if(globos.get(0).y < - globos.get(0).height){
            globos.remove(globos.get(0));
        }
    }
    private void LoDeLasFlechas() {
        if(!flechas.isEmpty())
            for(Flecha flecha : flechas){
                flecha.update();
                if(flecha.x > SIZEX){
                    flechas.remove(flecha);
                    break;
                }
            }
    }
    private void pintarScore() {
        noseve.setColor(Color.BLACK);
        noseve.drawString("SCORE: " + score, 300, SIZEY - 5);
        noseve.drawString("FLECHAS: " + (3 - flechas.size()), 400, SIZEY - 5);
    }

    private void pintarGlobos() {
        if(!globos.isEmpty())
            for(Globo globo : globos)
                globo.paint(noseve, this);
    }

    private void pintarFlechas() {
        if(!flechas.isEmpty())
            for(Flecha flecha : flechas)
                flecha.paint(noseve, this);
    }
}