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
    private Image reverso;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private int saldo;
    private int acumuladorUltimaJugada;
    private String [] palo = {"_of_clubs", "_of_diamonds", "_of_hearts", "_of_spades"};
    private Carta carta;
    private Baraja baraja;
    private ManoDeCartas jugador;
    private ManoDeCartas croupier;
    
    
    @Override
    public void init(){
        this.setSize(SIZEX, SIZEY);
        
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        cartaImagen = new Image[NCARTAS];
        
        jugador = new ManoDeCartas();
        croupier = new ManoDeCartas();
        
        crearCartas(); 
        
       // Panel panel = new Panel();
       boton1 = new Button("Barajar");
       boton2 = new Button("Sacar Carta");
       boton3 = new Button("Croupier");
               
       // panel.add(boton);
       // this.setLayout(new BorderLayout());
        this.add("North", boton1); 
        this.add("North", boton2); 
        this.add("North", boton3);
    }
    
    private void crearCartas() {
        for(int i = 0; i < NCARTAS; i++)
            cartaImagen[i] = getImage(getCodeBase(), "Ejercicio06/Cartas/" + ((i % CARTASXPALO) + 1) + palo[i/CARTASXPALO] + ".png");
        reverso = getImage(getCodeBase(), "Ejercicio06/Cartas/reverso.png");
        baraja = new Baraja(cartaImagen, reverso);
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
      
        paintCartas();
        
        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }

    private void paintCartas() {
        for(int i = 0; i < baraja.getLista().size(); i++)
            baraja.getLista().get(i).paint(i*3, noseve, this, false);
        if(!jugador.lista.isEmpty())
            jugador.paint(400, noseve, this);
        if(!croupier.lista.isEmpty())
            croupier.paint(200, noseve, this);
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
            if(obj.toString() == "Sacar Carta"){
                carta = baraja.sacarCarta();
                jugador.addCarta(carta);
            }
            if(obj.toString() == "Croupier"){
                carta = baraja.sacarCarta();
                croupier.addCarta(carta);
            }
            if(obj.toString() == "Barajar")
                baraja.embarajar();
            repaint();
            return true;
        }  
        return false;
    }

    public Image getReverso() {
        return reverso;
    }
    
}
