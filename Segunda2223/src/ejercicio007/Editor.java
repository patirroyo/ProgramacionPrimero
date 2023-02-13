/*
Vamos a crera un editor de textos, cogemos un archivo, lo abrimos dentro del frame
donde se permitirá modificar y guardar. Vamos a trabajar con ficheros del HD y
a crear opciones de menú. "Y veremos que está chupao"
También vamos a crear cuadros de diálogo.
 */
package ejercicio007;

import java.awt.Button;
import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.io.*; //de esta manera importo el paquete entero input output

public class Editor extends Frame { //volvemos a la carga con las ventanas.
    TextArea texto;//declaramos el objeto de la clase TextArea, es un input más grande donde puedes escribir muchas cosas.
    MenuBar menuBar;   // declaramos el objeto para poder tratarlo, ahora es un atributo de la clase
    FileDialog abrirFichero;//declaramos un objeto que nos permitirá manejar un cuadro de diálogo para abrir
    FileDialog guardarFichero;
    
    public static void main(String arg[]) {
        Editor app = new Editor();   
    }
  
    
    public Editor(){//método constructor
        super("Editor de textos"); //llamamos al método constructor de la superclase
        setup(); //crearemos un métood para configurar, para meterle lo que queramos.
        
        this.pack();//método de empaquetamiento para colocar las cosas en su sitio.
        this.setSize(texto.getMinimumSize());//indicamos tamaño, el mínimo que tiene el texto
        this.setVisible(true);//hacemos visible
    }
    public void setup(){
        texto = new TextArea(20, 50); //20 filas 50 columnas
        this.add("Center", texto);
        setupMenuBar();//llamamos a la función que levanta la barra de menús
        abrirFichero = new FileDialog(this, "Abrir fichero", FileDialog.LOAD); 
        /* Primero lo que hacemos es abrir un cuadro de diálgo, una vez creado en la
        clase, lo instanciamos llamándo a su método constructor, le decimos que lo 
        meta en this, en este frame, que se llame abrir fichero y el tercer parámetro
        es una CONSTANTE, es decir final y estático, un atributo de clase; queremos
        que nos abra un cuadro de diálogo de carga.
        Una vez instanciado, tendremos que programar el tratamiento del evento
        
        Ahora hacemos lo mismo para el de guardar
        */
        guardarFichero = new FileDialog(this, "Guardar fichero", FileDialog.SAVE);
    }
/*
    Un menú se divide en 3 partes:
        - MenuBar: (objeto de la clase MenuBar) define el menú en general, una barra de menú.
            *file (objeto file clase Menu)
                +new projet (objeto new projet clase MenuItem)
            *edit (objeto edit clase menu)
            *view
*/
    public void setupMenuBar(){
       menuBar = new MenuBar();
       Menu archivoMenu = new Menu("Archivo");
       archivoMenu.add(new MenuItem("Nuevo"));
       archivoMenu.add(new MenuItem("Abrir"));
       archivoMenu.addSeparator();//la barrita que separa
       archivoMenu.add(new MenuItem("Guardar"));
       archivoMenu.addSeparator();//la barrita que separa
       archivoMenu.add(new MenuItem("Salir"));
       menuBar.add(archivoMenu);
       this.setMenuBar(menuBar);
    }
    
    public void leerFichero(String nombre){/*hay dos clases que son capaces de abrir ficheros para lectura, las que tienen inputSream (file y data)
        Lo que quiero es leer una linea del archivo, para ello creo un objeto de la clase DataInputStream que es la que tiene el método
        para crear ese objeto necesito un objeto de la clase FileInputSream para que abra el archivo para lectura y lo cargue en memoria RAM
        "unreported exception FileNotFoundExceptrion; must be caught or declared to be thrown..."
        Nos obliga a someter a la linea a tratamiento de excepciones
        Si abrimos un archivo para lectura obligatoriamente tenemos que tratar la exception por si el archivo no existe
        porque lo obliga JAVA
        Para ello usamos el try y el catch*/
        System.out.println("Iniciando leerFichero");
        DataInputStream inStream;
        try{
            inStream = new DataInputStream(new FileInputStream(nombre));//con esto ya hemos abierto el archivo para lectura
            String total = "";
            String frase;
            int contador = 0;
            while((frase = inStream.readLine())!= null){//aparte de la comparación también asignamos a frase lo que hace la función readLine
            /*readLine coge el contenido de la primera linea y la pasa donde le digamos, además
                los archivos tienen un puntero que primero apunta a la primera linea, 
                pero cuando la lee, este método coge y pasa el puntero a la siguiente.*/
                total += frase + "\n"; //vamos poniendo cada frase más un retorno de carro para que pase a la siguinte línea.
                System.out.println("Leyendo linea " + contador);
                contador++;
            }
            System.out.println("Fichero leido");
            texto.setText(total);
            System.out.println("Fichero cargado");
        }catch(FileNotFoundException e){}//puede haber tantos catch como necesitemos
        catch(IOException e){};//readLine obliga a tratar una IOException
        
        //BufferedReader d = new BufferedReader(new InputStremReader(nombre));
    }
    
     public void guardarFichero(String nombre){
        System.out.println("Iniciando guardarFichero");
        DataOutputStream outStream;// instanciamos un objeto de la clase DataOutputSteam que nos permitirá abrir un archivo con intención de escribirlo
        try{
            outStream = new DataOutputStream(new FileOutputStream(nombre));
            outStream.writeBytes(texto.getText());
            System.out.println("fichero guardado");
        }catch(FileNotFoundException e){}//puede haber tantos catch como necesitemos
        catch(IOException e){};
        
        
    }
    
    public boolean handleEvent(Event ev){//todos los metodos de tratamiento de eventos devuelven un boolean
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(ev.id == Event.ACTION_EVENT){//un evento de acción, es decir, hacer click en el botón
            if(ev.target instanceof MenuItem){//instanceof sirve para comparar clases
                if(ev.arg.equals("Salir")){//Si el argumento, es decir, el texto es Salir
                    System.exit(0);
                    return true;
                }else if(ev.arg.equals("Nuevo")){
                    texto.setText(" ");
                    return true;
                }else if(ev.arg.equals("Abrir")){
                    abrirFichero.setVisible(true);
                    String nomFichero = abrirFichero.getDirectory() + "/" + abrirFichero.getFile();//nos devuelve el nombre del fichero
                    leerFichero(nomFichero);//llamamos a la función leer fichero a la que le pasamos el nombre del fichero
                    return true;
                }else if(ev.arg.equals("Guardar")){
                    guardarFichero.setVisible(true);
                    String nomFichero = guardarFichero.getDirectory() + "/" + guardarFichero.getFile();
                    guardarFichero(nomFichero);
                    return true;
                }
            }
        }
        return false;
    }
    
}
