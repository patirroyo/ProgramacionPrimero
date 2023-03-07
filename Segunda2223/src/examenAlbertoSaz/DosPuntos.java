
package examenAlbertoSaz;

import java.awt.Color;
import java.awt.Graphics;


public class DosPuntos {
    private int posIniX, posIniY, posFinX, posFinY;
    private Color color;
    CuadradoMovil acierto;
    
    public DosPuntos(int px1, int py1, int px2, int py2, Color color){
        posIniX = px1;
        posIniY = py1;
        posFinX = px2;
        posFinY = py2;
        this.color = color;
  
    }
    public DosPuntos(int px1, int py1, Color color){
        this(px1, py1, px1, py1, color);
    }
    public DosPuntos(int px1, int py1, CuadradoMovil acierto){
        this(px1, py1, acierto.x, acierto.y, acierto.color);
        this.acierto = acierto;
    }

    public int getPosIniX() {
        return posIniX;
    }
    public void setPosIniX(int posIniX) {
        this.posIniX = posIniX;
    }
    public int getPosIniY() {
        return posIniY;
    }
    public void setPosIniY(int posIniY) {
        this.posIniY = posIniY;
    }
    public int getPosFinX() {
        return posFinX;
    }
    public void setPosFinX(int posFinX) {
        this.posFinX = posFinX;
    }
    public int getPosFinY() {
        return posFinY;
    }
    public void setPosFinY(int posFinY) {
        this.posFinY = posFinY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
     
    public void paint(Graphics g){
        g.setColor(color);
        g.drawLine(posIniX, posIniY, posFinX, posFinY);
       
            
    }
    public void update(){
        if(acierto != null){
            posFinX = acierto.x;
            posFinY = acierto.y;
        }
    
    }
}
