/*
Un programa para que el camarero lleve la comanda.
Tendremos cuatro listas, instanciadas 3, y una cuarta visible 
que se modificara dependiendo de un objeto de la clase choice que seleccionemos en la parte izqierda.
 */
package ejercicio010;

import java.awt.Choice;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;



public class Restaurante extends Frame {
    String[] comidas = {"Desayuno", "Comida", "Cena"};
    String[][] platos = {{"Leche", "Café", "Huevos", "Tostadas", "Mermelada", "Bacon"},
                         {"Paella", "Sopa", "Macarrones", "Ensalada", "Filete", "Pescado", "Albóndigas"},
                         {"Tortilla", "Sopa", "Hamburguesa", "Ensalada", "Pollo", "Bocadillo", "Sandía"}};
    List presentar;//la lista visible
    List listaPlatos[];
    Choice horario;
    TextField texto;
    
    public static void main(String arg[]) {
        Restaurante App = new Restaurante();    
    }

    
    public Restaurante(){
        super("Comanda");
         setup();

         this.pack();
         this.setSize(275, 275);
         this.setVisible(true);
    }    
    public void setup(){
        this.add("North", new Label("Elige tu comanda", Label.CENTER));
        listaPlatos = new List[3];
        
        horario = new Choice();
        for(int i = 0; i < comidas.length; i++)
            horario.addItem(comidas[i]);
        this.add("West", horario);
        
        for(int i = 0; i < listaPlatos.length; i++){
            listaPlatos[i] = new List(5, true);// elementos visibles y selección múltiple
            for(int j = 0; j < platos[i].length; j++)
                listaPlatos[i].add(platos[i][j]);
        }
        
        presentar = listaPlatos[0];
        this.add("East", presentar);
        
        texto = new TextField("", 40);//Un string y la longitud
        this.add("South", texto);
        
        
        
        
    }
    
    
    public boolean handleEvent(Event ev) {
        if (ev.id == Event.WINDOW_DESTROY) {
            System.exit(0);
            return true;
        }
        else if(ev.id == Event.ACTION_EVENT){
            if(ev.target instanceof Choice){
                this.remove(presentar);
                presentar = listaPlatos[horario.getSelectedIndex()];
                this.add("East", presentar);
                texto.setText(horario.getSelectedItem() + ": ");
                this.setVisible(true);//con esto es suficiente, no hace falta el pack ni el tamaño
               
                return true;
            }
        }
        if((ev.id == Event.LIST_SELECT)||(ev.id == Event.LIST_DESELECT)){
            String seleccionados[] = presentar.getSelectedItems();
            String frase = horario.getSelectedItem() + ": ";
            for (int i = 0; i < seleccionados.length; i++)
                frase += seleccionados[i] + " ";
            texto.setText(frase);
            }
            
       return false; 
        }
         
    
    
}


