package Ejercicio07;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class MazoJuego extends Rectangle{
    public ArrayList<Carta> lista;
    public static final int POSY = 200;
    private int palo;
    
    public MazoJuego(int x){
        super(x, POSY, Carta.WIDTH, Carta.HEIGHT);
        lista = new ArrayList<Carta>();
    }

    public boolean cargar(Carta carta){
        if(lista.size() == 0){
            if(carta.getValor()==1){
                lista.add(carta);
                recolocar();
                palo = carta.getPalo();
                return true;
            }
        }else{
            if(palo == carta.getPalo())
                if(lista.get(lista.size()-1).getValor() == carta.getValor()+1){
                    lista.add(carta);
                    recolocar();
                    return true;
            }
        }
        return false;
    } 
    public Carta extraer(){
        return lista.get(lista.size()-1);
    }
    public void eliminar(){
        lista.remove(lista.size()-1);
    }
    public void recolocar(){
        lista.get(lista.size()-1).setPosicion(x, POSY);
    }
    
    public void paint(Graphics gg, Applet applet){
        gg.setColor(Color.WHITE);
        gg.drawRect(x, y, width, height);
        if(!lista.isEmpty())
            for(Carta carta:lista)
                carta.paint(gg, applet);
    }
}
