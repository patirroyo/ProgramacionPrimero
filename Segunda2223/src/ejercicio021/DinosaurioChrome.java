package ejercicio021;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class DinosaurioChrome extends Rectangle {
    public static final int RADIO = 80;
    public int velY = 3;
    int vida = 3;
    int contador;
    boolean salto = false;
    
    public DinosaurioChrome(){
        super(150, 450 - RADIO, RADIO/2, RADIO);
       
        
    }
    public void paint(Graphics gg){
        gg.setColor(Color.RED);
        gg.fillRect(x, y, width, height);
        gg.setColor(Color.BLACK);
        gg.drawRect(x, y, width, height);
        
    }
    public void update(){
        if(y < 450 - height)
            y += velY;
        else
            y = 450 -height;
        switch(vida){
            case 2:
                width = RADIO/4;
                break;
            case 1:
                height = RADIO/2;
                break;
            case 0:
                Juego.gameOver = true;
        }
        if(salto){
            switch (contador){
                case 40:
                    y--;
                    velY = -3;
                    
                    break;
                case 20:
                    velY = 0;
                    break;
                case 10:
                    velY = 3;
                    break;
                case 0:
                    salto = false;
            }
            contador--;
        }
    }
    public void saltar() {
        contador = 40;
        salto = true;
    }
}