/*
La recursividad: funciones que se llaman a si mismas.
Multiplicación mediante sumas
Todas las funciones recursivas deben tener una condición de finalización.
 */
package primera2223;


public class Ejercicio087 {
   public static void main(String arg[]){
       int multiplicando = 8;
       int multiplicador = 4;
       System.out.println("El resultado de multiplicar " + multiplicando + " y " +  multiplicador + " es: " + multiplicacion(multiplicando, multiplicador));
   } 
   
   
   public static int multiplicacion(int x, int y){
        if(y == 1)
            return x;
        else
            return x + multiplicacion(x, y-1);
   }
}
