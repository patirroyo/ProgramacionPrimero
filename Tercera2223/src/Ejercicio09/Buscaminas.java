/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio09;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;

import java.awt.Panel;
import java.awt.TextField;


/**
 *
 * @author alberto
 */
public class Buscaminas extends Applet{
    public static final int DIM = 20;
    public static final int TOP = 100;
    public static final int SIZEX = Casilla.LADO*DIM;
    public static final int SIZEY = SIZEX + TOP;
    private Image imagen; 
    private Graphics noseve;
    private Image mina;
    private Image bandera;
    private Casilla[][] casillas;
    private int[] aleatorios;
    private int casillasVistas;
    private int minasPorEncontrar;
    private boolean win;
    private TextField minas;
    
    

    
    public void init(){
        this.setSize(SIZEX, SIZEY);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        mina = getImage(getCodeBase(), "Ejercicio09/Imagenes/mina.png");
        bandera = getImage(getCodeBase(), "Ejercicio09/Imagenes/bandera.png");
        
        
        setupPanels();
        

        newGame();
        
      
        
    }

    private void newGame() {
        win = false;
        crearCasillas();
        repartirMinas();
        contarMinasAlrededor();
        minas.setText(""+DIM);
    }

    private void setupPanels() throws HeadlessException {
        Panel panel = new Panel();
        Button boton1 = new Button("Reiniciar !");
        Label etiqueta = new Label("Minas Pendientes: ", Label.RIGHT);
        minas = new TextField(""+DIM, 10);
        minas.setEditable(false);
        panel.add(etiqueta);
        panel.add(minas);
        panel.add(boton1);
       
        this.setLayout(new BorderLayout());
        this.add("North", panel);
      
    }

    private void crearCasillas() {
        casillasVistas = 0;
        casillas = new Casilla[DIM][DIM];
        for(int i = 0; i < DIM; i++)
            for(int j = 0; j < DIM; j++)
                casillas[i][j] = new Casilla(j*Casilla.LADO, i*Casilla.LADO+TOP);
    }

    private void repartirMinas() {
        minasPorEncontrar = 0;
        aleatorios = obtenerAleatorios();
        for(int i = 0; i < aleatorios.length; i++){
            casillas[aleatorios[i]/DIM][aleatorios[i]%DIM].setMina(mina);
            minasPorEncontrar++;
        }
    }    
    public int[] obtenerAleatorios(){
        int resultados[] = new int[DIM];
        int vector[] = new int[DIM*DIM];
        for(int i=0; i<DIM*DIM; i++)
            vector[i] = i;
        
        for(int i=0; i<DIM; i++){
            int aleatorio = (int)(Math.random()*((DIM*DIM)-i));
            resultados[i]=vector[aleatorio];
            vector[aleatorio]=vector[(DIM*DIM)-i-1];
        }
        return resultados;
            
    }
    private void contarMinasAlrededor() {
        for(int i = 0; i < DIM; i++)
            for(int j = 0; j < DIM; j++){
                int alrededor = 0;
                for(int a = i-1; a <= i+1; a++){
                    for(int b = j-1; b <= j+1; b++){
                        if(a>=0 && b>=0 && a<DIM && b<DIM && casillas[a][b].isMina())
                            alrededor++;
                    }
                }
                casillas[i][j].setAlrededor(alrededor);
            }
    }
   
    
    public void paint(Graphics g){
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 0, WIDTH, HEIGHT);
        
        for(int i = 0; i < DIM; i++)
             for(int j = 0; j < DIM; j++){
                 casillas[i][j].paint(noseve, this);
                 
             }
        
        if(win){
            noseve.setColor(Color.WHITE);
            noseve.fillRect(0, 0, WIDTH, HEIGHT);
            noseve.setColor(Color.BLACK);
            noseve.drawString("Has ganado", SIZEX/2, SIZEY/2);
        }
        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
        
    }
    
   
    public boolean mouseDown(Event ev, int x, int y){
        for(int i = 0; i < DIM; i++)
            for(int j = 0; j < DIM; j++)
                if(casillas[i][j].contains(x,y)){
                    if(!ev.metaDown())
                        clickCasilla(i, j);
                    else{
                        casillas[i][j].setBandera(bandera);
                        if(casillas[i][j].isConBandera())
                            minasPorEncontrar--;
                        else
                            minasPorEncontrar++;
                        minas.setText(""+minasPorEncontrar);
                    }
                    repaint();
                }
        
        return false;
    } 

    public void clickCasilla(int i, int j){
        if(casillas[i][j].isTapada()){
            casillas[i][j].setDestapada();
            casillasVistas++;
            if(casillasVistas == DIM*DIM-DIM){
                win = true;
            } else if(casillas[i][j].getAlrededor()==0)
                for(int i2 = i-1; i2 <= i+1;i2++)
                    for(int j2 = j-1; j2 <= j+1; j2++)
                        if(i2>=0 && j2>=0 && i2<DIM && j2<DIM)
                            clickCasilla(i2, j2);
            }
    } 
    public boolean action(Event ev, Object obj){
        if(ev.target instanceof Button){
            newGame();
        repaint();
        
        }
        return false;
    }
}