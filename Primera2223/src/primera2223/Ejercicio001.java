/*
Primer ejercicio, declaración de variables y primer programa.
*/
/* esto sirve para insertar comentarios
de varias lineas
*/
//comentario de una linea 


package primera2223; //nos indica el directorio en el que se encuentra el programa
/* Java es un lenguaje Key Sensitive, es decir, discrimina entre mayúsculas
y minúsculas
*/

public class Ejercicio001 {

    public static void main(String arg[]) {
        /* el nombre del método "main"; a la izquierda lo que devuelve (void=
        nada) 
        modificador: "public" significa que se puede utilizar en otro paquete
        distinto al creado
        static: se puede acceder a el a traves del nombre de la clase
        
        Lo primero es declarar las variables, se declaran en la memoria RAM
            Almacenamiento temporal RAM
            Almacenamiento permanente SDD
        Cuando se declaran variables se hace en la memoria RAM, 
        se representa en casillas o celdas y cada una de ella tiene una 
        dirección de memoria (se escriben en exadecimal) y las celdas 
        se localizan en posiciones consecutivas 2AOO, 2A02, 2A04, 2A06…
        */
      int x; //declaras el tipo de dato
      /* Declaras el programa y se carga en la cpu, la cpu mira la primera 
      línea y ve que hay una x (un número entero)*/
      int y;
      int resultado;
      x = 55;//haciendo click en el numero de linea hacemos un "punto de ruptura"
      /* si esta a la derecha del igual es un valor, por lo que esta 
      instrucción ha reservado el valor 55 a la ram (el int es una 
      instrucción de variable)
      53 = 45 esto es absurdo
      siempre acabar frases con ;
      */
      y = 50; // = es el operador de asignación
      resultado = x + y;
      
      /*dos operadores, por lo tanto dos operaciones, dar orden y 
      + es el operador suma cuando lo pones entre dos valores numérico, 
      cuando uno de los valores no es numérico, se haría una concatenación
      
      A la izquierda tiene que haber un lugar, un hueco donde meter algo,
      una variable que hemos llamado resultado; lo de la derecha es un
      valor (x e y) si se pone una variable a la derecha del igual se le dice
      que coja su valor, no su variable; es decir que coja 55 para la "x"
      y 50 para la "y"
      primero hariamos la suma y luego le asignariamos el resultado a "resultado"*/
      
      System.out.print("El resultado es; " + resultado);
     
      /* instrucción para mostrar en pantalla, lo que pongas entre comillas sale
      como tal: es un STRING y tenemos un operador "+" que actuará como concatenador
      */
      
    }
    
}
