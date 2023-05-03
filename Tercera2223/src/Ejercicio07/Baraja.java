package Ejercicio07;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;


public class Baraja {
    ArrayList<Carta> lista;
    
    public Baraja(Image[] imagenes){
        lista = new ArrayList<Carta>();
        for (int i = 0; i < imagenes.length; i++) {
            lista.add(new Carta(imagenes[i], (i % Solitario.CPP) + 1, ((i/13) == 0 || (i/13) == 3)? Carta.NEGRO:Carta.ROJO , (i/13)));
        }
    }

    public Carta sacar(){
        Carta auxiliar = lista.get(0); //creamos una carta temporal que guarda la dirección de donde se encuentra el objeto en la lista
        lista.remove(0);
        return auxiliar;
    }

    //en lugar de este método vamos a usar el método shuffle
    public void barajar(){ 
        Collections.shuffle(lista);
         /*for (int i = 0; i < 100; i++) {
             int c1 = (int)(Math.random() * Solitario.NUM_CARTAS);
             int c2 = (int)(Math.random() * Solitario.NUM_CARTAS);
             Carta inter = lista.get(c1);
             lista.set(c1,lista.get(c2));
             lista.set(c2, inter);
         }*/

    }

}
