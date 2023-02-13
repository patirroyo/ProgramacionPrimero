/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio016;

/**
 *
 * @author alber
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Column {
    Color color = Color.BLACK;
    int velX = -2;
    private Rectangle parteArriba;
    private Rectangle parteAbajo;
    private Rectangle bocaAbajo;
    private Rectangle bocaArriba;

    public Rectangle getParteArriba() {
        return parteArriba;
    }

    public void setParteArriba(Rectangle parteArriba) {
        this.parteArriba = parteArriba;
    }

    public Rectangle getParteAbajo() {
        return parteAbajo;
    }

    public void setParteAbajo(Rectangle parteAbajo) {
        this.parteAbajo = parteAbajo;
    }

    public Rectangle getBocaAbajo() {
        return bocaAbajo;
    }

    public void setBocaAbajo(Rectangle bocaAbajo) {
        this.bocaAbajo = bocaAbajo;
    }

    public Rectangle getBocaArriba() {
        return bocaArriba;
    }

    public void setBocaArriba(Rectangle bocaArriba) {
        this.bocaArriba = bocaArriba;
    }
    
    public static final int ANCHURA = 90;
    public int hueco = (int)(Math.random()*100 + 3*Bird.RADIO);
    int random = (int)(Math.random()*300 + 100);
    
    public Column(){
       parteArriba = new Rectangle(600,0,ANCHURA,hueco );
       parteAbajo = new Rectangle(600, parteArriba.height + hueco, ANCHURA, 600-hueco- parteArriba.height);
       bocaAbajo = new Rectangle(598, parteArriba.height + hueco, ANCHURA+2, 50);
       bocaArriba = new Rectangle(598, parteArriba.height - 50, ANCHURA + 2, 50); 
    }
    
    
    
     
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillRect(parteArriba.x, parteArriba.y, parteArriba.width, parteArriba.height);
        gg.fillRect(parteAbajo.x, parteAbajo.y, parteAbajo.width, parteAbajo.height);
        gg.fillRect(bocaAbajo.x, bocaAbajo.y, bocaAbajo.width, bocaAbajo.height);
        gg.fillRect(bocaArriba.x, bocaArriba.y, bocaArriba.width, bocaArriba.height);
        
        gg.setColor(Color.LIGHT_GRAY);
        gg.fillRect(parteArriba.x + 1, parteArriba.y, 50, parteArriba.height);
        gg.fillRect(parteAbajo.x + 1, parteAbajo.y + bocaAbajo.height, 50, parteAbajo.height);
        gg.fillRect(bocaAbajo.x + 1, bocaAbajo.y, 54, bocaAbajo.height);
        gg.fillRect(bocaArriba.x + 1, bocaArriba.y, 54, bocaArriba.height);
        
        gg.setColor(Color.DARK_GRAY);
        gg.fillRect(parteArriba.x + parteArriba.width - 40, parteArriba.y, 25, parteArriba.height- bocaAbajo.height);
        gg.fillRect(parteAbajo.x + parteAbajo.width - 40 , parteAbajo.y + bocaAbajo.height, 25, parteAbajo.height);
        gg.fillRect(bocaAbajo.x  + bocaAbajo.width - 41, bocaAbajo.y, 25, bocaAbajo.height);
        gg.fillRect(bocaArriba.x  + bocaArriba.width - 41, bocaArriba.y, 25, bocaArriba.height);
        
        gg.setColor(Color.WHITE);
        gg.drawLine(parteArriba.x +3, parteArriba.y, parteArriba.x + 3, parteArriba.y + parteArriba.height- bocaArriba.height);
        gg.drawLine(bocaArriba.x +3, bocaArriba.y, bocaArriba.x +3, bocaArriba.y + bocaArriba.height);
        gg.drawLine(parteAbajo.x +3, parteAbajo.y + bocaAbajo.height, parteAbajo.x + 3, parteAbajo.y + parteAbajo.height + bocaAbajo.height);
        gg.drawLine(bocaAbajo.x +3, bocaAbajo.y, bocaAbajo.x +3, bocaAbajo.y + bocaAbajo.height);
        
        gg.setColor(Color.BLACK);
        gg.drawRect(bocaAbajo.x, bocaAbajo.y, bocaAbajo.width, bocaAbajo.height);
        gg.drawRect(bocaArriba.x, bocaArriba.y, bocaArriba.width, bocaArriba.height);
    }
    
    public void update(){
       parteAbajo.x = parteArriba.x += velX;
       bocaArriba.x = bocaAbajo.x += velX;
        
    }
}