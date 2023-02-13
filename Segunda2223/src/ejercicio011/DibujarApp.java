/*
 Tendremos un deplegable en el que seleccionaremos lo que queramos dibujar:
círculo, línea, rectángulo...
 */
package ejercicio011;


import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
//import java.util.List;//la podemos importar así 

public class DibujarApp extends Frame{  
    public int tipo;
    DosPuntos actual;//creamos un objeto de la clase DosPuntos
    java.util.List<DosPuntos> lista;//Creamos la lista con objetos de la clase DosPuntos por eso entre <>. 
    //Así podemos crear el objeto sin importar la clase.
    int contador;
    public static void main(String arg[]) {
        DibujarApp app = new DibujarApp();    
        
    }
    
    public DibujarApp(){
        super("Dibujando objetos");
        
        setupMenuBar();
        tipo = DosPuntos.LINEA;
        
        lista = new java.util.ArrayList<DosPuntos>();//como List es abstracta hay que instanciar un objeto de la clase ArrayList, que es la misma pero sin ser abstracta.
        this.pack();
        this.setSize(400, 400);
        this.setVisible(true);
       
    } 
    
    public void setupMenuBar(){
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Fichero");
        menu1.add(new MenuItem("Nuevo"));
        menu1.addSeparator();
        menu1.add(new MenuItem("Salir"));
        menuBar.add(menu1);
        Menu menu2 = new Menu("Dibujar");
        menu2.add(new MenuItem("Linea"));
        menu2.add(new MenuItem("Óvalo"));
        menu2.add(new MenuItem("Rectángulo"));
        menuBar.add(menu2);
        this.setMenuBar(menuBar);
        
    }
    
    public void paint(Graphics g){
        // for (int i = 0; i < lista.size(); i++)
         //   lista.get(i).paint(g);//accedo al elemento de la lista en la posición i
        
        for(DosPuntos item : lista){//una instrucción for más una función each.
            item.paint(g);
            
        }    /*la lista tiene un puntero interno que apunta a uno de los elementos de la lista
                inicialmente apunta al primero.
                La función each por si sola, coge un elemento de la lista, el elemento que está siendo
                apuntado, lo devuelve y además pasa el puntero a la siguiente posición
                x = each(lista)
                */
         
        if(actual != null)
            actual.paint(g);//llamamos al método que tenemos para dibujar un objeto de la clase DosPuntos, */
                                                                //da error porque no hemos instanciado actual todavía.
        
      
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        actual = new DosPuntos(x, y, tipo);
       
        repaint();//este método llama al método update() y luego vuelve a llamar al metodo paint.
        contador = 0;
        return true;
    }
     /*cada vez que hacemos click, se crea un objeto de la clase DosPuntos,
        lo ideal sería tener un vector de tamaño ilimitado para poder guardarlos
        todos.
        Bien!! existe una clase llamada List que es como un vector con objetos ilimitados.
        Por lo que tendremos que crear objetos de la clase list. Y la utilizamos 
        mediante sus métodos y atributos. Tiene un método para meter objetos (add), otro para
        sacarlos, otro para acceder a ellos, otro para saber cuántos hay (count)
        */
    
    public boolean mouseUp(Event ev, int x, int y){
        lista.add(actual);//añadimos el objeto a la lista
        actual = null;
        repaint();
        
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){//cuando haces click y sin soltar, mueves
        actual.setPosFinX(x);
        actual.setPosFinY(y);
        repaint();
        System.out.println(contador);
        contador++;
        return true;
    }
   
    
    public boolean action(Event ev, Object obj) {
        if(ev.target instanceof MenuItem){//instanceof sirve para comparar clases
          if(ev.arg.equals("Salir")){//Si el argumento, es decir, el texto es Salir
              System.exit(0);
              return true;
          }
          if(ev.arg.equals("Linea")){
              tipo = DosPuntos.LINEA;
              return true;
          }
          if(ev.arg.equals("Óvalo")){
              tipo = DosPuntos.OVALO;
              return true;
          }
          if(ev.arg.equals("Rectángulo")){
              tipo = DosPuntos.RECTANGULO;
              return true;
          }
        }
        return false;
    }
}
