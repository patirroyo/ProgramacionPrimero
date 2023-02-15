package ejercicio017;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Bomba extends Rectangle {
    Color color = Color.WHITE;
    public static final int RADIO = 5;

    
  
    public Bomba(int x, int y){
        super(x, y, 0, 0);
        this.height = RADIO;
        this.width = RADIO;    
    }

    public void setY(int y) {
        this.y = y;
    }
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillRect(x, y, width, height);
        gg.drawRect(x, y, width, height);
    }
    public void update(){
        y++;
    }
}