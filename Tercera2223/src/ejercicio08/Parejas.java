/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio08;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Parejas extends Applet implements Runnable {
    public static final int FILAS = 4;
    public static final int COLUMNAS = 4;
    public final static int SIZEX = 512;
    public final static int SIZEY = 512;
    private Image imagen; 
    private Graphics noseve;
    private Thread animacion;
    private int delay = 200;
    private Image reverso;
    private Image[] imagenes;
    private Casilla[][] casillas;
    private Casilla activa1;
    private Casilla activa2;
    private int contador;
    private int descubiertas;
    
    public void init(){
        this.setSize(SIZEX, SIZEY);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        reverso = getImage(getCodeBase(), "Ejercicio08/imagenes/reverso.jpg");

        imagenes = new Image[FILAS*COLUMNAS/2];
        for(int i = 0; i < imagenes.length; i++)
            imagenes[i] = getImage(getCodeBase(), "Ejercicio08/imagenes/" + i + ".jpg");
        
        casillas = new Casilla[FILAS][COLUMNAS];
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++)   
                casillas[i][j] = new Casilla(j*Casilla.LADO, i*Casilla.LADO, imagenes[(i*FILAS + j)/2], reverso);
        
        desordenarImagenes();

    }

    private void desordenarImagenes() {
        for(int i = 0; i < 200; i++){
            Image intercambio;
            int aleatorioFilas = (int)(Math.random()*FILAS);
            int aleatorioColumnas = (int)(Math.random()*COLUMNAS);
            intercambio = casillas[aleatorioFilas][aleatorioColumnas].getImagen();
            casillas[aleatorioFilas][aleatorioColumnas].setImagen(casillas[0][0].getImagen());
            casillas[0][0].setImagen(intercambio);
        }
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, SIZEX, SIZEY);

        descubiertas = 0;
        for(int i = 0; i < FILAS; i++)
             for(int j = 0; j < COLUMNAS; j++){
                 casillas[i][j].paint(noseve, this);
                 if(casillas[i][j].isDescubierta())
                     descubiertas++;
             }
        if(descubiertas == 16){
            noseve.setFont(new Font("Arial", Font.BOLD, 56));
            noseve.drawString("Has ganado", SIZEX/2-170, SIZEY/2);
        }
      
       g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
        
    }
    
    public void run(){
        while(true){
            contador++;
            if(contador == 1000/delay)
                repaint();
            
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++)
                if(casillas[i][j].contains(x,y) && activa1 == null && !casillas[i][j].isDescubierta()){
                    casillas[i][j].setDescubierta(Boolean.TRUE);
                    activa1 = casillas[i][j];
                    repaint();
                }else if(casillas[i][j].contains(x,y) && activa2 == null && !casillas[i][j].isDescubierta()){
                    casillas[i][j].setDescubierta(Boolean.TRUE);
                    activa2 = casillas[i][j];
                    repaint();
                }
        return false;
    } 

    public boolean mouseUp(Event ev, int x, int y){
        if(activa2 == null)
            return false;
        if(activa1.getImagen() != activa2.getImagen()){
            activa1.setDescubierta(Boolean.FALSE);
            activa2.setDescubierta(Boolean.FALSE);
            contador = 0;
        }
        activa1 = null;
        activa2 = null;
        

        return true;
    } 
}