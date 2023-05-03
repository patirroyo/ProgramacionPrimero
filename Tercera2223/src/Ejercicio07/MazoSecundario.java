package Ejercicio07;


import java.applet.Applet;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;


public class MazoSecundario {
    public ArrayList<Carta> lista;
    public static final int POSX = 150;
    public static final int POSY = 20;
    
    public MazoSecundario(){
        lista = new ArrayList<Carta>();
    }

    public void cargar(Carta carta){
        carta.setPosicion(POSX, POSY);
        lista.add(carta);
    } 
    public Carta extraer(){
        return lista.get(lista.size()-1);
    }
    public void eliminar(){
        lista.remove(lista.size()-1);
    }
    public void recolocar(){
        lista.get(lista.size()-1).setPosicion(POSX, POSY);
    }
    
    public void paint(Graphics gg, Applet applet){
        for(Carta carta:lista)
            carta.paint(gg, applet);
    }
}
