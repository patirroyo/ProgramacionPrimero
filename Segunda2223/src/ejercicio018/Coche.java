/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Coche extends Rectangle{
    int posicionesY[] = {100, 162, 228, 366, 428, 487};
    Color [] colores = {Color.BLUE, Color.CYAN, Color.GREEN, 
                        Color.YELLOW, Color.RED, Color.ORANGE, 
                        Color.WHITE, Color.YELLOW};
    Color color;
    int velX;
    private int posY;

  
    
    public Coche(int y){
       super(((int)(Math.random()*150))+600, 0, 50, 30);
       this.y = posicionesY[y];
       if(y > 2)
           this.x = 0-((int)(Math.random()*100))-this.width;
       posY = y;
       color = colores[(int)(Math.random()*colores.length)];
       velX = (int)(Math.random()*4)+1;
    }
    
    public void paint(Graphics gg){
        gg.setColor(Color.BLACK);
        gg.fillRoundRect(x+5, y-3, 10, 5, 5, 5);
        gg.fillRoundRect(x+width-15, y-3, 10, 5, 5, 5);
        gg.fillRoundRect(x+5, y+height-2, 10, 5, 5, 5);
        gg.fillRoundRect(x+width-15, y+height-2, 10, 5, 5, 5);
        gg.setColor(color);
        gg.fill3DRect(x, y, width, height, true);
        gg.setColor(Color.CYAN);
        gg.fillRect(x+2, y +1, 13, height-4);
        gg.fillRect(x+width-15, y +1, 13, height-4);
        gg.setColor(Color.BLACK);
        gg.drawRect(x+2, y +1, 13, height-4);
        gg.drawRect(x+width-15, y +1, 13, height-4);
        
    }
    public void update(){
      if(y > 300)
          x += velX;
      else
          x -= velX;
    }
    public void cocheChocon(List<Coche> coches){
      for(Coche co: coches){
          if(this.intersects(co) && !this.equals(co)){
              //esto es para que no se compare consigomismo.
                if(this.y < 300)
                    this.x = co.x + co.width + 1;
                else
                    this.x = co.x - co.width - 1;
                co.velX = this.velX;
          }
      }
              
        
        
            
        
    }
      public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
