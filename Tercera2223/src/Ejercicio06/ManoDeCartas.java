/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio06;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alberto
 */
public class ManoDeCartas {
    
    List<Carta> lista;
    
    public ManoDeCartas(){
        lista = new ArrayList<Carta>();
    }
    
    public void addCarta(Carta carta){
        lista.add(carta);
    }
    
    public int puntuacion(){
        int puntuacion = 0;
        boolean as = false;
        for(Carta carta:lista){
            puntuacion += carta.getValor();
            if(carta.isAS())
                as = true;
        }
        if(as && puntuacion < 12)
            puntuacion += 10;
        
        return puntuacion;
    }
    
    public void paint(int posY, Graphics gg, Applet applet, Boolean finJugada){
        for(Carta carta:lista){       
            carta.setX(lista.indexOf(carta)*25);
            carta.setY(posY);
            carta.paint(gg, applet);
            if(carta.equals(lista.get(0)) && carta.getY() == BlackJack.YCROUPIER && !finJugada)
                carta.paint(gg, applet, true);
            else    
                carta.paint(gg, applet, false);
        }
    }
    
    public boolean pasado(){
        return puntuacion() > 21;
    }
    public boolean alcanza17(){
        return puntuacion() >= 17;
    }
}
