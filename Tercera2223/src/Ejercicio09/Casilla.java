/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio09;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author alberto
 */
public class Casilla extends Rectangle {
    public static final int LADO = 30;
    private Image mina;
    private Boolean tapada;
    private int alrededor;
    private Boolean conBandera;
    private Image bandera;
    
    public Casilla(int posX, int posY){
        super(posX, posY, LADO, LADO);
        tapada = true;
        conBandera = false;
        alrededor = 0;
    }
    
    public void paint(Graphics gg, Applet ap){
        if(mina != null&&!tapada){
            gg.drawImage(mina, x, y, width, height, ap);
        }
        else{
            gg.setColor(Color.LIGHT_GRAY);
            gg.fill3DRect(x, y, width, height, tapada);
            switch(alrededor){
                case 0:
                    gg.setColor(Color.BLACK);
                    break;
                case 1:
                    gg.setColor(Color.CYAN);
                    break;
                case 2:
                    gg.setColor(Color.GREEN);
                    break;
                case 3:
                    gg.setColor(Color.RED);
                    break;
                case 4:
                    gg.setColor(Color.BLUE);
                    break;
                case 5:
                    gg.setColor(Color.PINK);
                    break;
                case 6:
                    gg.setColor(Color.ORANGE);
                    break;
                case 7:
                    gg.setColor(Color.MAGENTA);
                    break;
                case 8:
                    gg.setColor(Color.BLACK);
                    
                 
            }
            
            gg.setFont(new Font("Arial", Font.PLAIN, 20));
            gg.drawString((alrededor==0||tapada)?"":"" + alrededor, x+10, y+22);
            if(conBandera)
                gg.drawImage(bandera, x, y, width, height, ap);
        }
            
        
    }

    public Boolean isTapada() {
        return tapada;
    }

    public void setDestapada() {
        this.tapada = false;
    }
    public void setBandera(Image imagen) {
        bandera = imagen;
        if(conBandera)
            conBandera = false;
        else
            conBandera = true;
    }
    public void setBandera(Boolean bandera) {
        conBandera = bandera;
        
    }

    public boolean isMina() {
        if(mina == null)
            return false;
        else
            return true;
    }

    public void setMina(Image imagen) {
        mina = imagen;
    }

    public int getAlrededor() {
        return alrededor;
    }

    public void setAlrededor(int alrededor) {
        this.alrededor = alrededor;
    }

    public Boolean isConBandera() {
        return conBandera;
    }
    
}