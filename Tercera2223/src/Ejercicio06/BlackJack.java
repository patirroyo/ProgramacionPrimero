/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio06;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author alberto
 */
public class BlackJack extends Applet implements Runnable {
    private Graphics noseve;
    private Image imagen; 
    public final static int SIZEX = 800;
    public final static int SIZEY = 600;
    public static final int NCARTAS = 52;
    public static final int PALOS = 4;
    public static final int CARTASXPALO = 13;
    public static final int HUECOS = 7;
    private Image[] cartaImagen;
    private Button boton;
    private int saldo;
    private int acumuladorUltimaJugada;
    private String [] palo = {"_of_clubs", "_of_diamonds", "_of_hearts", "_of_spades"};
   // private Carta []carta;
    private Baraja baraja;
    
    @Override
    public void init(){
        this.setSize(SIZEX, SIZEY);
        
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        cartaImagen = new Image[NCARTAS];
        
        
        crearCartas(); 

        
        
       // Panel panel = new Panel();
        boton = new Button("Jugar !");
       // panel.add(boton);
       // this.setLayout(new BorderLayout());
        this.add("North", boton); 
    }
    
    private void crearCartas() {
        for(int i = 0; i < NCARTAS; i++)
            cartaImagen[i] = getImage(getCodeBase(), "Ejercicio06/Cartas/" + ((i % CARTASXPALO) + 1) + palo[i/CARTASXPALO] + ".png");
        baraja = new Baraja(cartaImagen);
        /* Otra forma de hacerlo sin la baraja.
        carta = new Carta[NCARTAS];
        
        for(int i = 0; i < PALOS; i++)
            for(int j = 0; j < CARTASXPALO; j++){
                cartaImagen[i*CARTASXPALO + j] = getImage(getCodeBase(), "Ejercicio06/Cartas/" + (j+1) + palo[i] + ".png");
                if(j < 10)
                    carta[i*CARTASXPALO + j] = new Carta(j+1 , cartaImagen[i*CARTASXPALO + j]);
                else
                    carta[i*CARTASXPALO + j] = new Carta(10 , cartaImagen[i*CARTASXPALO + j]);
            }
        */
    }   
    
    @Override
    public void start(){
  
    }
    
    @Override
    public void paint(Graphics g){
        noseve.setColor(new Color(76,106,90));
        noseve.fillRect(0, 0, SIZEX, SIZEY);
      
        
        for(Carta carta : baraja.getLista())
            carta.paint(noseve, this);
        
        
        
        noseve.setColor(Color.WHITE);
        for(int i = 0; i < HUECOS; i++){
            noseve.drawRect(i*Carta.WIDTH + 10*i + 20, 400, Carta.WIDTH, Carta.HEIGHT);
            noseve.drawRect(i*Carta.WIDTH + 10*i + 20, 220, Carta.WIDTH, Carta.HEIGHT);
        }
        
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
            
            repaint();
            return true;
        }  
        return false;
    }
}
