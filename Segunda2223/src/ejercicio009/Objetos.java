/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio009;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class Objetos extends Frame{
    TextArea textArea;//asiq eu desde cualquier metodo se puede acceder a el 
    public static void main(String args[]){
        Objetos App = new Objetos();    
}
    
public Objetos(){
    super("Objetos comunes");
     setup();
     
     this.pack();
     this.setSize(400, 400);
     this.setVisible(true);
}
public void setup(){
    Panel principal = new Panel();
    principal.setLayout( new GridLayout(3,3));
    Panel paneles [][]= new Panel[3][3];
    /*cada vez que se cree un panel le meteremos objetos 
        y luego se meteran al panel principal y se colocaran por filas y columnas luego el 
        panel principal se metra al frame*/

    for(int i =0; i<3; i++)
        for(int j=0; j<3; j++)
            paneles[i][j]= new Panel();//configuraremos uno a uno los paneles

    
    paneles[0][0].add(new Label("Campo de texto: "));
    paneles[0][0].add(new MiTextField("", 15));//TextField("",15));//espera recibir un string y un entero con la anchura del objeto 
    
    principal.add(paneles[0][0]);
    textArea= new TextArea( 5,10);
    textArea.setBackground(Color.yellow);
    paneles[0][1].add(textArea);
    principal.add(paneles[0][1]);
    
    paneles [0][2].add(new MiButton("Limpiar", textArea));
    /*dos parametros, el boton tendra que borrar el contenido
    del textarea 8sin terminar)*/
    principal.add(paneles[0][2]);
    
   // Choice eleccion = new Choice();
    /*la clase desplegable que nos permite seleccionar una de las opciones.
    El evento de acción es on Change (al cambiar) de una cosa seleccionada a la otra
    */
   // eleccion.add("Uno");
   // eleccion.add("Dos");
   
    String opciones[] = {"Si", "No", "Quizás"};
    paneles[1][0].add(new MiChoice(opciones,textArea));
    principal.add(paneles[1][0]);
    
    String deportes[] = {"Atletismo", "Baloncesto", "Tenis", "Esgrima", "Balonmano", "Patinaje"};
    paneles[1][1].add(new MiLista(deportes, textArea));
    principal.add(paneles[1][1]);

    paneles[1][2].add(new MiCanvas());
    principal.add(paneles[1][2]);
    
    String alimentos[] = {"Pera", "Manzana", "Plátano", "Fesa"};
    paneles[2][2].add(new MiCheckboxGroup(alimentos));
    principal.add(paneles[2][2]);
    
    this.add("Center", principal);
  
    }
 public boolean handleEvent(Event ev) {
/*como primer parametro sera un objeto de la clase event*/
        if (ev.id == Event.WINDOW_DESTROY) {//esto es para cerrar la ventana el id es un atributo
            System.exit(0);
            return true;
        }
        return false;
 }
}
class MiTextField extends TextField{
    public MiTextField(String valor, int tamano){
        super(valor,tamano);
    } 
    public boolean action(Event ev, Object obj){
        /*la clase object es la mayor clase de todas esto 
quiere decir que cualquer objeto pertenece a esta clase*/

        this.setText(this.getText().toUpperCase());
        return false;
    }
}
class MiButton extends Button{
    TextArea text; /*declaro un objeto de la clase TextArea como atributo 
    de la clase para jugar con el en todos los métodos de la clase
    como los objetos lo que hacen es almacenar una dirección de memoria
    un objeto pequeño puede manejar uno más grande*/
    public MiButton(String frontal, TextArea ta){
        super(frontal);
        text = ta;
    }
     public boolean action(Event ev, Object obj){
       text.setText(" ");
        return false;
     }
}
class MiChoice extends Choice{
    TextArea ta;
    public MiChoice(String[] opciones, TextArea ta){
        super();
        for (int i = 0; i < opciones.length; i++)
            this.add(opciones[i]);
        this.ta = ta;//como los dos se llaman igual, para evitar la ambiguiedad uso el this.
    }

    public boolean action(Event ev, Object obj){
        //ta.setText(obj.toString()); Funiciona pero Agustín no sabe porqué
        ta.setText(this.getSelectedItem());
        return false;
    }
}

class MiLista extends List{
    TextArea texto;
    
    public MiLista(String [] opciones, TextArea text){
        super(5, true);//recibe dos parámetros, el primero el número de filas que se vean (altura) y el segundo un boolean, que si es true permite selección múltiple
        for(int i = 0; i < opciones.length; i++)
            this.add(opciones[i]);
        texto = text;
    }
    public boolean handleEvent(Event ev){//como tiene diferentes tipos de eventos, hay que poner un método más general
        //Event.LIST_SELECT;
        //Event.LIST_DESELECT;
        if((ev.id == Event.LIST_SELECT)||(ev.id == Event.LIST_DESELECT)){
            String seleccionados[] = this.getSelectedItems();
            String frase = "";
            for (int i = 0; i < seleccionados.length; i++)
                frase += seleccionados[i] + "\n";
            texto.setText(frase);
            return true;
            }
        
        return false;
    }    
}
/*La clase Canvas es una clase que muestra una ventana, que se puede colocar
    en cualquier sitio.
    Es como un frame que dentro tiene un objeto graphics sobre el que puedes dibujar.
    También tiene un método paint, para dibujar en el objeto graphics, que recibe
    el objeto graphics del Canvas. 
    */
class MiCanvas extends Canvas{
    int posX = 25;//declaro las posiciones como atributos de clase para poder modificarlos cuando haga click.
    int posY = 25;
    public MiCanvas(){//método constructor
        super();//no espera recibir ningún parámetro, hemos creado un objeto, para llamarlo "this."
        this.setSize(75, 75);
        this.setBackground(Color.GREEN);//para verlo y que se diferencie
        this.setForeground(Color.red);
        this.setVisible(true);//para que se muestre
    }
    public void paint(Graphics g){
        g.fillRect(posX, posY, 5, 5);   
    }
    public boolean mouseDown(Event ev, int x, int y){
        posX = x;
        posY = y;
        this.repaint();
        return true;
    }
}
/* Un Checkbox es un input que puedes marcar o desmarcar y tiene asociado
un String, su método constructor espera recibir un objeto de la clase String
*/
class MiCheckboxGroup extends Panel{
    public TextField resultado;
    Checkbox checkboxes[];
   
    public MiCheckboxGroup(String alimentos[]){
        super();//metodo constructor de la clase Panel
        checkboxes = new Checkbox[alimentos.length];//declaramos un vector de checkboxes con los elementos 
        this.setLayout(new GridLayout(alimentos.length + 1, 1));
        for(int i = 0; i < alimentos.length; i++){
            checkboxes[i] = new Checkbox(alimentos[i]);
            this.add(checkboxes[i]);
        }
        resultado = new TextField(" ", 15);
        this.add(resultado);
        
    }
    public boolean handleEvent(Event ev){//esta clase es un panel por lo que tenemos que usar un método de tratamientos de eventos general
       if(ev.id == Event.ACTION_EVENT){
           if(ev.target instanceof Checkbox) {
                String seleccionados = "";
                for(int i = 0; i < checkboxes.length; i++)
                    if(checkboxes[i].getState())
                        seleccionados += checkboxes[i].getLabel() + ", ";
                resultado.setText(seleccionados);
           return true;
           }
       }
       return false;
    }
        
       
       
    
}