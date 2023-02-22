/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio019;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author alber
 */
public class Raqueta extends Rectangle {
    private Color color;
    private int velY;
    private int numero;
    
    public Raqueta(int numero){
        super(20,250,10,100);
        color = Color.YELLOW;
        velY = 30;
        this.numero = numero;
        if(numero == 2){
            this.x = 780 - this.width;
            this.color = Color.BLUE;
        }
    }
    

    
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillRect(x, y, width, height);
        if(numero == 2)
            gg.setColor(Color.WHITE);
        else
            gg.setColor(Color.BLACK);
        gg.drawRect(x, y, width, height);   
    }
    public void update(int direccion){
        y += (velY * direccion);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}
