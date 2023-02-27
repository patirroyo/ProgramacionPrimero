package ejercicio021;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class DinosaurioChrome extends Rectangle {
    public static final int RADIO = 80;
    public int velY = 4;
    int vida = 3;
    int contador;
    private boolean salto = false;

    public DinosaurioChrome(){
        super(50, 450 - RADIO, RADIO/2, RADIO);
       
        
    }
    public void paint(Graphics gg){
        gg.setColor(Color.RED);
        gg.fillOval(x, y, width, height);
        gg.setColor(Color.BLACK);
        gg.drawOval(x, y, width, height);
        
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
                width *= 2;
                height /= 2;
                y = 450 - height;
                Juego.gameOver = true;
        }
        if(salto){
            switch (contador){
                case 35:
                    y--;
                    velY = -velY;
                    break;
                case 20:
                    velY = 0;
                    break;
                case 15:
                    velY = 4;
                    break;
                case 0:
                    salto = false;
            }
            contador--;
        }
    }
    public void saltar() {
        contador = 35;
        salto = true;
    }
}