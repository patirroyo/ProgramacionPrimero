package Ejercicio07;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
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
    Boolean encontrado = false;
    MazoJuego mJuegos[];
    public static final int MAZOSJUEGO = 7;
    Boolean activaIsMazoJuego = false;
    int mazoJuego;

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
        mJuegos = new MazoJuego[MAZOSJUEGO];
        for(int i=0; i<MAZOSJUEGO; i++)
            mJuegos[i] = new MazoJuego(100 + (i*100));
    }


    public void paint(Graphics g){
        noseve.setColor(new Color(76,106,90));
        noseve.fillRect(0, 0, 900, 700);
        
        //Pinto la imagen del reverso
        noseve.drawImage(imgReverso, 20, 20, Carta.WIDTH, Carta.HEIGHT, this);
        
        
        //Pinto las cartas
        for(int i = 0; i < mPalos.length; i++)
            mPalos[i].paint(noseve, this);
        if(!mSecundario.lista.isEmpty())
            for(Carta carta:mSecundario.lista)
                carta.paint(noseve, this);
        for(int i=0; i<MAZOSJUEGO; i++)
            if(!mJuegos[i].isEmpty())
                mJuegos[i].paint(noseve, this);

       
        

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
        for(int i=0; i<MAZOSJUEGO; i++)
            if(!mJuegos[i].lista.isEmpty() && mJuegos[i].extraer().contains(x,y)){
                activa = mJuegos[i].extraer();
                activaIsMazoJuego = true;
                mazoJuego = i;
                break;
            }
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
                if(mPalos[i].cargar(activa)){
                    eliminarCartaDeSuMazo();
                    break;
                }
            }
        
        for(int i=0; i<MAZOSJUEGO; i++)
            if(mJuegos[i].lista.isEmpty()){
                if(mJuegos[i].intersects(activa))
                    if(mJuegos[i].cargar(activa)){
                        eliminarCartaDeSuMazo();
                        break;
                    }else{
                        mJuegos[i].recolocar(activa);
                        break;
                    }
               
            }
            else
                if(mJuegos[i].lista.get(mJuegos[i].lista.size()-1).intersects(activa))
                    if(mJuegos[i].cargar(activa)){
                        eliminarCartaDeSuMazo();
                        break;
                    }else{
                        mJuegos[i].recolocar(activa);
                        break;
                    }
                
                    
                        
        if(!encontrado && !mSecundario.lista.isEmpty())
            mSecundario.recolocar();
        activa = null;
        activaIsMazoJuego = false;
        repaint();
        encontrado = false;
        return true;
    } 

    private void eliminarCartaDeSuMazo() {
        if(activaIsMazoJuego)
            mJuegos[mazoJuego].eliminar(activa);
        else
            mSecundario.eliminar();
        encontrado = true;
    }
}

