/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio09;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
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
    public static final int DIM = 25;
    public static final int TOP = 100;
    public static final int SIZEX = Casilla.LADO*DIM;
    public static final int SIZEY = SIZEX + TOP;
    public static final int TAMCARA = 40;
    private Image imagen; 
    private Graphics noseve;
    private Image mina;
    private Image bandera;
    private Image carita;
    private Casilla[][] casillas;
    private int[] aleatorios;
    private int casillasVistas;
    private int minasPorEncontrar;
    private boolean win;
    private boolean gameOver;
    private TextField minas;
    public static final int NUMEROMINAS = DIM*5;
    private Panel panel;
    private Carita cara;
    private Label etiqueta;
    
    

    
    public void init(){
        this.setSize(SIZEX, SIZEY);
       
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics(); 
        
        mina = getImage(getCodeBase(), "Ejercicio09/Imagenes/mina.png");
        bandera = getImage(getCodeBase(), "Ejercicio09/Imagenes/bandera.png");
        carita = getImage(getCodeBase(), "Ejercicio09/Imagenes/carita.png");
        
        newGame();
        
      
        
    }

    private void newGame() {
        setupPanels();
        win = false;
        gameOver = false;
        crearCasillas();
        repartirMinas();
        contarMinasAlrededor();
        minas.setText(""+NUMEROMINAS);
        cara = new Carita(carita);
        repaint();
        
    }

    private void setupPanels() throws HeadlessException {
        panel = new Panel();
        etiqueta = new Label("Minas: ", Label.RIGHT);
        minas = new TextField(""+DIM, 10);
        minas.setEditable(false);
        panel.add(etiqueta);
        panel.add(minas);
       
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
        int resultados[] = new int[NUMEROMINAS];
        int vector[] = new int[DIM*DIM];
        for(int i=0; i<DIM*DIM; i++)
            vector[i] = i;
        
        for(int i=0; i<resultados.length; i++){
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
        noseve.setColor(new Color(240,240,240));
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        
        for(int i = 0; i < DIM; i++)
             for(int j = 0; j < DIM; j++){
                 casillas[i][j].paint(noseve, this);
                 
             }
        
        if(win||gameOver){
            
            noseve.setColor(Color.WHITE);
            noseve.fillRect(0, 0, WIDTH, HEIGHT);
            noseve.setColor(Color.BLACK);
        }
        
        cara.paint(noseve, this);
        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
        
    }
    
   
    public boolean mouseDown(Event ev, int x, int y){
        if(cara.contains(x,y)){
            cara.setClick();
            repaint();
        }
         if(gameOver || win)
            return false;
        for(int i = 0; i < DIM; i++)
            for(int j = 0; j < DIM; j++)
                if(casillas[i][j].contains(x,y)){
                    if(!ev.metaDown()){
                        if(!casillas[i][j].isConBandera())
                            clickCasilla(i, j);
                    }
                    else if(casillas[i][j].isTapada()){
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
            if(casillas[i][j].isMina())
                gameOver();
            else
                casillasVistas++;
            if(casillasVistas == DIM*DIM-NUMEROMINAS){
                win();
            } else if(casillas[i][j].getAlrededor()==0)
                for(int i2 = i-1; i2 <= i+1;i2++)
                    for(int j2 = j-1; j2 <= j+1; j2++)
                        if(i2>=0 && j2>=0 && i2<DIM && j2<DIM)
                            clickCasilla(i2, j2);
            }
    }

    private void win() {
        win = true;
    }
    
    public void gameOver(){
        gameOver = true;
        for(int i = 0; i < DIM; i++)
            for(int j = 0; j < DIM; j++)
                if(casillas[i][j].isMina())
                    casillas[i][j].setDestapada();
    }
    public boolean mouseUp(Event ev,int x, int y){
        if(cara.contains(x,y)){
            newGame();
        repaint();
        
        }
        return false;
    }
}