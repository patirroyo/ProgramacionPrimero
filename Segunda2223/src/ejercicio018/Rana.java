/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Rana extends Rectangle{
    int vida;
    public static final int ANCHURA = 40;
    public static final int ALTURA = 35;
    public static final Color color = Color.GREEN;
    int contadorAnimacion = 0;
    int contador = 0;
    static final int IZQUIERDA = -1;
    static final int DERECHA = 1;
    static final int ARRIBA = 2;
    static final int ABAJO = 0;
    int posX;
   
    
    public Rana(){
        super(280, 550,0, 0);
        this.width = ANCHURA;
        this.height = ALTURA;
        vida = 2;
      
    }   
    

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
     
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillOval(x-2, y+height/2, width/3, height/2);
        gg.fillOval(x+width*7/8-7, y+height/2, width/3, height/2);
        gg.setColor(Color.BLACK);
        gg.drawOval(x-2, y+height/2, width/3, height/2);
        gg.drawOval(x+width*7/8-7, y+height/2, width/3, height/2);
        gg.setColor(color);
        gg.fillOval(x+5, y, width-12, height);
        gg.setColor(Color.BLACK);
        gg.drawOval(x+5, y, width-12, height);
        gg.setColor(Color.WHITE);
        gg.fillOval(x+4, y+4, 10, 15);
        gg.fillOval(x+25, y+4, 10, 15);
        gg.setColor(Color.BLACK);
        gg.fillOval(x+7, y+7, 5, 7);
        gg.fillOval(x+27, y+7, 5, 7);
        gg.drawOval(x+4, y+4, 10, 15);
        gg.drawOval(x+25, y+4, 10, 15);
        gg.drawOval(x-4 + width/2, y, 6, 4);
        gg.setColor(Color.PINK);
        gg.fillOval(x-4 + width/2, y, 6, 4);
     
        
    }
    
    
    public void update(){
       contador++;
       contadorAnimacion++;
       switch(contadorAnimacion){
            case 50:
                x += 2;
                y -= 2;
                break;
            case 100:
                x -= 2;
                y += 2;
                break;
            case 150:
                x -= 2;
                y -= 2;
                break;
            case 200:
                x += 2;
                y += 2;
                break;
            case 250:
                y += 2;
                break;
            case 300:
                y -=2;
                contadorAnimacion = 0;
       }
    }
    public void update(int tecla){
        switch(tecla){
            case IZQUIERDA: 
                x -= 20;
                break;
            case DERECHA: 
                x += 20;
                break;
            case ARRIBA: 
                y -= 20;
                break;
            case ABAJO:
                y += 20;
        }
       
    }
}