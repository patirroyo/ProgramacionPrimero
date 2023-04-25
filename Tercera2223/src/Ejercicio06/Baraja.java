
package Ejercicio06;

import java.awt.Image;
import java.util.ArrayList;


public class Baraja {
    private ArrayList<Carta> lista;
    private Image[] cartaImagen;
    private Carta carta;
    private int posicionAleatoria;
    
    public Baraja(Image[] imagenes, Image reverso){
        lista = new ArrayList<Carta>();
        cartaImagen = imagenes;
        for(int i = 0; i < BlackJack.NCARTAS; i++)
            lista.add(new Carta(i % BlackJack.CARTASXPALO +1 , cartaImagen[i], reverso));
    }
    
    public Carta sacarCarta(){
        if(!lista.isEmpty()){
            carta = lista.get(0);
            lista.remove(0);
        }else
            System.out.println("No hay cartas");  
        return carta;
    }
    
    public void embarajar(){
        if(lista.isEmpty())
            return;
        for(int i = 0; i < 200; i++){
            posicionAleatoria = (int)(Math.random()*lista.size());
            carta = lista.get(posicionAleatoria);
            lista.remove(posicionAleatoria);
            lista.add(carta);
        }  
    }
    public void embarajarAgustin(){
        if(lista.isEmpty())
            return;
        for(int i = 0; i < 100; i++){
            int c1 = (int)(Math.random()*lista.size());
            int c2 = (int)(Math.random()*lista.size());
            Carta inter = lista.get(c1);
            lista.set(c1, lista.get(c2));
            lista.set(c2, inter);
        }
    }

    public ArrayList<Carta> getLista() {
        return lista;
    }
    
}
