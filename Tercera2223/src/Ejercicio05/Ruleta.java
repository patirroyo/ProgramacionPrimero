/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Crear un boton, al hacer click, saca un numero aleatorio entre 0-36 y escribe rojo-negro, par-impar, falta-pasa
 */
package Ejercicio05;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class Ruleta extends Applet implements Runnable {
    private Graphics noseve;
    private Image imagen; 
    public final static int SIZEX = 1000;
    public final static int SIZEY = 1000;
    private final int NUMCASILLAS = 36;
    public static final int ROWS = 12;
    public static final int COLUMNS = 3;
    private Casilla[][] casillas;
    private ArrayList lRojos;
    private Image[] fichaImagenes;
    private final int[] VALORFICHA = {1, 5, 10, 25, 50, 100, 500, 1000, 5000, 10000};
    private Ficha[][] fichas;
    private static final int NFICHAS = 10;
    private Ficha fichaActual;
    private Button boton;
    private int numeroAleatorio;
    private static final int NJUGADAS = 10;
    private int[] ultimas10jugadas;
    
    @Override
    public void init(){
        this.setSize(SIZEX, SIZEY);
        
        casillas = new Casilla[ROWS][COLUMNS];
        lRojos = new ArrayList<Integer>();
        
        instanciarCasillasColores();
        
        fichaImagenes = new Image[NFICHAS];
        
        instanciarFichas(); 
        
        ultimas10jugadas = new int[NJUGADAS];
        
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
       // Panel panel = new Panel();
        boton = new Button("Jugar !");
       // panel.add(boton);
       // this.setLayout(new BorderLayout());
        this.add("North", boton);
        
    }
    
    @Override
    public void start(){
  
    }
    
    @Override
    public void paint(Graphics g){
        noseve.setColor(new Color(76,106,90));
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        noseve.setColor(Color.BLACK);

        paintCasillas();
        paintFichas();
        paintNumeroAleatorio();
        paintUltimas10jugadas();
        
        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
     public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);  
    }
    
    public void run(){
        while(true){  
        }
    }
    
    public boolean action(Event ev, Object obj){
       if(ev.target instanceof Button){
           numeroAleatorio = (int)(Math.random() * 37);
           guardarUltimas10jugadas();
           repaint();
           return true;
       }
           
        return false;
    }

    private void guardarUltimas10jugadas() {
        for(int i = ultimas10jugadas.length - 1 ; i > 0 ; i--)
            ultimas10jugadas[i] = ultimas10jugadas[i -1];
        ultimas10jugadas[0] = numeroAleatorio;
    }
    
    @Override
    public boolean mouseDown(Event ev, int x, int y){
       for(int i = 0; i < NFICHAS; i++)
            for(int j = 0; j < NFICHAS; j++)
                if(fichas[i][j].contains(x, y)){
                    fichaActual = fichas[i][j];
                }
        fichaActual.clearApuestas();
        return true;
    } 
    @Override
    public boolean mouseDrag(Event ev, int x, int y){
        if(fichaActual == null)
            return false;
        
        fichaActual.move(x, y);
        repaint();
        return true;
    }
    @Override
    public boolean mouseUp(Event ev, int x, int y){
        if(fichaActual == null)
            return false;
                 
        fichaActual.setApuestas(casillas);         
        fichaActual = null;
            
        return true;
    }
    private void instanciarFichas() {
        for(int i = 0; i < fichaImagenes.length; i++)
            fichaImagenes[i] = getImage(getCodeBase(), "Ejercicio05/Fichas/" + "ficha" + (i+1) + ".png");
        
        fichas = new Ficha[NFICHAS][NFICHAS];
        for(int i = 0; i < NFICHAS; i++)
            for(int j = 0; j < NFICHAS; j++)
                fichas[i][j] = new Ficha(i*(Ficha.LADO-10)+j+i*15,VALORFICHA[i], fichaImagenes[i]);
    }

    private void instanciarCasillasColores() {
        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLUMNS; j++){
                final int valorCasilla = (i*COLUMNS + j)+1;
                if(numeroEsNegro(valorCasilla))
                    casillas[i][j] = new Casilla(j*Casilla.LADO, i*Casilla.LADO, (i*COLUMNS + j) +1, Color.BLACK);
                else{
                    casillas[i][j] = new Casilla(j*Casilla.LADO, i*Casilla.LADO, (i*COLUMNS + j) +1, Color.RED);
                    lRojos.add(new Integer(valorCasilla));
                }
            }
    }
   

    private static boolean numeroEsNegro(final int valorCasilla) {
        return (valorCasilla % 2 == 0 && (valorCasilla <= 10 || ((valorCasilla > 19) && valorCasilla < 29)))||
                (valorCasilla % 2 == 1 && ((valorCasilla > 10 && valorCasilla < 19)|| valorCasilla >= 29 ));
    }

    private void paintUltimas10jugadas() {
        noseve.setColor(Color.BLACK);
        for(int i = 0; i < ultimas10jugadas.length; i++){
            noseve.drawRect(300 + 50*i, 300, 50, 50);
            if(ultimas10jugadas[i] == 0)
                noseve.setColor(Color.WHITE);
            else if(lRojos.contains(ultimas10jugadas[i]))
                noseve.setColor(Color.RED);
            else
                noseve.setColor(Color.BLACK);            
            noseve.drawString(Integer.toString(ultimas10jugadas[i]), 310 + 50*i, 335);
            noseve.setColor(Color.BLACK);
        }
    }

    private void paintFichas() {
        for(int i = 0; i < NFICHAS; i++)
            for(int j = 0; j < NFICHAS; j++)
                fichas[i][j].paint(noseve, this);
    }

    private void paintCasillas() {
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++)
                casillas[i][j].paint(noseve);
        }
    }

    private void paintNumeroAleatorio() {
        if(numeroAleatorio == 0){
            noseve.setColor(Color.WHITE);
            noseve.drawString("CERO", 490, 120);
        }else if(lRojos.contains(numeroAleatorio)){
                noseve.setColor(Color.RED);
                noseve.drawString("ROJO", 490, 120);
            }else{
                noseve.setColor(Color.BLACK);
                noseve.drawString("NEGRO", 490, 120);
            }
        noseve.drawString(Integer.toString(numeroAleatorio), 500, 80);
        noseve.setColor(Color.BLACK);
       
        if(numeroAleatorio == 0){
            noseve.setColor(Color.WHITE);
            noseve.drawString("CERO", 490, 160);
        }
            else if(numeroAleatorio % 2 == 0)
                noseve.drawString("PAR", 490, 160);
            else
                noseve.drawString("IMPAR", 490, 160);
        if(numeroAleatorio == 0){
            noseve.setColor(Color.WHITE);
            noseve.drawString("CERO", 490, 200);
        }    
            else if(numeroAleatorio < 19)
                noseve.drawString("FALTA", 490, 200);
            else
                noseve.drawString("PASA", 490, 200);
    }
}
