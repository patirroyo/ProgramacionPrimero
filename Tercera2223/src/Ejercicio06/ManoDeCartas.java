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
    
    public void paint(int posY, Graphics gg, Applet applet){
        for(Carta carta:lista)
            carta.paint(lista.indexOf(carta)*25, posY, gg, applet);
    }
}
