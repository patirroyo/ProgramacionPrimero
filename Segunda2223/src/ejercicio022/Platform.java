
package ejercicio022;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Platform extends Rectangle {
    Color [] colores = {Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.RED};;
    private int velY = 1;
    Color color;
    private int anchura = (int)(Math.random()*100) + 100;
    private static final int ALTURA = 20;
   

public Platform(){
        super(0,0,0,ALTURA);
        x = (int)(Math.random()*(600-anchura));
        width = anchura;
        color = colores[(int)(Math.random() * colores.length)];
    }
public Platform(int x, int y, int anchura){
        super(x,y,anchura,ALTURA);
        color = colores[0];
    }
public void paint(Graphics g){
    g.setColor(color);
    g.fill3DRect(x, y, width, height, true);
}
public void update(){
    this.y += velY;
}
}
