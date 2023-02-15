/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio017;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Nave extends Rectangle {
    Color color;
    int vida;
    public static final int ANCHURA = 38;
    public static final int ALTURA = 20;
    public static final Color COLORES []= {Color.DARK_GRAY, Color.LIGHT_GRAY, Color.WHITE};
    int posicionX[] = {50, 100, 150, 200, 250, 300, 350, 400, 450, 500, 550};
    int randomX = (int)(Math.random()*posicionX.length);
    int contadorAnimacion = 0;
    int contador = 0;
    static int IZQUIERDA = -1;
    static int DERECHA = 1;
    int posX;
   
    
    public Nave(){
        super(0,2,0, 0);
        this.x = posicionX[randomX];
        this.width = ANCHURA;
        this.height = ALTURA;
        vida = 2;
        this.color = COLORES[vida];
        posX = randomX;
    }   
    
     public Nave(int x, int y){
        super(0,0,0, 0);
        this.x = posicionX[x];
        this.y = y * 2 * ALTURA;
        this.width = ANCHURA;
        this.height = ALTURA;
        vida = 2;
        this.color = COLORES[vida];
        posX = x;
    }  

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
     
    public void paint(Graphics gg){
        gg.setColor(COLORES[vida]);
        gg.fillRect(x, y, width, height);
        gg.setColor(Color.DARK_GRAY);
        gg.drawRect(x, y, width, height);
    }
    
    public void update(){
       contador++;
       contadorAnimacion++;
       if(contadorAnimacion%100 == 50)
           x += 3;
       if(contadorAnimacion%100 == 0){
           x -= 3;
           contadorAnimacion = 0;
       }
       if(contador%600 == 0){
           y += 20;
           contador = 0;
       }
       
       if((int)(Math.random()*10000) == 0){
           if(posX < posicionX.length -1) 
               posX++;
           x = posicionX[posX]; 
       }
       if((int)(Math.random()*10000) == 1){
           if(posX > 0)
                posX--;
           x = posicionX[posX];  
       }
    }
}