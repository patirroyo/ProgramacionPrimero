/*
Aplicación que modifica algunos atibutos de la ventana (frame)
 */
package ejercicio008;

import java.awt.Cursor;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;



public class FrameApp extends Frame{
    MenuBar porDefecto; //aquí se declaran los atributos de la clase
    MenuBar alternativo;
    String tituloInicial;//un atributo objeto para el nombre del título de la ventana
    String tituloAlternativo = "Titulo alternativo";
    int cursores[] = {Cursor.CROSSHAIR_CURSOR,Cursor.DEFAULT_CURSOR,Cursor.HAND_CURSOR,Cursor.MOVE_CURSOR,Cursor.WAIT_CURSOR};
    int indCursor = 0;
    Color colores[] = {Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GREEN,Color.MAGENTA};
    int indColores = 0;
    int indTexto = 0;
    String fuentes[] = {Font.DIALOG,"Helvetica","Calibri","Comic Sans","Courier"};
    int indFuente = 0;
    public static void main(String arg[]) {
        FrameApp app = new FrameApp();
        System.out.println("Crea un nuevo FrameApp de nombre app");
    }
    
    public FrameApp(){
        super("Propiedades del Frame");
        tituloInicial = this.getTitle();
        System.out.println("Llamamos al metodo constructor de la superclase");
        tituloInicial = this.getTitle();
        System.out.println("Cargamos el atributo tituloInicial con : " + "'" + tituloInicial + "'");
        setup();
        System.out.println("Llamamos al método setup()");
        
        this.pack();
        this.setSize(400, 400);
        this.setVisible(true);
        
    }
    public void paint(Graphics g) {
        g.drawString("Cambia el color al pulsar Foreground",100,150); //nos permite dibujar un string
        //espera recibir 3 parámetros: 1 el string, pos en el eje de las x y pos en el eje de las y
    }
    public void setup(){
        setupMenuBar();
        System.out.println("LLamamos al método setupMenuBar()");
        setupPaneles();
        System.out.println("LLamamos al método setupPaneles()");
    }
    
    public void setupPaneles(){
        Panel principal = new Panel();
        System.out.println("Instanciamos y creamos un objeto de la clase Panel con nombre 'principal'");
       
        principal.setLayout(new GridLayout(4, 1));
        System.out.println("Cambiamos el layout de principal a estilo 'greed'");
       
        principal.add(new Label("Cambian las características de la ventana", Label.CENTER));//añadimos una etiqueta en el centro
        System.out.println("Metemos una etiqueta para la primera fila");
        
        Panel panel1 = new Panel();
        System.out.println("Creo otro panel, llamado 'panel1' y lo instancio");
       
        panel1.add(new Button("MenuBar"));
        System.out.println("Creamos un boton llamado MenuBar y lo metemos en panel1");
       
        panel1.add(new Button("Titulo"));
        System.out.println("Creamos un boton llamado Titulo y lo metemos en panel1");
        
        panel1.add(new Button("Resizable"));//que nos permita cambiar el tamaño de la ventana, valor boolean
        System.out.println("Creamos un boton llamado Resizable y lo metemos en panel1");
        
          
        principal.add(panel1);
        System.out.println("Añadimos panel1 al panel principal");
        
        principal.add(new Label("Salidas en la ventana", Label.CENTER));
        System.out.println("Metemos una etiqueta para la primera fila");
        
        Panel panel2 = new Panel();
        System.out.println("Creo otro panel, llamado 'panel2' y lo instancio");
        
        panel2.add(new Button("Cursor"));
        System.out.println("Creamos un boton llamado Cursor y lo metemos en panel2");
        panel2.add(new Button("Color de Fondo"));
        panel2.add(new Button("Color de Texto"));
        panel2.add(new Button("Tipo de fuente"));
        principal.add(panel2);
        
        this.add("South", principal);
        System.out.println("Metemos el panel 'principal' en la parte South");
      
    }
    
    public void setupMenuBar(){
       porDefecto = new MenuBar();
       Menu fileMenu = new Menu("File");
       fileMenu.add(new MenuItem("Exit"));
       porDefecto.add(fileMenu);
       this.setMenuBar(porDefecto);
       alternativo = new MenuBar();
       Menu fileMenu2 = new Menu("Archivo");
       fileMenu2.add(new MenuItem("Salir"));
       alternativo.add(fileMenu2);
    
    }
    
    
      public boolean handleEvent(Event ev){//todos los metodos de tratamiento de eventos devuelven un boolean
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(ev.id == Event.ACTION_EVENT){//un evento de acción, es decir, hacer click en el botón
            if(ev.target instanceof Button){//instanceof sirve para comparar clases
                if(ev.arg.equals("MenuBar")){//Si el argumento, es decir, el texto es Salir
                     System.out.println("Se ha hecho click en el botón 'MenuBar'");
                     if(this.getMenuBar()== porDefecto){
                         this.setMenuBar(alternativo);
                         System.out.println("Cambiado el MenuBar a alternativo");
                     }else{
                         this.setMenuBar(porDefecto);
                         System.out.println("Cambiado el MenuBar a porDefecto");
                     }return true;
                }else if(ev.arg.equals("Titulo")){//Si el argumento, es decir, el texto es Titulo
                     System.out.println("Se ha hecho click en el botón 'Titulo'");
                     if(this.getTitle().equals(tituloInicial)){
                         this.setTitle(tituloAlternativo);
                         System.out.println("Cambiado el titulo a tituloAlternativo");
                     }else{
                         this.setTitle(tituloInicial);
                         System.out.println("Cambiado el titulo a tituloInicial");
                     }return true;
                }else if(ev.arg.equals("Resizable")){//Si el argumento, es decir, el texto es Resizable
                     System.out.println("Se ha hecho click en el botón 'Resizable'");
                     if(this.isResizable())
                         this.setResizable(false);
                     else
                         this.setResizable(true);
                     System.out.println("Cambiado el valor resizable a " + this.isResizable());
                     return true;
                }
                else if(ev.arg.equals("Cursor")){
                    this.setCursor(cursores[indCursor]);
                    indCursor = (indCursor+1) %cursores.length;//el resto sirve para no salirnos del array
                return true;
                }
                else if(ev.arg.equals("Color de Fondo")){
                    this.setBackground(colores[indColores]);
                    indColores = (indColores+1) %colores.length;
                return true;
                }
                else if(ev.arg.equals("Color de Texto")){
                    this.setForeground(colores[indTexto]);
                    indTexto = (indTexto+1) %colores.length;
                return true;
                }
                else if(ev.arg.equals("Tipo de fuente")){
                    this.setFont(new Font(fuentes[indFuente],Font.ITALIC,15));//creamos un objeto de la clase font cada vez que hacemos clic
                    //el método constructor de la clase font espera recibir 3 parámetros
                    //1 string con el tipo de letra, este lo tenemos en el array de las fuentes
                    //2 indicamos dentro de Font que característica queremos, bold, italic,etc
                    //3 espera recibir un entero con el tamaño de la fuente
                    indFuente = (indFuente+1) %fuentes.length;
                    //en la clase font los objetos tienen 4 propiedades
                return true;
                }
            }
        }
        return false;
    }
    
}
