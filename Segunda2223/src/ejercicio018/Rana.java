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
//si pongo el static puedo acceder a él a través del nombre de la clase
    public static final int ALTURA = 35;
    public static final Color color = Color.GREEN;
    int contadorAnimacion = 0;
    int contador = 0;
    static final int IZQUIERDA = 1006;
    static final int DERECHA = 1007;
    static final int ARRIBA = 1004;
    static final int ABAJO = 1005;
    int posX;
   
    
    public Rana(){
        super(280, 550,0, 0);
        this.width = ANCHURA;
        this.height = ALTURA;
        vida = 1;
      
    }   
    

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
     
    public void paint(Graphics gg){
        if(vida > 0){ 
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
        }else{
            gg.setColor(color);
            gg.fillRect(x-2, y+height/2, width/3, height/2);
            gg.fillRect(x+width*7/8-7, y+height/2, width/3, height/2);
            gg.setColor(Color.BLACK);
            gg.drawRect(x-2, y+height/2, width/3, height/2);
            gg.drawRect(x+width*7/8-7, y+height/2, width/3, height/2);
            gg.setColor(color);
            gg.fillRect(x+5, y, width-12, height);
            gg.setColor(Color.BLACK);
            gg.drawRect(x+5, y, width-12, height);
            gg.setColor(Color.WHITE);
            gg.fillRect(x+4, y+4, 10, 15);
            gg.fillRect(x+25, y+4, 10, 15);
            gg.setColor(Color.BLACK);
            gg.fillRect(x+7, y+7, 5, 7);
            gg.fillRect(x+27, y+7, 5, 7);
            gg.drawRect(x+4, y+4, 10, 15);
            gg.drawRect(x+25, y+4, 10, 15);
            gg.setColor(Color.PINK);
            gg.fillRect(x-4 + width/2, y-10, 6, 14);
            gg.setColor(Color.BLACK);
            gg.drawRect(x-4 + width/2, y-10, 6, 14);
            gg.setColor(Color.DARK_GRAY);
            gg.fillRect(x-10, y+7, width+20, 7);
            gg.fillRect(x-10, y+21, width+20, 7);
        }
     
        
    }
    
    
    public void update(){
        if(vida > 0){
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
    }
    public void update(int tecla){
        if(vida > 0 && y < 600){
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
                    if (y >= 600)
                        y = 599;
            }
        }
       
    }
}