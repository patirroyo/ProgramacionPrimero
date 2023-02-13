/*
Tenemos un proceso que funciona en orden secuencial, un ciclo de vida.
Hay clases que tienen un ciclo de vida, es decir, que hacen cosas.
Por otra parte, herencia: una subclase es mejor porque tiene más cosas.
Queremos crear un objeto de la clase ventana; clase frame
Cuando creamos una subclase de la clase frame, creamos una clase frame y luego
la adaptamos; es mejor porque es más específica.
Le vamos a meter un botón y más cosas
 */
package ejercicio006;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;


public class OvaloApp extends Frame{//usamos la clase Frame, que es la que tiene las ventanas-
    Ovalo ovalo; //como queremos pintar un ovalo, tenemos que crearlo
    public static void main(String arg[]){//nada más ejecutar la clase, se ejecuta el metodo main y por tanto creamos una ventana (frame)
        OvaloApp app = new OvaloApp();
        
    }
    
    public OvaloApp(){
        super("Dibujando óvalos");//primero llamamos al método constructor de la superclase, construimos un frame
        ovalo = new Ovalo();//instanciamos un ovalo
        
        Button boton1 = new Button("Salir");
        /*Por defecto un objeto de la clase frame tiene una distribución (layout) de la clase
        border layout (zona North, South, East, West y Center), se modificaría con setLayout
        Si queremos añadir al frame un objeto, se lo metemos cno el método add*/
        Button boton2 = new Button("Nuevo Óvalo");
        Button boton3 = new Button("Inicializar Óvalo");
        Panel panel = new Panel();
        
        panel.add(boton1);//this.add metemos a this, al frame, a la ventana --> como tenemos dos, vamos a meterlo en el panel y luego el panel al this(frame)
        panel.add(boton2);
        panel.add(boton3);
        
        this.add("South", panel); //ahora si que metemos el panel al frame (this).
        
        this.setSize(800, 600); //resize
        this.setVisible(true);//show
    }
    
    public void paint(Graphics g){//forma parte del ciclo de vida, espera recibir un objeto de la clase graphics
        //ese objeto es el papel, lo que ve el usuario, lo que está dentro de la ventana.
        ovalo.paint(g);//dibujame el ovalo en el objeto g
    }
    
   //ahora vamos con los eventos, que se meteran en los meétodos, siempre van al más específico. 
    //primero vamos a programás el método de tratamiento de eventos más general.
    public boolean handleEvent(Event ev){//todos los metodos de tratamiento de eventos devuelven un boolean
        if(ev.id == Event.WINDOW_DESTROY){//los objetos de la clase event tienen atributos, si hay static puedes
            //acceder desde el nombre de la clase (Event), si son finales (constantes) están en mayúsculas
            //por lo que podemos usarlos
            System.exit(0);
            return true;
        }else if(ev.id == Event.ACTION_EVENT)//un evento de acción, es decir, hacer click en el botón
            if(ev.target instanceof Button)//instanceof sirve para comparar clases
                if(ev.arg.equals("Salir")){//Si el argumento, es decir, el texto es Salir
                    System.exit(0);
                    return true;
                }else if(ev.arg.equals("Nuevo Óvalo")){
                    ovalo = new Ovalo();//creamos un nuevo ovalo
                    repaint();//volver a pintar, borrar y volver a llamar a método paint.
                    return true;
                }else if(ev.arg.equals("Inicializar Óvalo")){
                    ovalo.inicializar();//llamamos a la función del método constructor que genera los aleatorios, para darle nuevos atributos.
                    repaint();
                    return true;
                }
        return false;
    }
}
