package Ejercicio07;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class MazoJuego extends Rectangle{
    public ArrayList<Carta> lista;
    public static final int POSY = 200;
    
    public MazoJuego(int x){
        super(x, POSY, Carta.WIDTH, Carta.HEIGHT);
        lista = new ArrayList<Carta>();
    }

    public boolean cargar(Carta carta){
        if(lista.size() == 0){
            lista.add(carta);
            recolocar(carta);
            return true;
        }else{
            if(lista.get(lista.size()-1).getColor() != carta.getColor()){
                if(lista.get(lista.size()-1).getValor() == carta.getValor()+1){
                    lista.add(carta);
                    recolocar(carta);
                    return true;
                }
            }
        }
        return false;
    } 
    
    public Carta extraer(){
        return lista.get(lista.size()-1);
    }
    public void eliminar(Carta carta){
        lista.remove(carta);
    }
    public void recolocar(Carta carta){
        carta.setPosicion(x, POSY + (lista.size()-1)*30);
    }
    
    public void paint(Graphics gg, Applet applet){
        gg.setColor(Color.WHITE);
        gg.drawRect(x, y, width, height);
        if(!lista.isEmpty())
            for(Carta carta:lista)
                carta.paint(gg, applet);
    }
}
