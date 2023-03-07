
package examenAlbertoSaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class CuadradoInferior extends Rectangle{
    Color color;
    private static final int ANCHURA = 50;
    private static final int ALTURA = 50;
    private static final int Y = 500;
    private static int[] posX = {50, 150, 250, 350, 450};
 
    public CuadradoInferior(int x, Color color){
        super(posX[x], Y, ANCHURA, ALTURA);
        this.color = color;
    }
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillRect(x, y, width, height);
    }
}
