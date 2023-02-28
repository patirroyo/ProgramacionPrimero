
package ejercicio022;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author alber
 */
public class Mario extends Rectangle {
    public static final int RADIO = 40;
    public int velY = 3;
    int vida = 3;
    private boolean salto = false;
    int contadorAnimacion = 0;
    int contador = 0;
    static final int IZQUIERDA = 1006;
    static final int DERECHA = 1007;
    

    public Mario(){
        super(275, 50 - RADIO, RADIO/2, RADIO);
       
        
    }
    public void paint(Graphics gg){
        gg.setColor(Color.RED);
        gg.fillOval(x, y, width, height);
        gg.setColor(Color.BLACK);
        gg.drawOval(x, y, width, height);
        
    }
    public void update(){
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
                SaltarPlataformas.gameOver = true;
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
                    velY = 3;
                    break;
                case 0:
                    salto = false;
            }
            contador--;
        }
        if(y+height<=450)
            y += velY;
    }
     public void update(int tecla){
        if(vida > 0 && y < 600){
            switch(tecla){
                case IZQUIERDA: 
                    x -= 20;
                    break;
                case DERECHA: 
                    x += 20;          
            }
        }
       
    }
    public void saltar() {
        contador = 35;
        salto = true;
    }
}
