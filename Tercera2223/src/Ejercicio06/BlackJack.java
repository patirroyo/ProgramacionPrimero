/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio06;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

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
    public static final int YJUGADOR = 400;
    public static final int YCROUPIER = 200;
    private TextField apuesta;
    private boolean finJugada = false;
    private boolean ganaJugador = false;
    private boolean empate = false;
    
    @Override
    public void init(){
        this.setSize(SIZEX, SIZEY);
        
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        cartaImagen = new Image[NCARTAS];
        
        jugador = new ManoDeCartas();
        croupier = new ManoDeCartas();
        
        crearCartas(); 
        
        setupPanels();
      
        
    }

    private void setupPanels() throws HeadlessException {
        Panel panel = new Panel();
        boton1 = new Button("Carta !");
        boton2 = new Button("Me planto !");
        boton3 = new Button("Jugar !");
        
        panel.add(boton1);
        panel.add(boton2); 
        
        
        Panel panel2 = new Panel();
        Label etiqueta = new Label("Introduce tu apuesta: ", Label.RIGHT);
        apuesta = new TextField("", 10);
        panel2.add(etiqueta);
        panel2.add(apuesta);
        panel2.add(boton3);
        
        this.setLayout(new BorderLayout());
        this.add("South", panel);
        this.add("North", panel2);
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
        
        if(finJugada){
            noseve.setColor(Color.WHITE);
            if(ganaJugador)
                noseve.drawString("Has ganado", 400, 300);
            else if(empate)
                noseve.drawString("Has empatado", 400, 300);
            else
                noseve.drawString("Has perdido", 400, 300);
        }
        
        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }

    private void paintCartas() {
        for(int i = 0; i < baraja.getLista().size(); i++)
            baraja.getLista().get(i).paint(100, 50, noseve, this, true);
        if(!croupier.lista.isEmpty()){
            croupier.paint(YCROUPIER, noseve, this, finJugada);
            noseve.setColor(Color.WHITE);
            if(finJugada)
                noseve.drawString("Croupier: " + croupier.puntuacion(), SIZEX-150, 250);
        }
        if(!jugador.lista.isEmpty()){
            jugador.paint(YJUGADOR, noseve, this, finJugada);
            noseve.setColor(Color.WHITE);
            noseve.drawString("Jugador: " + jugador.puntuacion(), SIZEX-150, 450);
        }
        
    }
        
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);  
    }
    
    public void run(){
        while(true){  
        }
    }
    
    public boolean action(Event ev, Object obj){
        if(ev.target instanceof TextField){
            baraja.embarajar();
            jugador.addCarta(baraja.sacarCarta());
            jugador.addCarta(baraja.sacarCarta());
            croupier.addCarta(baraja.sacarCarta());
            croupier.addCarta(baraja.sacarCarta());
            apuesta.setEditable(false);
            repaint();
            return true;
        }else if(ev.target instanceof Button){
            if(obj.toString() == "Jugar !"){//pongo este boton porque en el mac no funciona la condición de arriba
                finJugada = false;
                empate = false;
                ganaJugador = false;
                jugador.lista.clear();
                croupier.lista.clear();
                baraja.embarajar();
                jugador.addCarta(baraja.sacarCarta());
                croupier.addCarta(baraja.sacarCarta());
                jugador.addCarta(baraja.sacarCarta());
                croupier.addCarta(baraja.sacarCarta());
                apuesta.setEditable(false);
            }
            if("Carta !".equals(ev.arg) && !finJugada){
                jugador.addCarta(baraja.sacarCarta());
                if(jugador.pasado()){
                    sacarCartaCroupier();
                    finJugada = true;
                }
            }
            if(obj.toString() == "Me planto !"){
                if(!jugador.pasado() && !croupier.alcanza17()){
                    sacarCartaCroupier();
                } 
                if((jugador.puntuacion() > croupier.puntuacion() && !jugador.pasado()) || 
                    croupier.pasado() && !jugador.pasado())
                    ganaJugador = true;
                else if((jugador.pasado() && croupier.pasado()) || jugador.puntuacion() == croupier.puntuacion())
                    empate = true;
                finJugada = true;        
                }
                    
            
        }
        repaint();
        return false;
    }

    private void sacarCartaCroupier() {
        while(croupier.puntuacion() < jugador.puntuacion() && !croupier.alcanza17())
            croupier.addCarta(baraja.sacarCarta());
    }

    public Image getReverso() {
        return reverso;
    }

    public Graphics getNoseve() {
        return noseve;
    }

    public ManoDeCartas getCroupier() {
        return croupier;
    }
    
}
