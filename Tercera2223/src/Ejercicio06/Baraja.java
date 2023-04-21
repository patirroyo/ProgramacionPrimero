
package Ejercicio06;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class Baraja {
    private List<Carta> lista;
    private Image[] cartaImagen;
    private Carta carta;
    
    public Baraja(Image[] imagenes){
        lista = new ArrayList<Carta>();
        cartaImagen = imagenes;
        for(int i = 0; i < BlackJack.NCARTAS; i++){
            if((i % BlackJack.CARTASXPALO) +1 < 10)
                    lista.add(new Carta((i % BlackJack.CARTASXPALO) +1 , cartaImagen[i]));
                else
                    lista.add(new Carta(10 , cartaImagen[i]));
        }
    }
    
    public Carta sacarCarta(){
        carta = lista.get(0);
        lista.remove(lista.get(0));
        return carta;
        
    }

    public List<Carta> getLista() {
        return lista;
    }
    
}
