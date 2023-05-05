package Ejercicio07;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Label;
import java.awt.Rectangle;

public class Solitario extends Applet implements Runnable {
    public static final int NUM_CARTAS = 52; //numero de cartas total
    public static final int NUM_PALOS = 4; //numero de palos
    public static final int CPP = 13; //Cartas por palo
    String nombres[] = {"_of_clubs","_of_diamonds","_of_hearts","_of_spades"};
    Image imagenes[];
    Image imgReverso; //imagen del reverso de la carta
    Graphics noseve;
    Baraja baraja;
    Rectangle reverso;
    MazoSecundario mSecundario;
    Carta activa;
    Image imagen;
    MazoPalo mPalos[];
    //MazoJuego mJuegos[];

    public void init(){
        this.setSize(900, 700);
        
        imagen = this.createImage(900, 700);
        noseve = imagen.getGraphics(); 
        
        imagenes = new Image[NUM_CARTAS]; //Cartas de la baraja
        for (int i = 0; i < NUM_CARTAS; i++) {
            imagenes[i] = getImage(getCodeBase(), "Ejercicio07/Cartas/" + ((i % CPP) + 1) + nombres[i/CPP] + ".png");
        }
        //Creo la imagen suelta del reverso que sirve para tapar las cartas
        imgReverso = getImage(getCodeBase(), "Ejercicio07/Cartas/reverso.png");
        
        reverso = new Rectangle(20, 20, Carta.WIDTH, Carta.HEIGHT);

        baraja = new Baraja(imagenes);
        baraja.barajar();
        
        mSecundario = new MazoSecundario();
        mPalos = new MazoPalo[NUM_PALOS];
        for(int i=0; i<NUM_PALOS; i++)
            mPalos[i] = new MazoPalo(400 + (i*100));
        /*mJuegos = new MazoJuego[7];
        for(int i=0; i<7; i++)
            mJuegos[i] = new MazoJuego(100 + (i*100));

*/
        //Botones para pedir cartas o parar
        setup();

    }

    private void setup() {
        this.setLayout(new BorderLayout());
        Panel panel = new Panel();
        Button boton1 = new Button("Carta +");
        Button boton2 = new Button("Me planto");
        panel.add(boton1);
        panel.add(boton2);
        this.add("South",panel);

       
    }

    public void paint(Graphics g){
        noseve.setColor(new Color(76,106,90));
        noseve.fillRect(0, 0, 900, 700);
        
        //Pinto la imagen del reverso
        noseve.drawImage(imgReverso, 20, 20, Carta.WIDTH, Carta.HEIGHT, this);
        
        if(!mSecundario.lista.isEmpty())
            for(Carta carta:mSecundario.lista)
                carta.paint(noseve, this);
        //Pinto las cartas
        for(int i = 0; i < mPalos.length; i++)
            mPalos[i].paint(noseve, this);
        

       
        

        g.drawImage(imagen,0,0,this);
    }
    
    public void run(){
        while(true){  
            //paint(noseve);
        }
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        if(reverso.contains(x,y)){
            mSecundario.cargar(baraja.sacar());
            repaint();
            return true;
        }
        if(!mSecundario.lista.isEmpty() && mSecundario.extraer().contains(x,y))
            activa = mSecundario.extraer();
        return false;
    } 
    public boolean mouseDrag(Event ev, int x, int y){
        if(activa == null)
            return false;
        activa.setPosicion(x-Carta.WIDTH/2, y-Carta.HEIGHT/2);
        repaint();
        return true;
    } 
    public boolean mouseUp(Event ev, int x, int y){
        if(activa == null)
            return false;
        for(int i = 0; i < mPalos.length; i++)
            if(mPalos[i].intersects(activa)){
                mPalos[i].cargar(activa);
                mSecundario.lista.remove(activa);
            }
        mSecundario.recolocar();
        activa = null;
        repaint();
        return true;
    } 
}

